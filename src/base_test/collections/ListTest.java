package base_test.collections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
    @Test
    public void arrayListTest() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add(null);
        list.add("C");
        list.add("D");
        list.remove(0);
        list.remove("A");
        String c = list.get(0);
        int s = list.size();
        System.out.println(c + "" + s);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void linkedListTest() {
        List<String> list = List.of("A", "B", "C");
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            String s = it.next();
            System.out.println(s);
        }
        for (String c :
                list) {
            System.out.println(c);
        }

    }

    @Test
    public void convertTest() {
        Integer[] arr = {1, 2, 3};
        List<Integer> list=List.of(arr);
        for (Integer i :
                list) {
            System.out.println(i);
        }
        Integer[] array=list.toArray(new Integer[list.size()]);
        for (Integer i :
                array) {
            System.out.println(i);
        }
    }
}
