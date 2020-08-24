package design_patterns.principle;

public class DIPTest {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.shopping(new ShopA());
        customer.shopping(new ShopB());
    }

}

interface Shop {
    public String sell();
}

class ShopA implements Shop {
    @Override
    public String sell() {
        return "goods in shop A";
    }
}

class ShopB implements Shop {
    @Override
    public String sell() {
        return "goods in shop B";
    }
}

class Customer {
    public void shopping(Shop shop) {
        System.out.println(shop.sell());
    }

}