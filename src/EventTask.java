import java.time.LocalDate;

import javafx.scene.control.CheckBox;

public class EventTask extends CheckBox {
	String name;
	String location;
	LocalDate date;
	EventTask(String name,String location, LocalDate date, boolean state){
		this.name = name;
		this.location = location;
		this.date = date;
		setSelected(state);
		setText(name);
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
		FileControl.eventTasks.remove(this);
		TaskPanel.eventList.getChildren().remove(this);
		FileControl.save();
	}
	void addTask() {
		TaskPanel.eventList.getChildren().add(this);
		FileControl.eventTasks.add(this);
		FileControl.save();
	}
}
