import java.time.LocalDate;

import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseButton;

public class DailyTask extends CheckBox {
	TaskData data;
	String name;
	int points;
	DailyTask(String name,String location, LocalDate date, boolean state, TaskData taskData){
		data = taskData;
		this.name = name;
		setText(points +" "+ name);
		addTask();
	}
	@Override
	public void fire() {
		setOnMousePressed(e -> {
			if(e.getButton()== MouseButton.PRIMARY) {
				points++; setText(points +" "+ name);
			}
			else {
				points--; setText(points +" "+ name);
			}
			setSelected(points>0);
		});
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
