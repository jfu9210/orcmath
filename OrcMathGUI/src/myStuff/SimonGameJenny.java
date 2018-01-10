package myStuff;

import guiTeacher.GUIApplication;

public class SimonGameJenny extends GUIApplication {

	public SimonGameJenny(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public void initScreen() {
		SimonGame screen = new SimonGame(getWidth(), getHeight());
		setScreen(screen);
	}

	public static void main(String[] args) {
		SimonGameJenny gui = new SimonGameJenny(1000, 600);
		Thread go = new Thread(gui);
		go.start();
	}

}
