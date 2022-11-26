import java.time.LocalDate;
import javafx.scene.control.CheckBox;

public class Task extends CheckBox {
	String name;
	String location;
	LocalDate date;
	Task(String name,String location, LocalDate date, boolean state){
		this.name = name;
		this.location = location;
		this.date = date;
		setSelected(state);
		setText(name);
		//setOnAction(e -> Planner.taskPanel.removeTask(Task.this));
	}
}