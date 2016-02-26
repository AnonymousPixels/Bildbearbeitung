package johannes;

import java.awt.*;
import java.awt.event.*;

public class Rahmen extends Frame {

	public Rahmen(String titel, int breite, int hoehe) {
		super(titel);
		setSize(breite, hoehe);
		zentriere();

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}

	private void zentriere() {
		Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize();
		int x = (screen_size.width - frameSize.width) / 2;
		int y = (screen_size.height - frameSize.height) / 2;
		setLocation(x, y);
	}
}
