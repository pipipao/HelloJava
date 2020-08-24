package design_patterns.principle;

public class LSPTest {
    public static void main(String[] args) {
        Bird swallow = new Swallow();
        Bird brownKiwi = new BrownKiwi();
        swallow.setFlySpeed(150);
        brownKiwi.setFlySpeed(100);
        System.out.println("Fly 300 KM");
        try {
            System.out.println("It takes " + swallow.getFlyTime(300) +
                    " for swallow to fly.");
            System.out.println("It takes " + brownKiwi.getFlyTime(300) +
                    " for brown kiwi to fly.");

        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();

        }
    }
}

class Bird {
    public double getFlySpeed() {
        return flySpeed;
    }

    public void setFlySpeed(double flySpeed) {
        this.flySpeed = flySpeed;
    }

    public double getFlyTime(double distance) {
        return distance / flySpeed;
    }

    double flySpeed;

}

class Swallow extends Bird {
}

class BrownKiwi extends Bird {
    @Override
    public void setFlySpeed(double flySpeed) {
        this.flySpeed = 0;
    }
}