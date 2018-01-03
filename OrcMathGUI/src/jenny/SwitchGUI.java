package jenny;

import java.awt.Color;
import java.awt.Font;
import java.io.File;

import guiTeacher.GUIApplication;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;

public class SwitchGUI extends GUIApplication {

	public static SwitchGUI gui;
	public static FrontScreen front;
	public static BackScreen back;

	public SwitchGUI(int width, int height) {
		super(width, height);
		setIconImage(new Graphic(0, 0, 25, 25, "resources/TWICE_LOGO.png").getImage());
		setVisible(true);
	}

	public void initScreen() {
		try {
			File fontFile = new File("resources/Christmas.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont = font.deriveFont(29f);
			StyledComponent.setBaseFont(baseFont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		back = new BackScreen(getWidth(), getHeight());
		front = new FrontScreen(getWidth(), getHeight());
		setScreen(front);
	}

	public static void main(String[] args) {
		gui = new SwitchGUI(440, 640);
		Thread go = new Thread(gui);
		go.start();
	}
}
