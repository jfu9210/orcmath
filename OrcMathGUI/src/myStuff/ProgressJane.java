package myStuff;

import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class ProgressJane extends Component implements ProgressInterfaceJenny {

	private int round;
	private int sequence;
	
	public ProgressJane(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRound(int i) {
		round=i;
		
	}

	@Override
	public void setSequenceSize(int i) {
		sequence = i;
		
	}

	@Override
	public void update(Graphics2D g) {
		update(g);
	}
	
	public ProgressJane getProgress() {
		return this;
	}
}
