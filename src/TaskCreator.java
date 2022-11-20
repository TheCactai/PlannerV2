import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TaskCreator extends Stage{
	TaskCreator(){
		ComboBox<String> comboBox = new ComboBox<String>();
		//VVV Names locations
		comboBox.getItems().addAll("Daily","To Do","Plan","Event");
		comboBox.setValue("Daily");
		TextField textField = new TextField(); 
		Button button = new Button("Add Task");
		button.setOnAction(evt -> {
			//VVV Creates and adds the task to the panel
			Planner.taskPanel.AddTask(new Task(textField.getText(),comboBox.getValue()));
			textField.clear();
			close();
		});
		VBox root = new VBox(new Label("Task type:"),comboBox,new Label("Task text:"),textField, button);
		root.setSpacing(10);
		Scene scene = new Scene(root);
		setScene(scene);
		setTitle("Task Creator");
		setResizable(false);
	}
}
