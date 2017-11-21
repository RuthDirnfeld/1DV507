package rd222dv_assign1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.lang.model.type.ArrayType;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.PieStyler.AnnotationType;
import org.knowm.xchart.style.Styler.LegendPosition;

public class ChartMain {
	public static void main(String[] args) {

	    // Create Chart
	    PieChart chart = new PieChartBuilder().width(800).height(600).build();;

	    // Customize Chart
	    chart.getStyler().setLegendVisible(false);
	    chart.getStyler().setAnnotationType(AnnotationType.LabelAndPercentage);
	    chart.getStyler().setAnnotationDistance(1.15);
	    chart.getStyler().setPlotContentSize(.7);
	    chart.getStyler().setStartAngleInDegrees(90);

	    // Series
	    chart.addSeries("1 - 10", 6);
	    chart.addSeries("11 - 20", 4);
	    chart.addSeries("21 - 30", 3);
	    chart.addSeries("31 - 40", 6);
	    chart.addSeries("41 - 50", 3);
	    chart.addSeries("51 - 60", 7);
	    chart.addSeries("61 - 70", 5);
	    chart.addSeries("71 - 80", 3);
	    chart.addSeries("81 - 90", 7);
	    chart.addSeries("91 - 100", 8);

	    // Show it
	    new SwingWrapper(chart).displayChart();
	    
	   CategoryChart chart2 = new CategoryChartBuilder().width(800).height(600).build();
	    
	    // Customize Chart
	    chart2.getStyler().setLegendPosition(LegendPosition.InsideNW);
	    chart2.getStyler().setHasAnnotations(true);
	
	    // Series
	    chart2.addSeries("Bar-Chart",Arrays.asList(new String[] {"1 - 10", "11 - 20", "21 - 30", "31 - 40", 
	    		"41 - 50", "51 - 60", "61 - 70", "71 - 80", "81 - 90", "91 - 100"}), Arrays.asList(new Integer[] { 6, 4, 3, 6, 3, 7, 5, 3, 7, 8 }));
	    
	    new SwingWrapper(chart2).displayChart();
	  }

	}

