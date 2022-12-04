import javafx.scene.control.CheckBox;

public class ToDoTask extends CheckBox{
	TaskData data;
	ToDoTask(TaskData taskData){
		data = taskData;
		setSelected(taskData.state);
		setText(taskData.name);
		funcionallity();
		addTask();
	}
	//More unique functionality will be added later
	void funcionallity() {
		setOnAction(e -> removeTask());
	}
	void removeTask(){
		TaskPanel.toDoList.getChildren().remove(this);
		FileControl.taskData.remove(data);
		FileControl.save();
	}
	void addTask() {
		TaskPanel.toDoList.getChildren().add(this);
		FileControl.taskData.add(data);
		FileControl.save();
	}
}
