package toDoApp;

import java.util.Random;

public class TodoItem {
	int id;
	boolean isChecked;
	String description;
	
	public TodoItem(String desc) {
		this.description = desc;
	}
	
	public void create(String desc) {
		Random rand = new Random();
		id = rand.nextInt(50);
		description = desc;
	}
	public int getId() {
		return id;
	}
	public String getDesc() {
		return description;
	}
	public boolean isChecked() {
		return isChecked;
	}
	
	public void toggleCheck() {
		isChecked = !isChecked;
	}
}
