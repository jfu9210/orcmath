package practice;

import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class RaceScreen extends FullFunctionScreen {

	private Button button;
	private TextLabel text;
	private TextArea score;
	private int s;
	private boolean active;

	public RaceScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		s = -1;
		active = true;
		
		score = new TextArea(200, 100, 100, 100, "Score: 0");
		viewObjects.add(score);

		text = new TextLabel(200, 300, 100, 100, "");
		viewObjects.add(text);

		button = new Button(270, 370, 100, 70, "Ready", new Action() {
			public void act() {
				button.setEnabled(false);
				updateText("3");
				text.setText("");
				updateText("2");
				text.setText("");
				updateText("1");
				text.setText("");
				updateText("GO!");
				text.setText("");
				button.setText("Click Me!");
				button.setEnabled(true);
				while(active) {
					addScore();
				}
			}
		});
		viewObjects.add(button);
	}

	public void addScore() {
		s++;
		score.setText("Score: " + s);
	}

	public void updateText(String s) {
		text.setText(s);
		Thread t = new Thread(new Runnable(){
			public void run(){
				try {
					Thread.sleep(1000);
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t.start();
	}
}
