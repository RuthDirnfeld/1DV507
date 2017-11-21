package rd222dv_assign2;

import java.util.Random;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class RandomPane extends BorderPane {
	//public static void display(){
	public RandomPane() {
	       
		Random rand = new Random(); 

		Label label = new Label("Click the button!");
		label.setFont(new Font(70)); //with the font I tried to make the Integer fit the box..tried
	    
		Button btn = new Button(); //the Button to be clicked
		btn.setText("New Random");
	
		btn.setOnAction(event -> {
			label.setText("" + rand.nextInt(101)); //Action Button generating the random number
			
			/*if (rand.nextInt(101)==100){  // this would only make the hundred-th number clicked big :(
				label.setFont(new Font(45));
			}*/
		});

		this.setTop(btn); //this. --> extending BorderPane so no need to create new BordePanes
		this.setCenter(label);
		
	}
}