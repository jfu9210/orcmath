package jenny;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class CustomButton extends Button {
	
	private String s1;
	private String s2;
	private Color color;

	public CustomButton(int x, int y) {
		super(x, y, 50, 50, "", null);
	}
	
	public void drawButton(Graphics2D g, boolean hover){
		g.setColor(Color.BLACK);
		g.drawString(s1, 20, 20);
		g.drawString(s2, 20, 40);
		
		g.setColor(color);
		g.drawRect(20, 70, 20, 20);
		g.fillRect(20, 70, 20, 20);
	}
	
	public void updateString1(String string) {
		s1 = string;
	}

	public void updateString2(String string) {
		s2 = string;
	}

	public void setIconColor(Color color) {
		this.color = color;
	}
}
