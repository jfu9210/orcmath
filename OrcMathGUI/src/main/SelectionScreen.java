package main;

import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

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
		background = new Graphic(0, 0, "resources/spaceAnimal.jpg");
		viewObjects.add(background);
	}
	
	public void addButtons(List<Visible> viewObjects) {
		
	}
}
