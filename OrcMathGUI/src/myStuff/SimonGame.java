package myStuff;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonGame extends ClickableScreen implements Runnable {

	private TextLabel label;
	private TextArea text;
	private Button[] buttons;
	private String[] blabel;
	private ArrayList<String> sequence;
	
	private boolean acceptingInput;
	private int sequenceIndex;
	public String last;

	public SimonGame(int width, int height) {
		super(width, height);
		
		Thread app = new Thread(this);
		app.start();
	}

	public void run(){
		label.setText("");
		text.setText("");
		nextRound();
	}

	public void nextRound() {
		label.setText("");
		text.setText("");
		playSequence();

		acceptingInput = true;
		sequenceIndex = 0;
	}

	public void playSequence() {
		String color = random();
		sequence.add(color);
		last = color;
		text.setText(sequence.get(sequence.size() - 1));
	}
	
	public String random() {
		int index = (int) (Math.random() * blabel.length);
		String test = blabel[index];
		while(last.equals(test)) {
			index = (int) (Math.random() * blabel.length);
		}
		return test;
	}

	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(Button b: buttons){ 
			viewObjects.add(b); 
		}
		
		label = new TextLabel(500, 230,300,40,"Let's play Simon!");
		viewObjects.add(label);
		
		text = new TextArea(500, 300, 300, 1000, "");
		viewObjects.add(text);

		sequence = new ArrayList<String>();
		last = "";
	}
	
	public void addButtons() {
		int numberOfButtons = 5;
		buttons = new Button[numberOfButtons];
		Color[] colorList = {Color.PINK, Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN};
		String[] l = {"pink","red","orange","yellow","green"};
		blabel = l;
		for(int i = 0; i < numberOfButtons; i++) {
			final Button b = new Button(getX(), getY(), 100, 100, blabel[i], null);
			b.setBackground(colorList[i]); 
			b.setX(100);
			b.setY(50+40*i);
			b.setAction(new Action(){
				public void act(){
					if(acceptingInput){
						if(b.getText().equals(sequence.get(sequenceIndex)))
							sequenceIndex++;
						else 
							gameOver();
						if(sequenceIndex == sequence.size()){ 
							Thread nextRound = new Thread(SimonGame.this); 
							nextRound.start(); 
						}
					}
				}
			});
			buttons[i] = b;
		}
	}

	public void gameOver() {
		label.setText("GAME OVER!");
		acceptingInput = false;
	}
}
