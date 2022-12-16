import java.time.LocalDate;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.GridPane;

public class InfoPanel extends GridPane {
	 
	InfoPanel(){
		addChart();
		setId("infoPane");
	}
	
    static XYChart.Series series = new XYChart.Series();
	
	void addChart(){
		final NumberAxis xaxis = new NumberAxis(1,31,1);  
		final NumberAxis yaxis = new NumberAxis(-20,20,1);
        LineChart lineChart = new LineChart(xaxis,yaxis);  
        
        series.setName("Daily Tasks");
        
        setChartPoint();
		
        lineChart.getData().add(series);
		add(lineChart, 0, 0);
	}
	static void setChartPoint(){
		series.getData().add(new XYChart.Data(LocalDate.now().getDayOfMonth(),dailyTaskPoints));
	}
	static int dailyTaskPoints = 0;
	static void addDailyTaskPoints(int x) {
		dailyTaskPoints += x;
	}
}
