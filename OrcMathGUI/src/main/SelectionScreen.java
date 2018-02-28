package main;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.CustomImageButton;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class SelectionScreen extends FullFunctionScreen {
	
	private Graphic background;
	private ArrayList<CustomImageButton> buttons;

	public SelectionScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		background = new Graphic(0, 0, "resources/");
		viewObjects.add(background);
	}
}
