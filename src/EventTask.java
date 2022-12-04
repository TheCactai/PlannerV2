import java.time.LocalDate;

import javafx.scene.control.CheckBox;

public class EventTask extends CheckBox{
	TaskData data;
	EventTask(TaskData taskData){
		data = taskData;
		setSelected(taskData.state);
		setText(data.date+ " " + taskData.name);
		funcionallity();
		addTask();
	}
	
	void funcionallity() {
		if(data.date.compareTo(LocalDate.now())<= 0) {
			setDisable(false);
			if(data.date.compareTo(LocalDate.now())== 0) {
				setOnAction(e -> {
					System.out.println("Event task compleate");
					removeTask();
				});
			}
			else {
				setOnAction(e -> {
					System.out.println("Event task Missed");
					removeTask();
				});
			}
		}else {setDisable(true);}
		
	}
	void removeTask(){
		TaskPanel.eventList.getChildren().remove(this);
		FileControl.taskData.remove(data);
		FileControl.save();
	}
	void addTask() {
		TaskPanel.eventList.getChildren().add(this);
		FileControl.taskData.add(data);
		FileControl.save();
	}
}
