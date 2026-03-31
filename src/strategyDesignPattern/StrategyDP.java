package strategyDesignPattern;

interface PaymentStrategy{
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy{
    @Override
    public void pay(double amount){
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class UpiPayment implements PaymentStrategy{
    @Override
    public void pay(double amount){
        System.out.println("Paid " + amount + " using UPI");
    }
}

class PayPalPayment implements PaymentStrategy{
    @Override
    public void pay(double amount){
        System.out.println("Paid " + amount + " using PayPal");
    }
}

class PaymentContext{
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount){
        paymentStrategy.pay(amount);
    }
}
public class StrategyDP {
    /*
        http://chatgpt.com/c/69cbee9d-7c58-8321-b4aa-919822011ec1
    */
    public static void main(String[] args){
        // Creating payment strategies
        PaymentStrategy creditCardPayment = new CreditCardPayment();
        PaymentStrategy upiPayment = new UpiPayment();
        PaymentStrategy payPalPayment = new PayPalPayment();

        // Initially using CreditCardPayment
        PaymentContext paymentContext = new PaymentContext(creditCardPayment);
        paymentContext.pay(1000);

        // Dynamically change the payment strategy to upiPayment
        paymentContext.setPaymentStrategy(upiPayment);
        paymentContext.pay(2000);

        // Dynamically change the payment strategy to payPalPayment
        paymentContext.setPaymentStrategy(payPalPayment);
        paymentContext.pay(3000);
    }
}
