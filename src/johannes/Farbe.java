package johannes;import java.awt.*;


public class Farbe extends Color 
{
	
	static final int ROT = 0;
	static final int GRUEN = 1;
	static final int BLAU = 2;
	
	static final Farbe weiss = new Farbe(255);
	static final Farbe schwarz = new Farbe(0);

	
	// Konstruktoren
	// Default Konstruktor
	Farbe()
	{
		super(0,0,0);
	}
	
	Farbe(int r, int g, int b)
	{
		super(r,g,b);
	}
	Farbe(int f)
	{
		super(f,f,f);
	}

	Farbe(Farbe farbe)
	{
		super(farbe.getRed(), farbe.getGreen(), farbe.getBlue());
	}
	
	Farbe(Color color)
	{
		super(color.getRed(), color.getGreen(), color.getBlue());
	}
	
	
	// Hilfsfunktionen
	static Farbe setzteKanalWert(Farbe farbe, int kanal, int wert) 
	{

		// Falls die Eingabe kein gueltiger Farbwert ist, passe den Wert an
		if (wert  < 0)
		{	
			wert = 0;
		}
		else if (wert > 255)
		{	
			wert = 255;
		}
	
	
		switch (kanal) 
		{
		case ROT:	
				farbe = new Farbe(wert, farbe.getGreen(), farbe.getBlue());
			break;
		case GRUEN:
			farbe = new Farbe(farbe.getRed(), wert, farbe.getBlue());
			break;
		case BLAU:
			farbe = new Farbe(farbe.getRed(), farbe.getGreen(), wert);
			break;
		default:
		}
		return farbe;
	}
	
	// Falls die Eingabe kein gueltiger Farbwert war, passe den Wert an
	static int checkeFarbWert(int wert)
	{
		if (wert  < 0)
		{	
			wert = 0;
		}
		else if (wert > 255)
		{	
			wert = 255;
		}
		return wert;
	}
	
	
	
	static Farbe subtraktion(Farbe f0, Farbe f1) 
	{
		int r = Math.max(0, (int) (f0.getRed()  - f1.getRed()));
		int g = Math.max(0, (int) (f0.getGreen()  - f1.getGreen()));
		int b = Math.max(0, (int) (f0.getBlue()  - f1.getBlue()));
		return new Farbe(r,g,b);
	}

	static Farbe subtraktion(int wert, Farbe f) 
	{
		int r = Math.max(0, (int) (wert - f.getRed()));
		int g = Math.max(0, (int) (wert - f.getGreen()));
		int b = Math.max(0, (int) (wert  - f.getBlue()));
		return new Farbe(r,g,b);
	}
	
	static Farbe subtraktion(Farbe f, int wert) 
	{
		int r = Math.max(0, (int) (f.getRed() - wert));
		int g = Math.max(0, (int) (f.getGreen() - wert));
		int b = Math.max(0, (int) (f.getBlue() - wert));
		return new Farbe(r,g,b);
	}

	static Farbe addition(Farbe f, double wert) 
	{
		int r = Math.min(255, (int) (f.getRed()  + wert));
		int g = Math.min(255, (int) (f.getGreen()  + wert));
		int b = Math.min(255, (int) (f.getBlue()  + wert));
		return new Farbe(r,g,b);
	}
	
	static Farbe multiplikation(Farbe f, double wert) 
	{
		int r = Math.min(255, (int) (f.getRed()  * wert));
		int g = Math.min(255, (int) (f.getGreen()  * wert));
		int b = Math.min(255, (int) (f.getBlue()  * wert));
		return new Farbe(r,g,b);
	}
	
}
