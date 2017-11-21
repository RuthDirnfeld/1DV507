package rd222dv_assign3.Creature;

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Creature {

	ImageView view = new ImageView();
	private StackPane stack = new StackPane();
	private BorderPane bp = new BorderPane();
	private Text text = new Text("0");
	private Timeline timeline = new Timeline();
	private EventHandler<ActionEvent> mover;

	public Creature() { //Constructor

		Image image = new Image("file:src/Knight.png"); //Image
		view.setImage(image); // image into view (we need view for clicking event)
		view.setFitWidth(70);
		view.setFitHeight(70);
		
		Label points = new Label("Points:  "); //display Points
		points.setFont(Font.font(21));
		
		text.setFont(Font.font(21)); // for counter
		
		HBox hbox = new HBox(); 
		hbox.getChildren().addAll(points, text); //putting the label and counter into a hbox
		hbox.setPrefSize(55, 55);
		hbox.setAlignment(Pos.TOP_CENTER);

		stack.getChildren().addAll(view); 
		stack.setPrefSize(400, 400);
		stack.setAlignment(Pos.TOP_LEFT);

		bp.setTop(stack);
		bp.setBottom(hbox);
		bp.setPrefSize(480, 480);

		timeline.setCycleCount(Timeline.INDEFINITE); // timer that lets the creature appear again
		//timeline.setAutoReverse(true);
		KeyValue value1 = new KeyValue(view.scaleXProperty(), 0); // to make the creature appear from small and disappear into small
		KeyValue value2 = new KeyValue(view.scaleYProperty(), 0); //is nicer than if it would jump from one place to another

		Duration dur = Duration.millis(650); //how fast the creature should appear and disappear

		move(); 
		click();

		KeyFrame key = new KeyFrame(dur, mover, value1, value2);

		timeline.getKeyFrames().add(key); //adding everything to the timeline
		timeline.setAutoReverse(true);
		timeline.play();

	}

	public BorderPane getRoot() {
		return bp;
	}

	private void move() {
		mover = new EventHandler<ActionEvent>() {

			Random rand = new Random(); //to get the random position

			public void handle(ActionEvent t) {

				stack.setTranslateX(rand.nextInt(500)); //random number generator for 

				stack.setTranslateY(rand.nextInt(500)); //changing the position of the creature
			}};
	}

	private void click() {

		view.setOnMouseClicked(e -> { 
			int points = Integer.valueOf(text.getText());
			int counter = points + 1; //increasing the counter if creature is clicked
			text.setText("" + counter);
		});

	}

}
	/* my old wrong "game"
	private Point2D center;
	private double radius;
	
	public Creature(double x, double y, double r) {
		setCenter(x, y);
		setRadius(r);
	}

	public void setCenter(double x, double y) {
		center = new Point2D(x, y);
	}

	public void setRadius(double r) {
		radius = r;
	}

	public double getX() {
		return center.getX();
	}

	public double getY() {
		return center.getY();
	}

	public double getRadius() {
		return radius;
	}

	public boolean containsPoint(double x, double y) {
		return (center.distance(x, y) < radius);
	}
}*/
/*private boolean isWithin(double x, double y, Rectangle rect)
	{
		double minX = rect.getX();
		double maxX = minX + rect.getWidth();
		
		double minY = rect.getY();
		double maxY = minY + rect.getHeight();
		
		return (minX <= x && x <= maxX) && (minY <= y && y <= maxY);
	}
	
	private double getVaildHeight()
	{
		double h = this.getHeight();
		if (h == 0)
			h = this.getMinHeight();
		return h;
	}
	
	private double getVaildWidth()
	{
		double w = this.getWidth();
		if (w == 0)
			w = this.getMinWidth();
		return w;
	}
	*/

