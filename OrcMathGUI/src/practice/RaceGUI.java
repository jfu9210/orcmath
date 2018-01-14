package practice;

import guiTeacher.GUIApplication;

public class RaceGUI extends GUIApplication {

	public RaceGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public void initScreen() {
		RaceScreen screen = new RaceScreen(getWidth(), getHeight());
		setScreen(screen);
	}

	public static void main(String[] args) {
		RaceGUI gui = new RaceGUI(500, 500);
		Thread go = new Thread(gui);
		go.start();
	}
}
