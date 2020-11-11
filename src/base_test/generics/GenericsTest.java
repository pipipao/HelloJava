package base_test.generics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest {
    @Test
    public void arrayListTest() {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }
}
class Person implements Comparable<Person>{
    @Override
    public int compareTo(Person o) {
        return 0;
    }
}