package base_test.core_classes.string_test;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public class ReflectionTest {
    @Test
    public void classTest() {
        Logger logger = Logger.getGlobal();
        Class cls = String.class;
        String s="hello";
        Class cls2 = s.getClass();
        logger.info(cls.toString());
        logger.info(cls2.toString());
        try {
            String s2=(String) cls2.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void reflectionTest() {
        Class cls=Student.class;
        try {
            System.out.println(cls.getDeclaredField("score"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(cls.getField("name"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void reflectionGetMethodTest() throws Exception{
        String s="Hello World";
        Class cls=s.getClass();
        Method m = cls.getMethod("substring", int.class);
        String r = (String) m.invoke(s, 6);
        System.out.println(r);


    }
}
class PersonRef{
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Student extends PersonRef{
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
