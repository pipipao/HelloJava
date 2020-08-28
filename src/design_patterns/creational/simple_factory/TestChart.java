package design_patterns.creational.simple_factory;

public class TestChart {
    public static void main(String[] args) {
        Chart chart;
        String name=XMLUtil.getChartName();
        chart=ChartFactory.getChart(name);
        chart.display();
    }
}
interface Chart{
    public void display();
}
class HistogramChart implements Chart{
    public HistogramChart() {
        System.out.println("Build HistogramChart");
    }

    @Override
    public void display() {
        System.out.println("HistogramChart");
    }
}
class PieChart implements Chart{
    public PieChart() {
        System.out.println("Build PieChart");
    }

    @Override
    public void display() {
        System.out.println("PieChart");
    }
}
class LineChart implements Chart{
    public LineChart() {
        System.out.println("Build LineChart");
    }
    @Override
    public void display() {
        System.out.println("LineChart");
    }

}

class ChartFactory{
    public static Chart getChart(String name){
        Chart chart=null;
        if (name.equalsIgnoreCase("HistogramChart")){
            chart=new HistogramChart();
        }else if (name.equalsIgnoreCase("PieChart")){
            chart=new PieChart();
        }else if (name.equalsIgnoreCase("LineChart")){
            chart=new LineChart();
        }
        return chart;
    }
}