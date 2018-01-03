package jenny;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.Graphic;
import guiTeacher.components.MovingComponent;

public class TwiceLogo extends MovingComponent {
	
	private BufferedImage img;
	private int topToBottom;
	private int leftToRight;
	
	public TwiceLogo(int w, int h) {
		super((int)(Math.random()*w), (int)(Math.random()*h), 30, 30);
		topToBottom = h;
		leftToRight = w;
		img = new Graphic(0, 0, 30, 30, "resources/sana.png").getImage();
		setVy(1.5+Math.random()*4.0);
		update();
		Thread t = new Thread(this);
		t.start();
	}

	public void drawImage(Graphics2D g) {
		if(img != null){
			g.drawImage(img, 0, 0, null);
		}
	}
	
	public void checkBehaviors() {
		if(getY()-getHeight()>topToBottom){
			setY(0);
			setVy(1.5+Math.random()*4.0);
			setX((int)(Math.random()*leftToRight));
		}
	}

}
