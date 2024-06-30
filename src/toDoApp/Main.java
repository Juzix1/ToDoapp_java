package toDoApp;

import java.util.ArrayList;

import javax.swing.*;

public class Main {
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  

	public static void main(String[] args) {
		boolean loop = true;
		ArrayList<TodoItem> lista = new ArrayList<TodoItem>();
		while(loop) {
			System.out.println("---Lista Notek---");
		for(int i=0;i<lista.size();i++) {
			System.out.println("id:"+lista.get(i).getId()+" | "+lista.get(i).getDesc()+" | "+(lista.get(i).isChecked()?"checked":"not checked"));
		}
		System.out.println("-----------------\n");
		System.out.println("[c]reate new Todo task");
		System.out.println("[d]elete Todo task");
		System.out.println("[t]oggle Todo Task Check");
		System.out.println("[q]uit app");
		String choice;
		try {
			choice = JOptionPane.showInputDialog("Choose");
			switch(choice) {
			
				case "c":
				case "C":
					TodoItem item = new TodoItem(null);
					String desc = JOptionPane.showInputDialog("Write description for your new note");
					item.create(desc);
					lista.add(item);
					clearScreen();
					System.out.println("\u001B[32mSuccesfully created toDo task\u001B[0m");
					break;
				case "d":
				case "D":
					choice= "";
					choice = JOptionPane.showInputDialog("select id of task to delete");
					clearScreen();
					try {
					for(int i=0;i<lista.size();i++) {
						if (lista.get(i).getId()==Integer.parseInt(choice)) {
							lista.remove(i);
							System.out.println("\u001B[32mSuccesfully deleted toDo task\u001B[0m");
						}
					}
					break;
					}catch(Exception e) {
						System.err.println("non existend id");
						break;
					}
				case "t":
				case "T":
					choice= "";
					choice = JOptionPane.showInputDialog("select id of task to toggle check");
					clearScreen();
					for(int i=0;i<lista.size();i++) {
						if (lista.get(i).getId()==Integer.parseInt(choice)) {
							lista.get(i).toggleCheck();
							System.out.println("\u001B[32mSuccesfully changed Check to "+(lista.get(i).isChecked()?"checked":"not checked")+"\u001B[0m");
						}
					}
					break;
			
			
				case "q":
				case "Q":
					loop = false;
					break;
				default:
					clearScreen();
					System.err.println("Wrong character, choose one from the list");
			}
		}catch(Exception e){
			clearScreen();
			System.err.println("Wrong character, choose one from the list");
		}
		}

	}
}