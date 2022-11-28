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
	static ArrayList<DailyTask> dailyTasks = new ArrayList<DailyTask>();
	static ArrayList<ToDoTask> toDoTasks = new ArrayList<ToDoTask>();
	static ArrayList<EventTask> eventTasks = new ArrayList<EventTask>();
	static ArrayList<PlanTask> planTasks = new ArrayList<PlanTask>();
	
	static void save() {
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
			printWriter.println("Daily");
			for(int i = 0; i <dailyTasks.size();i++) {
				printWriter.println(" Task: "+ dailyTasks.get(i).name +" Date: "+ dailyTasks.get(i).date +" State: "+ dailyTasks.get(i).isSelected());
				printWriter.flush();
			}
			printWriter.println("End");
			printWriter.println("ToDo");
			for(int i = 0; i <toDoTasks.size();i++) {
				printWriter.println(" Task: "+ toDoTasks.get(i).name +" Date: "+ toDoTasks.get(i).date +" State: "+ toDoTasks.get(i).isSelected());
				printWriter.flush();
			}
			printWriter.println("End");
			printWriter.println("Event");
			for(int i = 0; i <eventTasks.size();i++) {
				printWriter.println(" Task: "+ eventTasks.get(i).name +" Date: "+ eventTasks.get(i).date +" State: "+ eventTasks.get(i).isSelected());
				printWriter.flush();
			}
			printWriter.println("End");
			printWriter.println("Plan");
			for(int i = 0; i <planTasks.size();i++) {
				printWriter.println(" Task: "+ planTasks.get(i).name +" Date: "+ planTasks.get(i).date +" State: "+ planTasks.get(i).isSelected());
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
			while (scanner.hasNext()) {
				String location = scanner.next();
				while (scanner.hasNext() && scanner.next().equals("Task:")) {
					String name = "";
					LocalDate date;
					boolean state;
					String next = scanner.next();
					//VVV Constructs the task name that consists of multiple strings into one string
					while(!next.equals("Date:")) {
						name += next;
						name += " ";
						next = scanner.next();
					}
					date = LocalDate.parse(scanner.next());
					next = scanner.next();
					state = scanner.next().equals("true");
					//VVVConstructs the task
					switch(location) {
					case "Daily" : new DailyTask(name,location,date,state);
					break;
					case "ToDo" : new ToDoTask(name,location,date,state);
					break;
					case "Event" : new EventTask(name,location,date,state);
					break;
					default : new PlanTask(name,location,date,state);
					break;
					}
					
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {e.printStackTrace();}
	}
}
