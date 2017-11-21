package rd222dv_assign2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ColorDisplay extends Application {
	public void start(Stage stage) throws Exception {

		// First rectangle which will be filled with colors
		Rectangle rectangle = new Rectangle(0, 0, 500, 160);
		rectangle.setFill(Color.WHITE);

		Text rectText = new Text("Color Display");
		rectText.setFont(Font.font("Sans Serif", FontWeight.BOLD, 30));
		StackPane stack = new StackPane();
		stack.getChildren().addAll(rectangle, rectText);

		// Text fields + labels + vboxes for color boxes
		TextField text1 = new TextField();
		Label label1 = new Label("Red");
		label1.setFont(new Font(20));
		VBox vbox1 = new VBox();
		vbox1.getChildren().addAll(text1, label1);

		TextField text2 = new TextField();
		Label label2 = new Label("Green");
		label2.setFont(new Font(20));
		VBox vbox2 = new VBox();
		vbox2.getChildren().addAll(text2, label2);

		TextField text3 = new TextField();
		Label label3 = new Label("Blue");
		label3.setFont(new Font(20));
		VBox vbox3 = new VBox();
		vbox3.getChildren().addAll(text3, label3);

		// three color boxes in one box
		HBox colorBox = new HBox();
		colorBox.setPadding(new Insets(10, 10, 10, 10));
		colorBox.setSpacing(10);
		colorBox.getChildren().addAll(vbox1, vbox2, vbox3);

		/*// Button and error
		Pane pane = new Pane();
		pane.setPrefSize(150, 50);*/
		Button btn = new Button("Display Color"); 
		Label error = new Label(); //error will appear when wrong numbers are entered
		VBox vbox = new VBox(); //for button and error
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(btn, error);
		
		/*StackPane buttons = new StackPane();
		buttons.getChildren().addAll(pane, vbox);*/

		// Button Action Event for mixing colors
		btn.setOnAction(event -> {

			try {
				//reading the numbers for the colors
				int red = Integer.parseInt(text1.getText()); 
				int green = Integer.parseInt(text2.getText());
				int blue = Integer.parseInt(text3.getText());

				if (!RGB(red) && !RGB(green) && !RGB(blue)) { //if the numbers are smaller than 255 and bigger than 0 the rectangle fills
					rectangle.setFill(Color.rgb(red, green, blue, .99));
				} else {
					error.setText("Enter numbers between 0 - 255"); //else returns an error message
				}
			} catch (NumberFormatException e) {
				error.setText("Error: " + e);
			}
		});

		VBox bigBox = new VBox();
		bigBox.getChildren().addAll(stack, colorBox, vbox); //buttons);

		// Display
		Scene scene = new Scene(bigBox, 500, 300);
		stage.setTitle("Color Time");
		stage.setScene(scene);
		stage.show();

	}
	//method for rgb
	public static boolean RGB(int N) {
		return (N < 0 || N > 255); // negative or bigger than 255 is true
	}

	public static void main(String[] args) {
		launch(args);
	}

}