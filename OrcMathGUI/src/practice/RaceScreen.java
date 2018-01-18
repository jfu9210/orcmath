package practice;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class RaceScreen extends FullFunctionScreen {

	private Button button;
	private TextArea text;
	private TextArea score;
	private int s;
	private int count;
	private int start;
	private Timer timer;

	public RaceScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		s = -1;
		count = 6;
		start = 4;
	timer = new Timer();
			TimerTask task = new TimerTask() {
				
				@Override
				public void run() {
					start--;
					button.setEnabled(false);
					if(start == 0) {
						text.setText("GO!");
						button.setText("Click me!");
					}else
						text.setText("Score: " + start);
					if(start < 0) {
						button.setEnabled(true);
						count--;
						text.setText(count + " seconds left!!!");
						if(count == 0) {
							button.setText("Done");
							button.setEnabled(false);
							timer.cancel();
						}
					}
				}
			};
		score = new TextArea(200, 100, 100, 100, "Score: 0");
		viewObjects.add(score);

		text = new TextArea(200, 300, 100, 100, "");
		viewObjects.add(text);

		button = new Button(270, 370, 100, 70, "Ready", new Action() {

			public void act() {
				if(start <= 0)
					addScore();
				else 
					start(task);
			}
		});
		viewObjects.add(button);
		
		
	}

	public void start(TimerTask task) {
		timer.schedule(task, 0, 1000);
	}

	public void addScore() {
		s++;
		score.setText("Score: " + s);
	}
}
