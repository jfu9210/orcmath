package jenny;

import guiTeacher.GUIApplication;

public class CatalogMakerGUI extends GUIApplication {
	
	public CatalogMakerGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public void initScreen() {
		CatalogScreen screen = new CatalogScreen(getWidth(), getHeight());
		setScreen(screen);
	}

	public static void main(String[] args) {
		CatalogMakerGUI gui = new CatalogMakerGUI(800, 550);
		Thread go = new Thread(gui);
		go.start();
	}

}
