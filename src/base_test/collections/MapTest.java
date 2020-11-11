package base_test.collections;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Student s = new Student("Bob", 60);
        Student s2 = new Student("Alice", 80);
        Map<String, Student> map = new HashMap<>();
        map.put("Bob", s);
        map.put("Alice", s2);
        Student stu = map.get("Bob");
        System.out.println(stu==s);
        System.out.println(stu.getScore());
        for (Map.Entry<String, Student> entry :
                map.entrySet()) {
            String key= entry.getKey();
            Student student= entry.getValue();
            System.out.println(key+" "+student);
        }
    }
}

class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}