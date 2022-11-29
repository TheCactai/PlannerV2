import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class FileControl {
	static File saveFile = new File("saved_data.text");
	static ArrayList<TaskData> taskData = new ArrayList<TaskData>();
	
	static void save() {
		writeFile();
	}
	
	static void openFile() {
		try {
			if(saveFile.createNewFile()) {System.out.println("New File is created");}
			else {loadSave();}
		} catch (IOException e) {e.printStackTrace();}
	}
	
	private static void writeFile() {
		try {
			ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(saveFile));
			objOutput.writeObject(taskData);
			objOutput.close();
		} catch (IOException e) {e.printStackTrace();}
	}
	
	private static void loadSave() {
		try {
			ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(saveFile));
			ArrayList<TaskData> loadData = (ArrayList<TaskData>) objectInput.readObject();
			objectInput.close();
			Iterator<TaskData> itr = loadData.iterator();
			while(itr.hasNext()){
				TaskData data = itr.next();
				new TaskData(data.name, data.location, data.date, data.state);
			}
			
		} catch (Exception e) {e.printStackTrace();}
	}
}
