package pl.edu.pw.mini.zpoif.task3.solution;

public class Demonstrator {

    public static void main(String[] args) {

        StatkiImpl statki = new StatkiImpl();

        // 1
        System.out.println(statki.getNajciezszyStatek());

        // 2
        System.out.println(statki.getStatekONajdluzszejNazwieProducentaNaR());

        // 3
        System.out.println(statki.getJachtMotorowyONajwiekszejMocySilnika());

        // 4
        System.out.println(statki.getLekkiJachtKabinowyONajmniejszymOzaglowaniu());

        // 5
        System.out.println(statki.getCoNajwyzej11DlugichICiezkichJachtow());

        // 6
        System.out.println(statki.getStatkiPosortowaneWzgledemDlugosciBez2());

        // 7
        System.out.println(statki.getPierwsze8ZPosortowanychWzgledemOzaglowaniaBezTrzechPierwszych());

        // 8
        statki.oznaczJachtyDobreNaPlycizny();

        // 9
        System.out.println(statki.get12UnikalnychNazwTypow());

        // 10
        System.out.println(statki.getMapaJachtowMotorowych());

        // 11
        System.out.println(statki.getJachtyOdkrytopokladoweIMotoroweJednePoDrugich());

    }



}
