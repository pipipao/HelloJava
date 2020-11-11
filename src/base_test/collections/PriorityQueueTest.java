package base_test.collections;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

    public static void main(String[] args) {
        Queue<User> queue=new PriorityQueue<>(new UserComparator());
        queue.offer(new User("Bob", "A1"));
        queue.offer(new User("Alice", "A2"));
        queue.offer(new User("Boss", "V2"));
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}

class UserComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        if (o1.getNumber().charAt(0) == o2.getNumber().charAt(0)) {
            return o1.getNumber().compareTo(o2.getNumber());
        }
        if (o1.getNumber().charAt(0) == 'V') {
            return -1;
        }
        return 1;
    }
}

class User {
    private String name;
    private String number;

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
