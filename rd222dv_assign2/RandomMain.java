package rd222dv_assign2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RandomMain extends Application {
	 //Stage window;
	    @Override
	    public void start(Stage primaryStage) {
	        
	        RandomPane rp = new RandomPane(); 
	        
	        VBox vbox = new VBox(); //packing the RandomPane in a box
	        vbox.getChildren().addAll(rp);
	        
	        //Scene and window
	        Scene scene = new Scene(vbox, 550, 200); //creating the Scene
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    }
	    public static void main(String[] args) { //for running the app
	        launch(args);
	    }

	}

	/*public void start(Stage primaryStage) {

		primaryStage.setTitle("Press the button!");

		RandomPane rp = new RandomPane();

		Scene scene = new Scene(rp, 300, 200);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}*/
