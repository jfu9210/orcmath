package myStuff;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonGame extends ClickableScreen implements Runnable {

	private TextLabel label;
	private TextLabel text;
	private Button[] buttons;
	private String[] blabel;
	private ArrayList<String> sequence;
	

	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;

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
		acceptingInput = false;
		roundNumber++;
		
		changeLabel("Simon's turn");
		label.setText("");
		text.setText("");
		playSequence();

		changeLabel("Your turn");
		acceptingInput = true;
		sequenceIndex = 0;
	}

	public void playSequence() {
		sequence.add(blabel[(int)(Math.random() * blabel.length)]);
		for(int i = 0; i < sequence.size(); i++) {
			addText(sequence.get(i));
		}
	}
	
	public void addText(String s) {
		Thread t = new Thread(new Runnable(){
			public void run(){
				try {
					text.setText(text + ", " + s);
					Thread.sleep(6000);
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t.start();
	}

	public void changeLabel(String s) {
		Thread text = new Thread(new Runnable(){
			public void run(){
				try {
					label.setText(s);
					Thread.sleep(5000);
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		text.start();
	}

	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(Button b: buttons){ 
			viewObjects.add(b); 
		}
		
		label = new TextLabel(500, 230,300,40,"Let's play Simon!");
		text = new TextLabel(500, 300, 300, 40, "");
		viewObjects.add(label);
		viewObjects.add(text);

		//add 2 moves to start
		roundNumber = 0;
		sequence = new ArrayList<String>();
	}
	
	public void addButtons() {
		int numberOfButtons = 5;
		buttons = new Button[numberOfButtons];
		Color[] colorList = {Color.PINK, Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN};
		String[] l = {"pink","red","orange","yellow","green"};
		blabel = l;
		for(int i = 0; i < numberOfButtons; i++) {
			final Button b = new Button(getX(), getY(), 100, 30, blabel[i], null);
			b.setBackground(colorList[i]); 
			b.setX(70);
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
		changeLabel("GAME OVER");
		acceptingInput = false;
	}
}
