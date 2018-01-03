package myStuff;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import javafx.scene.paint.Color;

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

	public void run() {

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
		return null;
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	 */
	public ProgressInterfaceJenny getProgress() {
		return null;
	}

	public void addButtons() {
		int numberOfButtons = 5;
		buttons = new ButtonInterfaceJenny[numberOfButtons];
		Color[] colorList = {Color.MISTYROSE, Color.LAVENDER, Color.HONEYDEW, Color.SALMON, Color.PEACHPUFF};
		for(int i = 0; i < numberOfButtons; i++) {
			ButtonInterfaceJenny b = getAButton();
			b.setColor(colorList[i]); 
   			b.setX(70);
    			b.setY(50);
			buttons[i] = b;
		}
	}

	/**
		Placeholder until partner finishes implementation of ButtonInterface
	 */
	public ButtonInterfaceJenny getAButton() {
		return null;
	}
}
