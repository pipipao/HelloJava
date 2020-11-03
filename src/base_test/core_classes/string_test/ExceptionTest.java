package base_test.core_classes.string_test;

import org.junit.jupiter.api.Test;

public class ExceptionTest {
    @Test
    public void deepThrowExceptionsTest() {
        try {
            process1();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void process1() {
        process2();
    }

    static void process2() {
        Integer.parseInt(null);
    }
    @Test
    public void mutiExceptionsTest(){
        try {
            process3();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    static void process3() {
        try {
            process4();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(e);
        }
    }

    static void process4() {
        throw new NullPointerException();
    }
}
