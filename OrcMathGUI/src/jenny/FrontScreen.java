package jenny;

import java.awt.Color;
import java.util.List;

import org.w3c.dom.css.RGBColor;

import guiTeacher.components.*;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class FrontScreen extends FullFunctionScreen {
	
	private Button button;
	private Graphic image;

	public FrontScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		image = new Graphic(0, 20, 800, 600, "resources/front.jpg");
		viewObjects.add(image);
		
		button = new Button(170, 470, 80, 80, "Open", new Action() {
			public void act() {
				SwitchGUI.gui.setScreen(SwitchGUI.back);
			}
		});
		button.setForeground(new Color(213, 13, 41));
		viewObjects.add(button);
		
		for(int i = 0; i < 8; i++){
			viewObjects.add(new TwiceLogo(getWidth(), getHeight()));
		}
	}
}
