import java.time.LocalDate;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.GridPane;

public class InfoPanel extends GridPane {
	 
	InfoPanel(){
		add(getChart(), 0, 0);
		setId("infoPane");
	}
	
    static XYChart.Series series = new XYChart.Series();
	
	static getChart(){
		final NumberAxis xaxis = new NumberAxis(1,31,1);  
		final NumberAxis yaxis = new NumberAxis(-20,20,1);
        LineChart linechart = new LineChart(xaxis,yaxis);  
        
        series.setName("Daily Tasks");
        
        setChartPoint();
		
        linechart.getData().add(series);
		return linechart;
	}
	static void setChartPoint(){
		series.getData().add(new XYChart.Data(LocalDate.now().getDayOfMonth(),dailyTaskPoints));
	}
	static int dailyTaskPoints = 0;
	static void addDailyTaskPoints(int x) {
		dailyTaskPoints += x;
	}
}
