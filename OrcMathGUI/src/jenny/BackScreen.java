package jenny;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class BackScreen extends FullFunctionScreen {
	
	private Graphic image;
	private Button button;

	public BackScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		image = new Graphic(0, 20, 800, 600, "resources/back.jpg");
		viewObjects.add(image);
		
		button = new Button(170, 497, 80, 80, "close", new Action() {
			public void act() {
				SwitchGUI.gui.setScreen(SwitchGUI.front);
			}
		});
		button.setForeground(new Color(213, 13, 41));
		viewObjects.add(button);
	}

}
