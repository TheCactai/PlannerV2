import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/* This is where all the Task Panels are created and specified	*/
public class TaskPanel extends GridPane {
	VBox dailyList = new VBox();
	VBox toDoList = new VBox();
	VBox eventList = new VBox();
	VBox planList = new VBox();
	TaskPanel(){
		add(scrollablePanel(dailyList),0,0);
		add(scrollablePanel(toDoList),0,1);
		add(scrollablePanel(eventList),1,0);
		add(scrollablePanel(planList),1,1);
		setHgap(10);
		setVgap(10);
	}
	ScrollPane scrollablePanel(VBox list) {
		ScrollPane scroll = new ScrollPane();
		scroll.setMaxSize(4000, 4000);//Sets size to take up all space possible
		scroll.setPrefSize(scroll.getMaxHeight(), scroll.getMaxWidth());
		scroll.setContent(list);
		return scroll;
	}
	//VV Both methods depend on location names in TaskCreator
	void addTask(Task task) {
		FileControl.save(task);
		switch(task.location) {
		case "Daily" : dailyList.getChildren().add(task);
		break;
		case "ToDo" : eventList.getChildren().add(task);
		break;
		case "Event" : planList.getChildren().add(task);
		break;
		default : toDoList.getChildren().add(task);
		break;
		}
	}
	void removeTask(Task task) {
		FileControl.remove(task);
		switch(task.location) {
		case "Daily" : dailyList.getChildren().remove(task);
		break;
		case "ToDo" : eventList.getChildren().remove(task);
		break;
		case "Event" : planList.getChildren().remove(task);
		break;
		default : toDoList.getChildren().remove(task);
		break;
		}
	}
}
