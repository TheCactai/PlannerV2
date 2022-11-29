import java.time.LocalDate;

import javafx.scene.control.CheckBox;

public class DailyTask extends CheckBox {
	TaskData data;
	DailyTask(String name,String location, LocalDate date, boolean state, TaskData taskData){
		data = taskData;
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
		TaskPanel.dailyList.getChildren().remove(this);
		FileControl.taskData.remove(data);
		FileControl.save();
	}
	void addTask() {
		TaskPanel.dailyList.getChildren().add(this);
		FileControl.taskData.add(data);
		FileControl.save();
	}
}
