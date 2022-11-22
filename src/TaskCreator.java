import java.time.LocalDate;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TaskCreator extends Stage{
	TaskCreator(){
		ComboBox<String> comboBox = new ComboBox<String>();
		//VVV Names locations
		comboBox.getItems().addAll("Daily","ToDo","Plan","Event");
		comboBox.setValue("Daily");
		TextField textField = new TextField(); 
		DatePicker datePicker = new DatePicker();
		datePicker.setValue(LocalDate.now());
		//VVV Creates and adds the task to the panel on button press
		Button button = new Button("Add Task");
		button.setOnAction(evt -> {
			Planner.taskPanel.addTask(new Task(textField.getText(),comboBox.getValue(),datePicker.getValue().toString()));
			textField.clear();
			close();
		});
		VBox root = new VBox(new Label("Task type:"),comboBox,new Label("Task text:"),textField, new Label("Select date:"), datePicker,button);
		root.setSpacing(10);
		Scene scene = new Scene(root);
		setScene(scene);
		setTitle("Task Creator");
		setResizable(false);
	}
}
