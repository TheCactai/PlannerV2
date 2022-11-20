import javafx.scene.control.CheckBox;

public class Task extends CheckBox {
	String name;
	String location;
	Task(String name, String location){
		this.name = name;
		this.location = location;
		setText(name);
		setOnAction(e -> Planner.taskPanel.removeTask(Task.this));
	}
}