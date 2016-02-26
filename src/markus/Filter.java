package markus;import java.awt.Color;


public class Filter {

	static Bild negativ(Bild bild, int kanal) 
	{
		Bild negativBild = new Bild(bild);

		int wert = 0;
		for (int y = 0; y < bild.hoehe; y++) 
		{
			for (int x = 0; x < bild.breite; x++) 
			{
				// Aufgabe 4: Implementiere einen Negativfilter fuer den uebergebenen Farbkanal

			}
		}
		return negativBild;
	}

	static Bild kontrast(Bild bild, int minHelligkeit, int maxHelligkeit) 
	{
		Bild bild_bearbeitet = new Bild(bild.breite, bild.hoehe,Farbe.weiss);

		// Aufgabe 5: Implementiere einen Kontrastfilter

		for (int y = 0; y < bild.hoehe; y++) 
		{
			for (int x = 0; x < bild.breite; x++) 
			{
				// Aufgabe 5: Implementiere einen Kontrastfilter

				
			}
		}
		return bild_bearbeitet;
	}


	static Bild differenz(Bild bild_0, Bild bild_1) 
	{
		// Aufgabe 8: Implementiere das Differenzbild zwischen zwei Bildern
		Bild bild_bearbeitet = new Bild(bild_0);

		return bild_bearbeitet;
	}

}
