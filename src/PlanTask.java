import java.time.LocalDate;

import javafx.scene.control.CheckBox;

public class PlanTask extends CheckBox {
	String name;
	String location;
	LocalDate date;
	PlanTask(String name,String location, LocalDate date, boolean state){
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
		FileControl.planTasks.remove(this);
		TaskPanel.planList.getChildren().remove(this);
		FileControl.save();
	}
	void addTask() {
		TaskPanel.planList.getChildren().add(this);
		FileControl.planTasks.add(this);
		FileControl.save();
	}
}
