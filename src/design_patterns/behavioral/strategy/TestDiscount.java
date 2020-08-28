package design_patterns.behavioral.strategy;

public class TestDiscount {
    public static void main(String[] args) {
        MovieTicket movieTicket = new MovieTicket();
        movieTicket.setPrice(100);
        movieTicket.setDiscount(new ChildrenDiscount());
        System.out.println(movieTicket.getPrice());
    }
}

interface Discount {
    public double calPrice(double price);
}

class ChildrenDiscount implements Discount {
    @Override
    public double calPrice(double price) {
        return price * 0.5;
    }
}

class StudentDiscount implements Discount {
    @Override
    public double calPrice(double price) {
        return price * 0.8;
    }
}

class MovieTicket {
    private double price;
    private Discount discount;

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return discount.calPrice(price);
    }
}