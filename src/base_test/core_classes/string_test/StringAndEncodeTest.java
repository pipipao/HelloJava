package base_test.core_classes.string_test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class StringAndEncodeTest {
    @Test
    public void testBuildString() {
        String s1 = new String(new char[]{'h', 'i'});
        int[] a = new int[5];
        System.out.println(Arrays.toString(a)+s1);
    }
    @Test
    public void testStr(){
        String s1="hi";
        String s2="hi";
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));

        s2="HI";
        s1=s1.toUpperCase();
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
    }

}
