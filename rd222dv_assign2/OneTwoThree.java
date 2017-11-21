package rd222dv_assign2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OneTwoThree extends Application {
	public void start(Stage primaryStage) {
		
		//three Hboxes with texts and nice background colors, 
		HBox hbox1 = new HBox();
	    hbox1.setStyle("-fx-background-color: #b0e0e6;");
	    hbox1.setPrefSize(700, 100);
	    Text text1 = new Text("One");
	    text1.setFont(Font.font("Sans Serif", FontWeight.BOLD, 42));
	    hbox1.getChildren().add(text1);
		
	    HBox hbox2 = new HBox();
	    hbox2.setStyle("-fx-background-color: #dda0dd;");
	    hbox2.setPrefSize(700, 100);
	    Text text2 = new Text("Two");
	    hbox2.setAlignment(Pos.CENTER);
	    text2.setFont(Font.font("Sans Serif", FontWeight.BOLD, 42));
	    hbox2.getChildren().add(text2);
	    
	    HBox hbox3 = new HBox();
	    hbox3.setStyle("-fx-background-color: #ffb6c1;");
	    hbox3.setPrefSize(700, 100);
	    Text text3 = new Text("Three");
	    hbox3.setAlignment(Pos.BOTTOM_RIGHT);
	    text3.setFont(Font.font("Sans Serif", FontWeight.BOLD, 42));
	    hbox3.getChildren().add(text3);
	    
	    //packing the Hboxes in a VBox (vertical Box)
	    VBox vbox = new VBox();
	    vbox.getChildren().addAll(hbox1, hbox2, hbox3);
	    Scene scene = new Scene(vbox, 702, 300); //creating the scene
	    
		 primaryStage.setTitle("OneTwoThree!"); 
		 primaryStage.setScene(scene);
		 primaryStage.show();
	}
		  
					
	public static void main(String[] args) {
		launch(args);
		}
    }
/*Pane root = new Pane();
VBox vbox = new VBox();

Rectangle r1 = new Rectangle(700, 100);
r1.setFill(Color.YELLOW);
Text text1 = new Text("One");
   
Rectangle r2 = new Rectangle(700, 100);
r2.setFill(Color.BLUE);
Text text2 = new Text("Two");

Rectangle r3 = new Rectangle(700, 100);
r3.setFill(Color.GREEN);
Text text3 = new Text("Three");
   
vbox.getChildren().addAll(r1, text1, r2, text2, r3, text3);
root.getChildren().add(vbox);
Scene scene = new Scene(root, 702, 315);*/
   
   /* stackPane.getChildren().addAll(r1, text1, r2, text2, r3, text3);
    stackPane1.getChildren().addAll(r1, text1);
    stackPane2.getChildren().addAll(r2, text2);
    stackPane3.getChildren().addAll(r3, text3);
    root.getChildren().add(stackPane);*/
    

 /*VBox vbox1 = new VBox();
 Text text1 = new Text("One");
 vbox1.getChildren().add(text1);

 
 VBox vbox2 = new VBox();
 Text text2 = new Text("Two");
 vbox2.getChildren().add(text2);

 
 VBox vbox3 = new VBox();
 Text text3 = new Text("Three");
 vbox3.getChildren().add(text3);
 
 VBox vbox=new VBox();
 vbox.getChildren().addAll(vbox1, vbox2, vbox3);
 Scene scene = new Scene(vbox, 700, 100);

 primaryStage.setTitle("OneTwoThree!");
 primaryStage.setScene(scene);
 primaryStage.show();*/
