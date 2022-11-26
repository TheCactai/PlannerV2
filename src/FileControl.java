import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class FileControl {
	
	static File saveFile = new File("saved_data.text");
	static PrintWriter printWriter;
	static ArrayList<Task> savedTasks = new ArrayList<Task>();
	
	static void save(Task task) {
		savedTasks.add(task);
		writeFile();
	}
	static void save() {
		writeFile();
	}
	static void remove(Task task) {
		savedTasks.remove(task);
		writeFile();
	}
	
	static void openFile() {
		try {
			if(saveFile.createNewFile()) {System.out.println("New File is created");}
			else {loadSave();}
		} catch (IOException e) {e.printStackTrace();}
	}
	
	static void writeFile() {
		try {
			FileWriter fileWriter = new FileWriter(saveFile);
			printWriter = new PrintWriter(fileWriter);
			//VVV Reads all the tasks from the ArrayList and writes their values into the file
			for(int i = 0; i <savedTasks.size();i++) {
				printWriter.println(" AddTask: "+ savedTasks.get(i).name +" Location: "+ savedTasks.get(i).location +" Date: "+ savedTasks.get(i).date +" State: "+ savedTasks.get(i).isSelected());
				printWriter.flush();
			}
			printWriter.close();
			fileWriter.close();
		} catch (IOException e) {e.printStackTrace();}
	}
	
	static void loadSave() {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(saveFile));
			Scanner scanner = new Scanner(bufferedReader);
			while (scanner.hasNext() && scanner.next().equals("AddTask:")) {
				String name = "";
				String location;
				LocalDate date;
				boolean state;
				String next = scanner.next();
				//VVV Constructs the task name that consists of multiple strings into one string
				while(!next.equals("Location:")) {
					name += next;
					name += " ";
					next = scanner.next();
				}
				location = scanner.next();
				next = scanner.next();
				date = LocalDate.parse(scanner.next());
				next = scanner.next();
				state = scanner.next().equals("true");
				//VVVConstructs the task and adds it to its panel
				Planner.taskPanel.addTask(new Task(name,location,date,state));
			}
			 scanner.close();
		} catch (FileNotFoundException e) {e.printStackTrace();}
	}
}
