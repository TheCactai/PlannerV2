import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

// This is where all the Task Panels are created
public class TaskPanel extends GridPane {
	static VBox dailyList = new VBox();
	static VBox toDoList = new VBox();
	static VBox eventList = new VBox();
	static VBox planList = new VBox();
	TaskPanel(){
		add(scrollablePanel(dailyList),0,0);
		add(scrollablePanel(toDoList),1,0);
		add(scrollablePanel(eventList),0,1);
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
}
