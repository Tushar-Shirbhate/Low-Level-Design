package bridgeDesignPattern;

abstract class ShapeWBDP{
    public abstract void draw();
}

class CircleWBDP extends ShapeWBDP{
    @Override
    public void draw() {
        System.out.println("Drawing Circle using Raster Rendering.");
    }
}

class RectangleWBDP extends ShapeWBDP{
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle using Raster Rendering");
    }
}

public class WithoutBridgeDP {
    public static void main(String[] args) {
        ShapeWBDP circle = new CircleWBDP();
        circle.draw();

        ShapeWBDP rectangle = new RectangleWBDP();
        circle.draw();
    }
}
