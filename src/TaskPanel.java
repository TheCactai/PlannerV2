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
		add(ScrollablePanel(dailyList),0,0);
		add(ScrollablePanel(toDoList),0,1);
		add(ScrollablePanel(eventList),1,0);
		add(ScrollablePanel(planList),1,1);
		setHgap(10);
		setVgap(10);
	}
	ScrollPane ScrollablePanel(VBox list) {
		ScrollPane scroll = new ScrollPane();
		scroll.setMaxSize(4000, 4000);//Sets size to take up all space possible (needs improvement)
		scroll.setPrefSize(scroll.getMaxHeight(), scroll.getMaxWidth());
		scroll.setContent(list);
		//scroll.setBackground(new Background(new BackgroundFill(Color.RED,CornerRadii.EMPTY , Insets.EMPTY)));
		return scroll;
	}
	//VV Both methods depend on location names in TaskCreator
	void AddTask(Task task) {
		switch(task.location) {
		case "Daily" : dailyList.getChildren().add(task);
		break;
		case "To Do" : eventList.getChildren().add(task);
		break;
		case "Event" : planList.getChildren().add(task);
		break;
		default : toDoList.getChildren().add(task);
		}
	}
	void removeTask(Task task) {
		switch(task.location) {
		case "Daily" : dailyList.getChildren().remove(task);
		break;
		case "To Do" : eventList.getChildren().remove(task);
		break;
		case "Event" : planList.getChildren().remove(task);
		break;
		default : toDoList.getChildren().remove(task);
		}
	}
}
