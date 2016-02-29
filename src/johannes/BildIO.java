package johannes;import java.awt.*;
import java.awt.image.*;

public class BildIO 
{

	private static Component comp = new Component() {};
	private static MediaTracker mt = new MediaTracker(comp);

	public static Image ladeBild(String pfad) 
	{
		Image image = Toolkit.getDefaultToolkit().getImage(pfad);
		mt.addImage(image, 0);
		try 
		{
			mt.waitForAll();
		}
		catch (InterruptedException e) 
		{
			System.out.println(" Fehler: Bild konnte nicht geladen werden");
		}
		return image;
	}

	public static Bild ladeFarbPixel(Image image) 
	{
		int breite = image.getWidth(null);
		int hoehe = image.getHeight(null);
		// System.out.println("Breite: " + breite + " hoehe: " + hoehe);
		int[] pixelReihung = new int[breite * hoehe];
		PixelGrabber pg = new PixelGrabber(image, 0, 0, breite, hoehe, pixelReihung, 0, breite);
		try 
		{
			pg.grabPixels();
		}
		catch (InterruptedException e) 
		{
			System.out.println(" Fehler: Pixel konnten nicht extrahiert werden");
		}
		/*
    for (int i = 0;i < breite*hoehe ;i++ ) {
      System.out.print(" " + pixelReihung[i]);
    }
		 */
		Bild bild = new Bild(breite, hoehe, Farbe.weiss);
		for (int y = 0; y < hoehe; y++) 
		{
			for (int x = 0; x < breite; x++) 
			{
				bild.pixel[x][y] = new Farbe(new Color(pixelReihung[breite * y + x]));
				//System.out.print(/*" " + pixelReihung[breite * y + x] + */" " + bild.pixel[x][y]);
			}
		}
		return bild;
	}

}

