package max;import java.awt.*;


public class Faltung 
{
	double[][] kern = new double[3][3];

	Faltung(double k00, double k10, double k20,
			double k01, double k11, double k21,
			double k02, double k12, double k22) 
			{

		kern[0][0] = k00;
		kern[1][0] = k10;
		kern[2][0] = k20;
		kern[0][1] = k01;
		kern[1][1] = k11;
		kern[2][1] = k21;
		kern[0][2] = k02;
		kern[1][2] = k12;
		kern[2][2] = k22;
			}

	Bild falte(Bild bild) 
	{

		Bild bild_gefaltet = new Bild(bild);

		Farbe summe;
		int summe_kanal;

		// Der Rand des Bildes, dort wo der Faltunskern ueber den Bildrand hinaus
		// gehen wuerde, wird nicht gefaltet
		
		// Aufgabe 9: Fallen Dir noch andere Randbehandlungen fuer die Faltung ein?
		for (int y = 1; y < bild.hoehe - 1; y++) 
		{
			for (int x = 1; x < bild.breite - 1; x++) 
			{
				summe = Farbe.schwarz; // alle Kanaele = 0
				for (int kanal = 0; kanal < bild.kanaele; kanal++) 
				{
					summe_kanal = 0;
					for (int j = -1; j <= 1; j++) 
					{
						for (int i = -1; i <= 1; i++) 
						{
							//Nachkommastellen werden abgeschnitten
							summe_kanal += (int) (bild.farbWert((x + i),(y + j),kanal) * kern[i + 1][j + 1]);
						}
					}
					summe = Farbe.setzteKanalWert(summe, kanal, summe_kanal) ;
				}
				bild_gefaltet.pixel[x][y] = summe; 
				bild_gefaltet.checkeFarbeFuerPixel(x, y);
			}
		}
		return bild_gefaltet;
	}
}
