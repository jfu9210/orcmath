package main;

import guiTeacher.GUIApplication;

public class Main extends GUIApplication {
	
	private static SelectionScreen screen;
	private static Main gui;

	public Main(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public void initScreen() {
		screen = new SelectionScreen(getWidth(), getHeight());
		setScreen(screen);
	}

	public static void main(String[] args) {
		gui = new Main(1920, 1080);
		Thread run = new Thread(gui);
		run.start();
	}

}
