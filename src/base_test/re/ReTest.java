package base_test.re;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReTest {
    @Test
    public void numberTest() {
        String s = "0755-7654.321";
        System.out.println(isValidCNNumber(s));
    }
    public boolean isValidNumber(String s) {
        return s.matches("\\d{11}");
    }

    public boolean isValidCNNumber(String s) {
        return s.matches("\\d{3,4}-\\d{7,8}");
    }

    @Test
    public void complicateTest() {
        String s = "A380";
        System.out.println(s);
        String re = "^A\\d{3}$";
        boolean b=s.matches(re);
        System.out.println(b);
    }

    @Test
    public void groupReTest() {
        Pattern p=Pattern.compile("(\\d{3,4})\\-(\\d{7,8})");
        Matcher m=p.matcher("010-12345678");
        if (m.matches()) {
            String s1=m.group(0);
            String s2=m.group(1);
            String s3=m.group(2);
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s3);
        }
    }

    @Test
    public void noneGreedyReTest() {
        Pattern p=Pattern.compile("(\\d+?)(0*)");
        Matcher m=p.matcher("1230000");
        if (m.matches()) {
            System.out.println(m.group(1));
            System.out.println(m.group(2));
        }

    }
}
