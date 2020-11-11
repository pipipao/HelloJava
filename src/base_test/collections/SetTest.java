package base_test.collections;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Bob");
        set.add("Alice");
        set.add("Lili");
        System.out.println(set.contains("Bob"));
        System.out.println(set.remove("Bob"));
        System.out.println(set.remove("Bob"));
        System.out.println(set.size());


    }
}
