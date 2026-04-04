package templateDesignPattern;

class BurgerOrder{
    public void processOrder(){
        takeOrder();
        cookBurger();
        pack();
        deliver();
    }

    private void takeOrder(){
        System.out.println("Taking Burger Order...");
    }
    private void cookBurger(){
        System.out.println("Cooking Burger...");
    }
    private void pack(){
        System.out.println("Packing Burger...");
    }
    private void deliver(){
        System.out.println("Delivering Burger...");
    }
}

class PizzaOrder{
    public void processOrder(){
        takeOrder();
        bakePizza();
        pack();
        deliver();
    }

    private void takeOrder(){
        System.out.println("Taking Pizza Order...");
    }
    private void bakePizza(){
        System.out.println("Baking Pizza...");
    }
    private void pack(){
        System.out.println("Packing Pizza...");
    }
    private void deliver(){
        System.out.println("Delivering Pizza...");
    }
}
public class WithoutTemplateDP {
    public static void main(String[] args){
        BurgerOrder burgerOrder = new BurgerOrder();
        burgerOrder.processOrder();

        PizzaOrder pizzaOrder = new PizzaOrder();
        pizzaOrder.processOrder();
    }
}
