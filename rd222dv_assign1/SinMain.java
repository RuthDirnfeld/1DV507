package rd222dv_assign1;

import java.util.ArrayList;
import java.util.List;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

public class SinMain {
	public static void main(String[] args) throws Exception {
		// Create Chart
		XYChart chart = new XYChartBuilder().width(800).height(600).build();
		
		List<Double> xData = new ArrayList<Double>();
		List<Double> yData = new ArrayList<Double>();
		double x = 0.0;
		while(0 <= x && x <= (2*Math.PI)){
			xData.add(x);
			yData.add((1+ x/Math.PI)*Math.cos(x)*Math.cos(40*x));
			x=x+0.001;
		}
		chart.addSeries("SinMain", xData, yData);
		new SwingWrapper<XYChart>(chart).displayChart();
		}
	}
	   //Write a program SinMain.java plotting the curve y = (1 + x/pi)*cos(x)*cos(40*x) in the range 0 <= x <= 2*pi.