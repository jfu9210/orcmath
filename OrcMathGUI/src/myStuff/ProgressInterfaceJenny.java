package myStuff;

import guiTeacher.interfaces.Visible;

public interface ProgressInterfaceJenny extends Visible {
	
	void gameOver();
	void setRound(int i);
	void setSequenceSize(int i);
	ProgressInterfaceJenny getProgress();
}
