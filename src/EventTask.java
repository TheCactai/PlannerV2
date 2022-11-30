import java.time.LocalDate;

import javafx.scene.control.CheckBox;

public class EventTask extends CheckBox{
	TaskData data;
	LocalDate date;
	EventTask(String name,String location, LocalDate date, boolean state, TaskData taskData){
		data = taskData;
		this.date = date;
		setSelected(state);
		setText(date+ " " + name);
		funcionallity();
		addTask();
	}
	
	void funcionallity() {
		if(date.compareTo(LocalDate.now())<= 0) {
			setDisable(false);
			if(date.compareTo(LocalDate.now())== 0) {
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
