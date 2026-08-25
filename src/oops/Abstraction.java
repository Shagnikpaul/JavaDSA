package oops;

class StripePaymentMethod implements PaymentMethod {
    @Override
    public boolean process(int amount) {
        // TODO Auto-generated method stub
        return true;
    }
}

class CreditCardPaymentMethod implements PaymentMethod {
    @Override
    public boolean process(int amount) {
        // TODO Auto-generated method stub
        return true;
    }
}

class Shop {
    PaymentMethod p;

    public Shop(PaymentMethod paymentMethod) {
        p = paymentMethod;
    }

    public boolean pay(int amt) {
        return p.process(amt);
    }
}

public class Abstraction {
    public static void main(String[] args) {
        Shop s1 = new Shop(new StripePaymentMethod());
        s1.pay(21);
    }
}
