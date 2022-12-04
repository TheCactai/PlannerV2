import java.io.Serializable;
import java.time.LocalDate;

public class TaskData implements Serializable {
	private static final long serialVersionUID = 1L;
	String name;
	String location;
	LocalDate date;
	boolean state;
	int points;
	TaskData (String name,String location, LocalDate date, boolean state, int points){
		this.name = name;
		this.location = location;
		this.date = date;
		this.state = state;
		this.points = points;
		switch(location) {
		case "Daily" : new DailyTask(this);
		break;
		case "ToDo" : new ToDoTask(this);
		break;
		default : new EventTask(this);
		break;
		}
	}
}
