package myStuff;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonJane extends Button implements ButtonInterfaceJenny{
	private Color orginal;
	public ButtonJane(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, "", null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setColor(Color color) {
		this.setColor(color);
		orginal = color;
		update();
	}

	@Override
	public void dim() {
		this.setColor(orginal.darker());
		update();
	}

	@Override
	public void highlight() {
		this.setColor(orginal.brighter());
		update();
	}
	
	public void drawButton(Graphics2D g, boolean hover) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, curveX, curveY);
		if(hover) {
			g.setColor(getForeground());
			g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, curveX, curveY);
		}
		else{
			g.setColor(Color.lightGray);
			g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, curveX, curveY);
		}
		update();	

}
}