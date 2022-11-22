import java.time.LocalDate;
import javafx.scene.control.CheckBox;

public class Task extends CheckBox {
	String name;
	String location;
	LocalDate date;
	Task(String name,String location, String date){
		this.name = name;
		this.location = location;
		this.date = LocalDate.parse(date);
		setText(name);
		setOnAction(e -> Planner.taskPanel.removeTask(Task.this));
	}
}