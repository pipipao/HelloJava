package base_test;

public class HelloString {
    public static void main(String[] args) {
        String s = "1.0";
        int i = s.indexOf(".");
        if (Integer.parseInt(s.substring(i + 1, s.length())) == 0) {
            System.out.println(s.substring(0, i));
        } else {
            System.out.println(s.substring(i+1,s.length()));
        }
        String ss = "张三";
        System.out.println("*"+ss.substring(1,ss.length()));
    }


}
