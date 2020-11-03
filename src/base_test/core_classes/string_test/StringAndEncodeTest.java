package base_test.core_classes.string_test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.StringJoiner;

public class StringAndEncodeTest {
    @Test
    public void testBuildString() {
        String s1 = new String(new char[]{'h', 'i'});
        int[] a = new int[5];
        System.out.println(Arrays.toString(a) + s1);
    }

    @Test
    public void testStr() {
        String s1 = "hi";
        String s2 = "hi";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        s2 = "HI";
        s1 = s1.toUpperCase();
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }

    @Test
    public void testStrMethod() {
        String s = " hello world";
        System.out.println(s.contains("ll"));
        System.out.println(s.indexOf("l"));
        System.out.println(s.lastIndexOf("l"));
        System.out.println(s.startsWith("he"));
        System.out.println(s.endsWith("ld"));
        System.out.println(s.substring(2, 4));
        System.out.println(s.trim());
        System.out.println(s.strip());
        String b = "A,,B;C ,D";
        s.replaceAll("[\\,\\;\\s]+", ",");
        String c = "a,b,c,d";
        String[] arry = c.split(",");
        System.out.println(Arrays.toString(arry));
        String[] arr = {"A", "BB", "C"};
        System.out.println(String.join("", arr));
        System.out.println(String.join("***", arr));
    }

    @Test
    public void convertTest() {
        String s1 = String.valueOf(123);
        String s2 = String.valueOf(45.67);
        String s3 = String.valueOf(true);
        int n1 = Integer.parseInt("123");
        int n2 = Integer.parseInt("ff", 16);
        boolean b1 = Boolean.parseBoolean("true");
        boolean b2 = Boolean.parseBoolean("FALSE");

    }

    @Test
    public void stringBuilderTest() {
        var sb = new StringBuilder(1024);
        sb.append("Mr")
                .append("pipi")
                .insert(0, "hi,")
                .append("!")
                .append(1);
        System.out.println(sb.toString());
    }

    @Test
    public void stringJoinerTest(){
        String[] names={"Bob","Alice","Lili"};
        var sj=new StringJoiner(",","hello","!");
        for(String name:names){
            sj.add(name);
        }
        String s=String.join(",",names);
        System.out.println(s);

        System.out.println(sj.toString());
    }

}
