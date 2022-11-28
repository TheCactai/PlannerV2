import java.time.LocalDate;

import javafx.scene.control.CheckBox;

public class ToDoTask extends CheckBox {
	String name;
	String location;
	LocalDate date;
	ToDoTask(String name,String location, LocalDate date, boolean state){
		this.name = name;
		this.location = location;
		this.date = date;
		setSelected(state);
		setText(name);
		funcionallity();
		addTask();
	}
	//More unique functionality will be added later
	void funcionallity() {
		setOnAction(e -> removeTask());
	}
	void removeTask(){
		FileControl.toDoTasks.remove(this);
		TaskPanel.toDoList.getChildren().remove(this);
		FileControl.save();
	}
	void addTask() {
		TaskPanel.toDoList.getChildren().add(this);
		FileControl.toDoTasks.add(this);
		FileControl.save();
	}
}
