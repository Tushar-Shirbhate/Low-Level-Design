package strategyDesignPattern;

class PaymentService{
    public void pay(String type, double amount){
        if(type.equals("CREDIT_CARD")){
            System.out.println("Paid " + amount + " using Credit Card");
        }
        else if(type.equals("UPI")){
            System.out.println("Paid " + amount + " using UPI");
        }
        else if(type.equals("PAYPAL")){
            System.out.println("Paid " + amount + " using PayPal");
        }
    }
}

public class WithoutStrategyDP {
    public static void main(String[] args){
        PaymentService paymentService = new PaymentService();

        paymentService.pay("CREDIT_CARD", 1000);
        paymentService.pay("UPI", 2000);
        paymentService.pay("PAYPAL", 3000);
    }
}
