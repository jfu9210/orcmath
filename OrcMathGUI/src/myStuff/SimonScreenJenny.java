package myStuff;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenJenny extends ClickableScreen implements Runnable {

	private TextLabel label;
	private ButtonInterfaceJenny[] buttons;
	private ProgressInterfaceJenny progress;
	private ArrayList<MoveInterfaceJenny> sequence;

	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;

	public SimonScreenJenny(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	public void run(){
		label.setText("");
		nextRound();
	}

	public void nextRound() {
		acceptingInput = false;
		roundNumber++;

		MoveInterfaceJenny moveInterface = randomMove();
		sequence.add(moveInterface);

		progress.setRound(roundNumber);
		progress.setSequenceSize(sequence.size());
		changeText("Simon's turn");
		label.setText("");
		playSequence();

		changeText("Your turn");
		acceptingInput = true;
		sequenceIndex = 0;
	}

	public void playSequence() {
		ButtonInterfaceJenny b = null;
		for(int i = 0; i < sequence.size(); i++) {
			if(b != null) {
				b.dim();
				b = sequence.get(i).getButton();
				b.highlight();
				int sleepTime = getTime();
				Thread sleep = new Thread(new Runnable(){
					public void run(){
						try {
							Thread.sleep(sleepTime);
						}catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				});
				sleep.start();
			}
		}
		b.dim();
	}

	public int getTime() {
		if(1500 + (roundNumber * -100) <= 0)
			return 100;
		return 1500 + (roundNumber * -100);
	}

	public void changeText(String s) {
		Thread text = new Thread(new Runnable(){
			public void run(){
				try {
					Thread.sleep(1000);
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		text.start();
	}

	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceJenny b: buttons){ 
			viewObjects.add(b); 
		}

		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceJenny>();

		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	public MoveInterfaceJenny randomMove() {
		int bIndex = (int)(Math.random()*buttons.length);
		while(bIndex == lastSelectedButton){
			bIndex = (int)(Math.random()*buttons.length);
		}
		return getMove(bIndex);
	}

	/**
	Placeholder until partner finishes implementation of MoveInterface
	 */
	public MoveInterfaceJenny getMove(int index) { 
		return new MoveJane();
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	 */
	public ProgressInterfaceJenny getProgress() {
		return new ProgressJane(0, 0, 1, 1);
	}

	public void addButtons() {
		int numberOfButtons = 5;
		buttons = new ButtonInterfaceJenny[numberOfButtons];
		Color[] colorList = {Color.PINK, Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN};
		for(int i = 0; i < numberOfButtons; i++) {
			final ButtonInterfaceJenny b = getAButton();
			b.setColor(colorList[i]); 
			b.setX(70+5*i);
			b.setY(50+5*i);
			b.setAction(new Action(){
				public void act(){
					if(acceptingInput){
						Thread blink = new Thread(new Runnable(){
							public void run(){
								b.highlight();
								try {
									Thread.sleep(800);
								}catch (InterruptedException e) {
									e.printStackTrace();
								}
								b.dim();
							}
						});
						blink.start();
						if(b == sequence.get(sequenceIndex).getButton())
							sequenceIndex++;
						else 
							progress.gameOver();
						if(sequenceIndex == sequence.size()){ 
							Thread nextRound = new Thread(SimonScreenJenny.this); 
							nextRound.start(); 
						}
					}
				}
			});
			buttons[i] = b;
		}
	}

	/**
		Placeholder until partner finishes implementation of ButtonInterface
	 */
	public ButtonInterfaceJenny getAButton() {
		return new ButtonJane(getX(), getY(), getWidth(), getHeight(), "", null);
	}
}
