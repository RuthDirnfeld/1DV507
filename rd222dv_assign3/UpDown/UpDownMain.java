package rd222dv_assign3.UpDown;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UpDownMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		UpDownPane upDown = new UpDownPane();
		
		Scene scene = new Scene(upDown);
		scene.setOnKeyPressed(e -> upDown.handle(e));

		primaryStage.setTitle("UpDownPane!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}