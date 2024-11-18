package pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.generator;

import java.util.ArrayList;
import java.util.List;

import pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.NapedzanyStatekPowietrzny;
import pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.Samolot;
import pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.Smiglowiec;
import pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.Spadochron;
import pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.SpadochronRatowniczy;
import pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.StatekPowietrzny;
import pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.Szybowiec;

public class GeneratorStatkowPowietrznych {

	public static List<StatekPowietrzny> generujWszystkieStatkiPowietrzne() {
		List<StatekPowietrzny> result = new ArrayList<StatekPowietrzny>();

		result.add(new Spadochron("Icarus Nano Reserve NANO 113 ", 10, 12.5, 80));
		
		result.add(new Szybowiec("PZL M-3 Pliszka", 307, 180, 25));
		
		result.add(new Spadochron("Icarus Nano Reserve NANO 176", 12, 20, 110));
		
		result.add(new Szybowiec("PW-5 Smyk", 300, 220, 33));
		
		result.add(new SpadochronRatowniczy("S-4", 12, 52, 100, true, 60));
		
		result.add(new Spadochron("Performance Optimum-143", 11, 15.8, 85));
		
		result.add(new Szybowiec("SZD-32 Foka", 256, 250, 36));
		
		result.add(new Spadochron("Performance Optimum-143", 11, 15.8, 85));

		result.add(new SpadochronRatowniczy("SP-6", 7, 40, 100, false, 100));
		
		result.add(new Szybowiec("PZL M-8 Pelikan", 420, 250, 29));
		
		result.add(new Szybowiec("SZD-9bis Bocian", 330, 200, 26));
		
		result.add(new SpadochronRatowniczy("ATL-90", 8, 36, 100, false, 70));
		
		result.add(new SpadochronRatowniczy("ATL-90", 8, 36, 100, false, 70));

		result.add(new Szybowiec("PZL KR-03 Puchatek", 540, 200, 25));
		
		result.add(new Szybowiec("PZL-103", 226, 250, 32));
		
		result.add(new Szybowiec("SZD-50 Puchacz", 368, 215, 30));
		
		result.addAll(generujNapedzaneStatkiPowietrzne());

		return result;
	}

	public static List<NapedzanyStatekPowietrzny> generujNapedzaneStatkiPowietrzne() {
		List<NapedzanyStatekPowietrzny> result = new ArrayList<>();

		result.add(new Samolot("Messerschmitt Bf 109", 2450, 690, 10.8d, 16.40d, 10500));	
		
		result.add(new Samolot("Mitsubishi A6M", 2674, 730, 10, 22.44d, 10100));		
		
		result.add(new Samolot("MiG-15", 5700, 1424, 100.1, 20.6, 15545));		
		
		result.add(new Samolot("Saab JA-37 Viggen", 22500, 2090, 150, 52.20, 18000));	
		
		result.add(new Samolot("MiG-21", 8950, 1100, 225, 23, 19000));
		
		result.add(new Smiglowiec("Boeing AH-64 Apache", 9525, 482, 12.7, 14.63));
		
		result.add(new Smiglowiec("Bell AH-1 Cobra", 4535, 510, 8.2, 14.63));
		
		result.add(new Samolot("Dassault Mirage 5", 13500, 2400, 105, 34.85, 17000));
		
		result.add(new Samolot("F-4", 13757, 2600, 210, 49.2, 18300));	
		
		result.add(new Smiglowiec("Boeing CH-47 Chinook", 22668, 741, 10, 18.3));
		
		result.add(new Samolot("Dassault Rafale", 23800, 3700, 333, 45.70, 16800));
		
		result.add(new Samolot("MiG-29", 18480, 1750, 330, 38, 17500));		
		
		result.add(new Samolot("Saab JAS 39 Gripen", 14000, 1200, 100, 30, 18000));	
		
		result.add(new Smiglowiec("Mi-46", 25000, 400, 11.1, 27.6));
		
		result.add(new Samolot("MiG-29", 18480, 1750, 330, 38, 17500));	
		
		result.add(new Smiglowiec("Mi-8", 12000, 450, 12, 21.91));
		
		result.add(new Smiglowiec("Eurocopter Tiger", 6000, 740, 21, 13));
			
		result.add(new Samolot("Eurofighter Typhoon", 23000, 3706, 315, 50, 18300));		
			
		result.add(new Samolot("Dassault Mirage 2000", 9000, 3900, 249, 41.1, 19800));	
		
		result.add(new Smiglowiec("AgustaWestland AW101", 14600, 550, 20, 18.5));
		
		result.add(new Smiglowiec("Ka-52", 11300, 460, 8, 14.5));
		
		result.add(new Smiglowiec("Agusta A129 Mangusta", 4100, 410, 11, 11.9));
		
		result.add(new Samolot("Lockheed F-22 Raptor", 36288, 2900, 300, 78.04d, 19300));	
		
		result.add(new Smiglowiec("Mi-2", 2375, 270, 4.6, 14.5));
		
		return result;
	}

}
