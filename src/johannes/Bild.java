package johannes;

import java.awt.*;

class Bild {

	static final int ROT = 0;
	static final int GRUEN = 1;
	static final int BLAU = 2;
	static final int GRAU = 3;
	static final int RGB = 4;

	int breite;
	int hoehe;
	int kanaele = 3;
	Farbe[][] pixel;

	// Konstruktoren

	// Erzeugt ein Bild je mit der uebergebenen Farbe initalisiert
	Bild(int breite, int hoehe, Farbe farbe) {

		this.breite = breite;
		this.hoehe = hoehe;
		pixel = new Farbe[breite][hoehe];
		for (int y = 0; y < hoehe; y++) {
			for (int x = 0; x < breite; x++) {
				pixel[x][y] = farbe;
			}
		}
	}

	// Erzeugt ein Bild als Kopie eines anderen Bildes
	Bild(Bild bild_eingabe) {

		this.breite = bild_eingabe.breite;
		this.hoehe = bild_eingabe.hoehe;
		pixel = new Farbe[breite][hoehe];
		for (int y = 0; y < hoehe; y++) {
			for (int x = 0; x < breite; x++) {
				pixel[x][y] = bild_eingabe.pixel[x][y];
			}
		}
	}

	// Erzeugt ein Rausch-Bild je nach uebergebener Rausch-Art (GRAU, RGB)
	Bild(int breite, int hoehe, int rauschen) {

		this.breite = breite;
		this.hoehe = hoehe;
		pixel = new Farbe[breite][hoehe];
		for (int y = 0; y < hoehe; y++) {
			for (int x = 0; x < breite; x++) {
				int zufallszahl = (int) (Math.random() * (256));
				// Aufgabe 1: Implementiere ein farbiges Rausch-Bild
				int r = (int) (Math.random() * (256));
				int g = (int) (Math.random() * (256));
				int b = (int) (Math.random() * (256));

				System.out.println();
				switch (rauschen) {
				case GRAU:
					pixel[x][y] = pixel[x][y] = new Farbe(zufallszahl,
							zufallszahl, zufallszahl);
					break;
				case RGB:
					// Aufgabe 1: Implementiere ein farbiges Rausch-Bild
					pixel[x][y] = pixel[x][y] = new Farbe(r, g, b);
					break;
				case ROT:
					pixel[x][y] = pixel[x][y] = new Farbe(255,0,0);
					break;
				case BLAU:
					pixel[x][y] = pixel[x][y] = new Farbe(0,0,255);
					break;
				case GRUEN:
					pixel[x][y] = pixel[x][y] = new Farbe(0,255,0);
					break;
				default:

				}

			}
		}
	}

	// Zeichne auf die Bildflaeche mit den Daten der Klasse (hoehe, breite,
	// pixel)
	// x0 und y0 geben die Position der Bildflaeche im Fenster an
	void zeichneBild(Graphics grafik, int x0, int y0) {

		for (int y = 0; y < hoehe; y++) {
			for (int x = 0; x < breite; x++) {
				// Dem Graphics Element wird die in pixel gespeicherte Farbe (
				// vom Typ Color (r,g,b)) uebergeben
				grafik.setColor(pixel[x][y]);
				grafik.drawLine(x0 + x, y0 + y, x0 + x, y0 + y);
			}
		}
	}

	// Zeichnet ein Bild mit den einzelnen Pixeln "aufgeblasen"
	void zeichneGrossePixel(Graphics grafik, int x0, int y0) {
		int groesse = 26;
		for (int y = 0; y < hoehe; y++) {
			for (int x = 0; x < breite; x++) {
				grafik.setColor(pixel[x][y]);
				grafik.fillRect(x0 + groesse * x, y0 + groesse * y,
						groesse - 1, groesse - 1);
			}
		}
	}

	// Zeichnet ein Bild mit den einzelnen Pixeln "aufgeblasen"
	// Zeigt ausserdem den Grauwert des jeweilige Pixels an
	void schreibeKanalWerte(Graphics g, int x0, int y0, int kanal) {
		int groesse = 26; // nicht aendern!
		for (int y = 0; y < hoehe; y++) {
			for (int x = 0; x < breite; x++) {
				g.setColor(Color.black);
				g.drawRect(x0 + groesse * x, y0 + groesse * y, groesse - 1,
						groesse - 1);
				if (farbWert(x, y, kanal) < 10)
					g.drawString("   " + farbWert(x, y, kanal), x0 + groesse
							* x, y0 + groesse * y + 17);
				else if (farbWert(x, y, kanal) < 100)
					g.drawString("  " + farbWert(x, y, kanal),
							x0 + groesse * x, y0 + groesse * y + 17);
				else
					g.drawString(" " + farbWert(x, y, kanal), x0 + groesse * x,
							y0 + groesse * y + 17);
			}
		}
	}

	// Helfer-Funktion, um auf einen bestimmten Farbkanal von der Farbe in
	// pixel[x][y]
	// �ber einen Index zuzgreifen
	int farbWert(int x, int y, int kanal) {
		int value = 0;
		switch (kanal) {
		case ROT:
			value = pixel[x][y].getRed();
			break;
		case GRUEN:
			value = pixel[x][y].getGreen();
			break;
		case BLAU:
			value = pixel[x][y].getBlue();
			break;
		default:
		}

		return value;
	}

	// Helfer-Funktion, um einen bestimmten Farbkanal von der Farbe in
	// pixel[x][y]
	// �ber einen Index zusetzen
	void setzteFarbWert(int x, int y, int kanal, int wert) {
		// Falls die Eingabe kein gueltiger Farbwert war, passe den Wert an
		if (wert < 0) {
			wert = 0;
		} else if (wert > 255) {
			wert = 255;
		}

		switch (kanal) {
		case ROT:
			pixel[x][y] = new Farbe(wert, pixel[x][y].getGreen(),
					pixel[x][y].getBlue());
			break;
		case GRUEN:
			pixel[x][y] = new Farbe(pixel[x][y].getRed(), wert,
					pixel[x][y].getBlue());
			break;
		case BLAU:
			pixel[x][y] = new Farbe(pixel[x][y].getRed(),
					pixel[x][y].getGreen(), wert);
			break;
		default:
		}
	}

	Bild separiereFarbe(int kanal) {
		Bild separiertesBild = new Bild(breite, hoehe, Farbe.weiss);
		switch (kanal) {

		case ROT:
			for (int y = 0; y < hoehe; y++) {
				for (int x = 0; x < breite; x++) {
					separiertesBild.pixel[x][y] = new Farbe(
							farbWert(x, y, ROT), 0, 0);
				}
			}
			break;
		case GRUEN:
			for (int y = 0; y < hoehe; y++) {
				for (int x = 0; x < breite; x++) {
					separiertesBild.pixel[x][y] = new Farbe(0, farbWert(x, y,
							GRUEN), 0);
				}
			}
			break;
		case BLAU:
			for (int y = 0; y < hoehe; y++) {
				for (int x = 0; x < breite; x++) {
					separiertesBild.pixel[x][y] = new Farbe(0, 0, farbWert(x,
							y, BLAU));
				}
			}
			break;
		case GRAU:
			for (int y = 0; y < hoehe; y++) {
				for (int x = 0; x < breite; x++) {
					// Typische Umrechnung von Farbe zu Grau
					int grau = (int) ((0.299 * farbWert(x, y, ROT))
							+ (0.587 * farbWert(x, y, GRUEN)) + (0.114 * farbWert(
							x, y, BLAU)));
					separiertesBild.pixel[x][y] = new Farbe(grau, grau, grau);
				}
			}
		default:
		}
		return separiertesBild;
	}

	void checkeFarbeFuerPixel(int x, int y) {
		for (int kanal = 0; kanal < 3; kanal++) {
			if (farbWert(x, y, kanal) < 0) {
				setzteFarbWert(x, y, kanal, 0);
			} else if (farbWert(x, y, kanal) > 255) {
				setzteFarbWert(x, y, kanal, 255);
			}
		}
	}

}
