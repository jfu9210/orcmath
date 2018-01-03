package jenny;
import java.io.File;
import java.util.List;

import javax.swing.JFrame;

import guiTeacher.components.*;
import guiTeacher.interfaces.FileRequester;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen implements FileRequester {

	private TextField age;
	private TextField name;
	private TextField gender;
	private TextArea text;
	private Button addButton;
	private Button saveButton;
	private Button deleteButton;
	private FileOpenButton openFile;
	private CatalogMaker catalog;

	public CatalogScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		text = new TextArea(505, 60, 60, 50, "TEXT");
		viewObjects.add(text);

		age = new TextField(40, 40, 200, 30, "Enter Text", "AGE");
		viewObjects.add(age);
		age.setInputType(TextField.INPUT_TYPE_NUMERIC);
		name = new TextField(40, 100, 200, 30, "Enter Text", "NAME");
		viewObjects.add(name);
		gender = new TextField(40, 160, 200, 30, "Enter Text", "GENDER");
		viewObjects.add(gender);
		
		addButton = new Button(475, 100, 100, 100, "Add Button", new Action() {
			public void act() {
				addClick();
			}
		});
		viewObjects.add(addButton);
		
		saveButton = new Button(475, 150, 100, 100, "Save Button", new Action() {
			public void act() {
				addClick();
			}
		});
		viewObjects.add(saveButton);
		
		deleteButton = new Button(475, 200, 100, 100, "Delete Button", new Action() {
			public void act() {
				addClick();
			}
		});
		viewObjects.add(deleteButton);
		
		openFile = new FileOpenButton(480, 290, 90, 50, null, this);
		viewObjects.add(openFile);
		
		catalog = new CatalogMaker();
		catalog.add();
	}

	protected void addClick() {
		Person p = new Person(Integer.parseInt(age.getText()), name.getText(), gender.getText());
	}

	public void setFile(File f) {
		
	}

	public JFrame getWindow() {
		return null;
		
	}
}
