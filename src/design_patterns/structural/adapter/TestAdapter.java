package design_patterns.structural.adapter;

public class TestAdapter {
    public static void main(String[] args) {
        ScoreOperation so=(ScoreOperation)new ScoreOperationAdapter();
        so.search();
        so.sort();
    }
}
class BinarySearch{
    public void binarySearch(){
        System.out.println("Using binary_search");
    }
}
class QuickSort{
    public void quickSort(){
        System.out.println("Using quicksort");
    }
}
interface ScoreOperation{
    public void sort();
    public void search();
}
class ScoreOperationAdapter implements ScoreOperation{
    private QuickSort qs;
    private BinarySearch bs;
    public ScoreOperationAdapter(){
        qs=new QuickSort();
        bs=new BinarySearch();
    }
    @Override
    public void sort() {
        qs.quickSort();
    }

    @Override
    public void search() {
        bs.binarySearch();

    }
}