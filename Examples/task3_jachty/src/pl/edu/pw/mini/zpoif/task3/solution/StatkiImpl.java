package pl.edu.pw.mini.zpoif.task3.solution;

import pl.edu.pw.mini.zpoif.task3.generator.GeneratorStatkow;
import pl.edu.pw.mini.zpoif.task3.model.StatekNawodny;
import pl.edu.pw.mini.zpoif.task3.model.jacht.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StatkiImpl implements Statki1 {

    private List<StatekNawodny> statki = GeneratorStatkow.generujStatkiNawodne();

    @Override
    public StatekNawodny getNajciezszyStatek() {
        return statki.stream().max(Comparator.comparingInt(StatekNawodny::getMasa)).orElseThrow();
    }

    @Override
    public StatekNawodny getStatekONajdluzszejNazwieProducentaNaR() {
        return statki.stream().filter(statekNawodny -> statekNawodny.getNazwaProducenta().startsWith("R")).max(
                Comparator.comparingInt(s -> s.getNazwaProducenta().length())).orElseThrow();
    }

    @Override
    public JachtMotorowy getJachtMotorowyONajwiekszejMocySilnika() {
        return statki.stream().filter(statekNawodny -> statekNawodny instanceof JachtMotorowy).map(
                statekNawodny -> (JachtMotorowy) statekNawodny).max(
                Comparator.comparingInt(JachtMotorowy::getMocSilnika)).orElseThrow();
    }

    @Override
    public JachtKabinowy getLekkiJachtKabinowyONajmniejszymOzaglowaniu() {
        return statki.stream().filter(
                statekNawodny -> statekNawodny instanceof JachtKabinowy & statekNawodny.getMasa() <= 1000).map(
                statekNawodny -> (JachtKabinowy) statekNawodny).min(
                Comparator.comparingDouble(JachtZaglowy::getPowierzchniaZagla)).orElseThrow();
    }

    @Override
    public Set<StatekNawodny> getCoNajwyzej11DlugichICiezkichJachtow() {
        return statki.stream().filter(
                statekNawodny -> statekNawodny instanceof Jacht & statekNawodny.getMasa() >= 1400 &
                        statekNawodny.getDlugosc() > 700).limit(11).collect(Collectors.toSet());
    }

    @Override
    public List<StatekNawodny> getStatkiPosortowaneWzgledemDlugosciBez2() {
        return statki.stream().skip(2).sorted(Comparator.comparingInt(StatekNawodny::getDlugosc).reversed()).collect(
                Collectors.toList());
    }

    @Override
    public List<JachtZaglowy> getPierwsze8ZPosortowanychWzgledemOzaglowaniaBezTrzechPierwszych() {
        return statki.stream().filter(statekNawodny -> statekNawodny instanceof JachtZaglowy).map(
                statekNawodny -> (JachtZaglowy) statekNawodny).sorted(
                Comparator.comparingDouble(JachtZaglowy::getPowierzchniaZagla).reversed()).skip(2).limit(8).collect(
                Collectors.toList());
    }

    @Override
    public void oznaczJachtyDobreNaPlycizny() {
        this.statki = statki.stream().map(s -> {
            if (s instanceof JachtKabinowy & s.getMasa() <= 1300) {
                JachtKabinowy jachtKabinowy = (JachtKabinowy) s;
                if (jachtKabinowy.getZanurzenie() <= 30) {
                    jachtKabinowy.setKomentarz("Jachtem " + jachtKabinowy.getTyp() + " wplyniesz na kazda plycizne!");
                }
                return jachtKabinowy;
            }
            return s;
        }).collect(Collectors.toList());
    }

    @Override
    public String get12UnikalnychNazwTypow() {
        return statki.stream().filter(statekNawodny -> statekNawodny instanceof Jacht & statekNawodny.getMasa() > 2000)
                .map(statekNawodny -> (Jacht) statekNawodny).skip(3).map(Jacht::getTyp).distinct().limit(12).collect(
                        Collectors.joining("-"));
    }

    @Override
    public Map<String, JachtMotorowy> getMapaJachtowMotorowych() {
        return statki.stream().filter(statekNawodny -> statekNawodny instanceof JachtMotorowy).map(
                statekNawodny -> (JachtMotorowy) statekNawodny).collect(
                Collectors.toMap(Jacht::getTyp, Function.identity(), (stary, nowy) -> {
                    if (stary.getNazwaProducenta().length() > nowy.getNazwaProducenta().length()) {
                        return stary;
                    }
                    return nowy;
                }));
    }

    @Override
    public List<Jacht> getJachtyOdkrytopokladoweIMotoroweJednePoDrugich() {
        List<Jacht> result = new ArrayList<>(statki.stream().filter(s -> s instanceof JachtOdkrytopokladowy)
                .map(s -> (Jacht) s).limit(10).toList());
        result.addAll(statki.stream().filter(s -> s instanceof JachtMotorowy).map(s -> (Jacht) s).filter(
                s -> s.getNazwaProducenta().equalsIgnoreCase("regal")).skip(4).limit(4).toList());
        return result;
    }

}
