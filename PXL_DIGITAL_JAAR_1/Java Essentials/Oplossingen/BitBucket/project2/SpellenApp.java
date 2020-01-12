package project2;

import java.util.Scanner;

public class SpellenApp {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Uitgever u1 = new Uitgever("999 games", "Almere", 1990);
		BordSpel b1 = new BordSpel("Bonanza", u1);
		b1.setMinimumLeeftijd(12);
		u1.setWebsite("www.999games.nl");
		b1.setAantalSpelers(4);
		b1.setSpeelduur(45);
		System.out.println(b1.toString());
		
		System.out.println("\nHoeveel spelers evalueren het spel?");
		int aantalKeer = keyboard.nextInt();
		keyboard.nextLine();
		SpelEvaluatie[] evaluaties = new SpelEvaluatie[aantalKeer];
		for (int i = 0; i < aantalKeer; i++) {
			System.out.println("Geef speler naam:");
			String naam = keyboard.nextLine();
			System.out.println("Geef geboortejaar:");
			int geboortejaar = keyboard.nextInt();
			System.out.println("Geef uw score (0-5):");
			int score = keyboard.nextInt();
			keyboard.nextLine();
			System.out.println("Geef uw motivatie:");
			String motivatie = keyboard.nextLine();
			
			evaluaties[i] = new SpelEvaluatie(b1, new Speler(naam, geboortejaar));
			evaluaties[i].maakBeoordeling(score, motivatie);
		}
		
		System.out.println("Evaluatie " + b1.getNaam() + " " + u1.getNaam());
		int totaal = 0;
		for (int i = 0; i < evaluaties.length; i++) {
			String geldigheid;
			if (evaluaties[i].isGeldig()) {
				geldigheid = "+";
			} else {
				geldigheid = "-";
			}
			System.out.printf("%-10s %5s  %-10s %1s\n", evaluaties[i].getSpeler().getNaam(), evaluaties[i].getScore().getStars(), evaluaties[i].getMotivatie(), geldigheid);
			
			totaal += evaluaties[i].getScore().getStars().length();
			
		}
		totaal = totaal / aantalKeer;
		System.out.print("Totaalscore: ");
		for (int i = 0; i < totaal; i++) {
			System.out.print("*");
		}
		keyboard.close();
	}

}
