package myStuff;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.interfaces.Clickable;

public interface ButtonInterfaceJenny extends Clickable {
	
	void setColor(Color color);
	void setAction(Action a);
	void dim();
	void highlight();
	void setOn(boolean b);
}
