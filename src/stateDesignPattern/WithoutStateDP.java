package stateDesignPattern;

class ATM {
    private String state;

    public ATM() {
        this.state = "NO_CARD";
    }

    public void next() {
        if (state.equals("NO_CARD")) {
            state = "CARD_INSERTED";
            System.out.println("Card inserted");
        }
        else if (state.equals("CARD_INSERTED")){
            state = "PIN_VERIFIED";
            System.out.println("PIN verified");
        }
        else if (state.equals("PIN_VERIFIED")){
            state = "NO_CARD";
            System.out.println("Money withdrawn");
        }
    }
}
public class WithoutStateDP {
    public static void main(String[] args){
        ATM atm = new ATM();
        atm.next();
        atm.next();
        atm.next();
    }
}
