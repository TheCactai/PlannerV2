import java.time.LocalDate;

import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseButton;

public class DailyTask extends CheckBox {
	TaskData data;
	DailyTask(TaskData taskData){
		data = taskData;
		dailyReset();
		addTask();
		setText(data.points +" "+ data.name);
	}
	@Override
	public void fire() {
		setOnMousePressed(e -> {
			if(e.getButton()== MouseButton.PRIMARY) {
				data.points++; setText(data.points +" "+ data.name);
			}
			else {
				data.points--; setText(data.points +" "+ data.name);
			}
			setSelected(data.points>0);
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
	void dailyReset () {
		if(LocalDate.now().compareTo(data.date) != 0) {
			InfoPanel.addDailyTaskPoints(data.points);
			data.points -= LocalDate.now().compareTo(data.date);
			data.date = LocalDate.now();
		}
	}
}
