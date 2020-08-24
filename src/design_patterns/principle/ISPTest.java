package design_patterns.principle;

public class ISPTest {
    public static void main(String[] args) {
        InputModule inputModule=StuScoreList.getInputModule();
        CountModule countModule=StuScoreList.getCountModule();
        PrintModule printModule=StuScoreList.getPrintModule();
        inputModule.delete();;
        countModule.countAvgScore();
        printModule.printStuInfo();
    }
}

interface InputModule{
    void insert();
    void delete();
    void modify();
}
interface CountModule{
    void countTotalScore();
    void countAvgScore();
}
interface PrintModule{
    void printStuInfo();
    void queryStuInfo();
}
class StuScoreList implements InputModule,CountModule,PrintModule{
    private StuScoreList(){}
    public static InputModule getInputModule(){
        return (InputModule)new StuScoreList();
    }
    public static CountModule getCountModule(){
        return (CountModule)new StuScoreList();
    }
    public static PrintModule getPrintModule(){
        return (PrintModule)new StuScoreList();
    }
    @Override
    public void insert() {
        System.out.println("InoutModule input");
    }

    @Override
    public void delete() {
        System.out.println("InoutModule delete");
    }

    @Override
    public void modify() {
        System.out.println("InoutModule modify");
    }

    @Override
    public void countTotalScore() {
        System.out.println("CountModule countTotalScore");
    }

    @Override
    public void countAvgScore() {
        System.out.println("CountModule countAvgScore");
    }

    @Override
    public void printStuInfo() {
        System.out.println("PrintModule printStuInfo");
    }

    @Override
    public void queryStuInfo() {
        System.out.println("PrintModule queryStuInfo");
    }
}