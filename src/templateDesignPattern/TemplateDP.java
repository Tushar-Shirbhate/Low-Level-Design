package templateDesignPattern;

abstract class FoodOrderTemplate{
    // Template Method (final → cannot be changed)
    public final void processOrder(){
        takeOrder();
        prepareItem();
        packItem();
        deliverItem();
    }

    private void takeOrder(){
        System.out.println("Taking Order...");
    }

    private void packItem(){
        System.out.println("Packing Item...");
    }

    private void deliverItem(){
        System.out.println("Delevering Item...");
    }

    protected abstract void prepareItem();
}

class BurgerOrderTemplate extends FoodOrderTemplate{
    @Override
    protected void prepareItem(){
        System.out.println("Cooking Burger...");
    }
}

class PizzaOrderTemplate extends FoodOrderTemplate{
    @Override
    protected void prepareItem(){
        System.out.println("Baking Pizza...");
    }
}

public class TemplateDP {
    public static void main(String[] args) {
        FoodOrderTemplate burger = new BurgerOrderTemplate();
        burger.processOrder();

        FoodOrderTemplate pizza = new PizzaOrderTemplate();
        pizza.processOrder();
    }
}
