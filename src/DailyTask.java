import java.time.LocalDate;

import javafx.scene.control.CheckBox;

public class DailyTask  extends CheckBox {
	String name;
	String location;
	LocalDate date;
	DailyTask(String name,String location, LocalDate date, boolean state){
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
		FileControl.dailyTasks.remove(this);
		TaskPanel.dailyList.getChildren().remove(this);
		FileControl.save();
	}
	void addTask() {
		TaskPanel.dailyList.getChildren().add(this);
		FileControl.dailyTasks.add(this);
		FileControl.save();
	}
}
