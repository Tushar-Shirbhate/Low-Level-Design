package stateDesignPattern;

interface ATMState{
    void next(ATMContext context);
}

class NoCardState implements ATMState{
    @Override
    public void next(ATMContext context){
        context.setState(new CardInsertedState());
        System.out.println("Card inserted");
    }
}

class CardInsertedState implements ATMState{
    @Override
    public void next(ATMContext context){
        context.setState(new PinVerifiedState());
        System.out.println("PIN verified");
    }
}

class PinVerifiedState implements ATMState{
    @Override
    public void next(ATMContext context){
        context.setState(new NoCardState());
        System.out.println("Money withdrawn");
    }
}

class ATMContext {
    private ATMState state;

    public ATMContext(){
        state = new NoCardState();
    }

    public void next(){
        state.next(this);
    }

    public void setState(ATMState state){
        this.state = state;
    }
}
public class StateDP {
    public static void main(String[] args){
        ATMContext atmContext = new ATMContext();
        atmContext.next();
        atmContext.next();
        atmContext.next();
    }
}
