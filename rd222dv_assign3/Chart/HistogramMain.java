package rd222dv_assign3.Chart;

import java.io.File;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import rd222dv_assign3.Chart.Histogram;

public class HistogramMain extends Application {

	Histogram read = new Histogram();
	
	@Override
	public void start(Stage primaryStage) {
		Group group = new Group();
		Button btn = new Button();
		GridPane grid = new GridPane();
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {

				FileChooser chooser = new FileChooser();
				FileChooser.ExtensionFilter extension = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt"); //extension for .txt file
				chooser.getExtensionFilters().add(extension);
				File file = chooser.showOpenDialog(primaryStage);

				read.setPath(file.getAbsolutePath()); //read path

				try { //BarChart things taken from slides 35-36 from the javaFX 2 lecture
					read.readFile();

					primaryStage.setTitle("Chart");
					CategoryAxis xAxis = new CategoryAxis();
					NumberAxis yAxis = new NumberAxis();
					BarChart<String, Number> chart = new BarChart<>(xAxis, yAxis);
					chart.setTitle("Bar Chart");
					Series<String, Number> values = new XYChart.Series<>();
					values.setName("Integers in the Interval [1, 100]");
				 
				    ObservableList<PieChart.Data> pieChartData =
				          FXCollections.observableArrayList(
				                new PieChart.Data("1 - 10", read.get1To10()),
				                new PieChart.Data("11 - 20", read.get11To20()),
				                new PieChart.Data("21 - 30", read.get21To30()),
				                new PieChart.Data("31 - 40", read.get31To40()),
				                new PieChart.Data("41 - 50", read.get41To50()),
				                new PieChart.Data("51 - 60", read.get51To60()),
				                new PieChart.Data("61 - 70", read.get61To70()),
				                new PieChart.Data("71 - 80", read.get71To80()),
				                new PieChart.Data("81 - 90", read.get81To90()),
				                new PieChart.Data("91 - 100", read.get91To100()),
				                new PieChart.Data("Other", read.getOthers()));
				        final PieChart pieChart = new PieChart(pieChartData);
				        pieChart.setTitle("Pie Chart");
					
					//calling methods
					values.getData().add(new Data<String, Number>("1 - 10", read.get1To10()));
					values.getData().add(new Data<String, Number>("11 - 20", read.get11To20()));
					values.getData().add(new Data<String, Number>("21 - 30", read.get21To30()));
					values.getData().add(new Data<String, Number>("31 - 40", read.get31To40()));
					values.getData().add(new Data<String, Number>("41 - 50", read.get41To50()));
					values.getData().add(new Data<String, Number>("51 - 60", read.get51To60()));
					values.getData().add(new Data<String, Number>("61 - 70", read.get61To70()));
					values.getData().add(new Data<String, Number>("71 - 80", read.get71To80()));
					values.getData().add(new Data<String, Number>("81 - 90", read.get81To90()));
					values.getData().add(new Data<String, Number>("91 - 100", read.get91To100()));
					values.getData().add(new Data<String, Number>("Other", read.getOthers()));

					//Layout for chart
					chart.getData().addAll(values);
					grid.add(chart, 0, 0);
					grid.add(pieChart, 1, 0);
					Scene scene = new Scene(grid, 800, 500);
					primaryStage.setScene(scene);
					primaryStage.show();
				}

				catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		});

		// layout with button
		btn.setLayoutX(70);
		btn.setLayoutY(180);
		btn.setText("Select File");
		group.getChildren().add(btn);
		primaryStage.setScene(new Scene(group, 220, 220));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}