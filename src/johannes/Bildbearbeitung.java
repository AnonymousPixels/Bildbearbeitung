package johannes;

import java.awt.*;
import java.awt.geom.*;

public class Bildbearbeitung {

	public static Frame fenster;

	public static void main(String[] args) {

		fenster = new Rahmen("Bildbearbeitung mit Java", 380, 400) // Gute;
																	// Fensterbreiten:
																	// 1,
																	// Bild:380,
																	// 2;
																	// Bilder:
																	// 740,
																	// 3;
																	// Bilder:
																	// 1100
		{

			public void paint(Graphics grafik) {

				Graphics2D bildflaeche = (Graphics2D) grafik;
				AffineTransform at = new AffineTransform();

				// Ursprung der Bildflaeche im Fenster verschieben
				at.translate(20, 24 + 20); // Hoehe der Titelleiste = 24
				bildflaeche.transform(at);

				// Ursprung markieren
				grafik.drawLine(-10, 0, 10, 0);
				grafik.drawLine(0, -10, 0, 10);
				grafik.drawOval(-5, -5, 10, 10);

				// Erzeugung eines grauen Rauschbildes
				// Bild bild = new Bild(340, 340, Bild.GRUEN);
				// bild.zeichneBild(grafik, 0, 0);

				// Aufgabe 1: Lass Dir die Pixel vergroessert anzeigen und die
				// Werte eines Kanals

				// bild.zeichneGrossePixel(grafik, 0, 0);
				// bild.schreibeKanalWerte(grafik, 0, 0, 1);

				// Aufgabe 2: Implementiere ein farbiges Rausch-Bild
				// Bild bildrauschen = new Bild(340, 340, Bild.RGB);
				// bild.zeichneBild(grafik, 0, 0);

				// Aufgabe 3: Lade die Bilddatei "src/calvinandhobbes.jpg" und
				// lasse diese anzeigen
				BildIO bildio = new BildIO();
				Image image = bildio
						.ladeBild("src\\johannes\\calvinandhobbes.jpg");
				Bild imagebild = new BildIO().ladeFarbPixel(image);
//				imagebild.zeichneBild(grafik, 0, 0);

				// Aufgabe 3a: Lass Dir die einzelnen Farbkanaele der geladenen
				// Bilddatei separat anzeigen
				
				imagebild.separiereFarbe(new Farbe(Bild.GRUEN));
				imagebild.zeichneBild(grafik, 0, 0);
				// Aufgabe 4: Implementiere einen Negativfilter pro Farbkanal

				// Aufgabe 5: Implementiere einen Kontrastfilter

				// Aufgabe 6: Zeichne das geladene Bild weicher

				// Aufgabe 7: Implementiere den beschriebenen Filterkerne;
				// welchen Effekte haben sie?

				// Aufgabe 8: Implementiere das Differenzbild zwischen zwei
				// Bildern

				// Bonus-Aufgabe: Fallen Dir noch andere Randbehandlungen fuer
				// die Faltung ein (siehe Klasse Faltung)?

			}

		};

		fenster.setVisible(true);
	}
}
