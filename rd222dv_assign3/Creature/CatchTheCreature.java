package rd222dv_assign3.Creature;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CatchTheCreature extends Application {
	@Override
	public void start(Stage primaryStage) {

		Creature creature = new Creature();

		Scene scene = new Scene(creature.getRoot());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Catch the Creature");
		primaryStage.setWidth(630);
		primaryStage.setHeight(600);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}

	/*my old wrong "game"
	 public class IntValue {
	 
		public int value;

		public IntValue(int i) {
			value = i;
		}
	}
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Catch-The-Creature");

		Group root = new Group();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);

		Canvas canvas = new Canvas(500, 500);

		root.getChildren().add(canvas);

		Creature creature = new Creature(100, 100, 60);
		IntValue points = new IntValue(0);

		scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
		//scene.setOnMouseEntered(e -> {
				if (creature.containsPoint(e.getX(), e.getY())) {
					double x = 50 + 400 * Math.random();
					double y = 50 + 400 * Math.random();
					creature.setCenter(x, y);
					points.value++;
				} else
					points.value = 0;
			}});

		GraphicsContext graphics = canvas.getGraphicsContext2D();

		Font theFont = Font.font("Sans Serif", FontWeight.BOLD, 24);
		graphics.setFont(theFont);
		graphics.setLineWidth(1);

		Image knight = new Image("file:src/Knight.png");

		new AnimationTimer() {
			public void handle(long currentNanoTime) {
				// Clear the canvas
				graphics.setFill(new Color(1.0, 1.0, 1.0, 1.0));
				graphics.fillRect(0, 0, 550, 550);

				graphics.drawImage(knight, creature.getX() - creature.getRadius(),
						creature.getY() - creature.getRadius());
				
				String text = "Points: " + points.value;
				graphics.fillText(text, 360, 42);
				graphics.strokeText(text, 360, 42);
				
			}
		}.start();

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}*/