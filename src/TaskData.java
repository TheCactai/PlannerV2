import java.io.Serializable;
import java.time.LocalDate;

public class TaskData implements Serializable {
	private static final long serialVersionUID = 1L;
	String name;
	String location;
	LocalDate date;
	boolean state;
	TaskData (String name,String location, LocalDate date, boolean state){
		this.name = name;
		this.location = location;
		this.date = date;
		this.state = state;
		switch(location) {
		case "Daily" : new DailyTask(name, location, date, state, this);
		break;
		case "ToDo" : new ToDoTask(name, location, date, state, this);
		break;
		default : new EventTask(name, location, date, state, this);
		break;
		}
	}
}
