package rd222dv_assign3.UpDown;

import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class UpDownPane extends BorderPane {

	private class Position {
		int x;
		int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private GridPane grid;
	private Circle circle;

	private int rows = 7;
	private int col = 7;

	private Position circlePos = new Position((rows - rows % 2) / 2, (col - col % 2) / 2);

	public UpDownPane() {
		grid = new GridPane();
		grid.setStyle("-fx-background-color: #202020");

		grid.setHgap(1);
		grid.setVgap(1);

		circle = new Circle(200, 150, 40, Color.YELLOW);

		for (int i = 0; i < rows; i++)
			for (int j = 0; j < col; j++) {
				if (i == circlePos.x && j == circlePos.y)
					grid.add(circle, i, j);
				else {
					Rectangle rect = new Rectangle(80, 80);
					rect.setFill(Color.GREEN);
					grid.add(rect, i, j);
				}
			}

		this.setTop(grid);
	}

	public void handle(KeyEvent event) {
		switch (event.getCode()) {
		case UP: {
			if (circlePos.y == 0)
				circlePos.y = rows - 1;
			else
				circlePos.y--;
			break;
		}
		case DOWN: {
			if (circlePos.y == rows - 1)
				circlePos.y = 0;
			else
				circlePos.y++;
			break;
		}
		case LEFT: {
			if (circlePos.x == 0)
				circlePos.x = col - 1;
			else
				circlePos.x--;
			break;
		}
		case RIGHT: {
			if (circlePos.x == col - 1)
				circlePos.x = 0;
			else
				circlePos.x++;
			break;
		}
		default:
			break;
		}
		grid.getChildren().removeAll(grid.getChildren());

		for (int i = 0; i < rows; i++)
			for (int j = 0; j < col; j++) {
				if (i == circlePos.x && j == circlePos.y)
					grid.add(circle, i, j);
				else {
					Rectangle rect = new Rectangle(80, 80);
					rect.setFill(Color.GREEN);
					grid.add(rect, i, j);
				}
			}
	}
}
