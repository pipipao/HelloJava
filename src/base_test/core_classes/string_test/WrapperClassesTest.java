package base_test.core_classes.string_test;

import org.junit.jupiter.api.Test;

public class WrapperClassesTest {
    @Test
    public void integerTest(){
        int i = 100;
        Integer n1=Integer.valueOf(200);
        Integer n2=Integer.valueOf("300");
        int n3=n2.intValue();
    }
}
