package base_test.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleTest {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
    }
}
