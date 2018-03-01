package main;

import java.awt.event.*;
import javax.swing.*;

public class ResizableScreen extends JFrame implements ComponentListener {

	private JLabel label;

	public ResizableScreen(){
		label = new JLabel();
		getContentPane().add(label);
		getContentPane().addComponentListener(this);
	}

	public void componentHidden(ComponentEvent ce) {};
	public void componentShown(ComponentEvent ce) {};
	public void componentMoved(ComponentEvent ce) { };

	public void componentResized(ComponentEvent ce) {
		int height = this.getHeight();
		int width = this.getWidth();
		label.setText("Size: " + height + "x" + width);
	};

	public static void main(String[] arguments) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		ResizableScreen frame = new ResizableScreen();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("JFrame Resizing Example");
		frame.setSize(1920, 1080);
		frame.setVisible(true);

	}
}
