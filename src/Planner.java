import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Planner extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	static TaskPanel taskPanel = new TaskPanel();

	@Override
	public void start(Stage stage){
		BorderPane root = new BorderPane();
		
		TaskCreator taskCreator = new TaskCreator();
		Button addTask = new Button("Add Task");
		addTask.setOnAction(evt -> taskCreator.show());
		
		root.setPrefSize(400, 400);
		root.setCenter(taskPanel);
		root.setBottom(addTask);
		root.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE,CornerRadii.EMPTY , Insets.EMPTY)));
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Planner");
		stage.show();
		
		FileControl.openFile();
	}
}
