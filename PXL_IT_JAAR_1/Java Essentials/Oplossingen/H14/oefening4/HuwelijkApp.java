package oefening4;

public class HuwelijkApp {

	public static void main(String[] args) {

		try {
			Datum datum1 = new Datum();
			System.out.println(datum1.getDag());
			Datum datum2 = new Datum(datum1);

			Gemeente gem = new Gemeente(555555, "hE78rk-7dE-Stad");
			System.out.println(gem.toString());

			Adres adres = new Adres("kerkstraat", "12b", 3290, "Diest");
			adres.getGemeente().setGemNaam("Sharphill");
			System.out.println(adres.toString());

			Persoon persoon1 = new Persoon();
			Persoon persoon2 = new Persoon();
			persoon1.getAdres().getGemeente().setGemNaam("Leuven");
			persoon2.getGeboortedatum().setJaar(1999);

			System.out.println(persoon1.toString());
			System.out.println(persoon2.toString());

			Huwelijk huwelijk1 = new Huwelijk();
			huwelijk1.getHuwelijksdatum().getJaar();
			System.out.println(huwelijk1.getPersoon1().toString());
			huwelijk1.adresWijziging("straatje", "22", 3270, "Bekkevoort");
			huwelijk1.print();
		} catch (DatumException ex) {
			System.out.println("Error! DatumException triggered");
		}
	}

}
