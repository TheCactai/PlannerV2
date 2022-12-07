import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

// This is where all the Task Panels are created
public class TaskPanel extends GridPane {
	static VBox dailyList = new VBox();
	static VBox toDoList = new VBox();
	static VBox eventList = new VBox();
	InfoPanel infoPanel = new InfoPanel();
	TaskPanel(){
		setPadding(new Insets(10,25,25,25));
		add(new Label("Daily:"),0,0);
		add(scrollablePanel(dailyList),0,1);
		add(new Label("Event:"),1,0);
		add(scrollablePanel(eventList),1,1);
		add(new Label("To Do:"),0,2);
		add(scrollablePanel(toDoList),0,3);
		add(new Label("Info:"),1,2);
		add(infoPanel,1,3);
		setHgap(10);
		setVgap(10);
	}
	ScrollPane scrollablePanel(VBox list) {
		ScrollPane scroll = new ScrollPane();
		scroll.setContent(list);
		return scroll;
	}
}
