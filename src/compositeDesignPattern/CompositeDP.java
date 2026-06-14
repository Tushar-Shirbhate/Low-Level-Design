package compositeDesignPattern;

import java.util.ArrayList;
import java.util.List;

interface SmartComponent{
    void turnOn();
    void turnOff();
}

class AirConditionerCDP implements SmartComponent{
    @Override
    public void turnOn() {
        System.out.println("Air Conditioner is now ON.");
    }

    @Override
    public void turnOff() {
        System.out.println("Air Conditioner is now OFF.");
    }
}

class SmartLightCDP implements SmartComponent{
    @Override
    public void turnOn() {
        System.out.println("Smart Light is now ON.");
    }

    @Override
    public void turnOff() {
        System.out.println("Smart Light is now OFF.");
    }
}

class CompositeSmartComponent implements SmartComponent{
    private List<SmartComponent> smartComponents = new ArrayList<>();

    public void addComponents(SmartComponent smartComponent){
        smartComponents.add(smartComponent);
    }

    public void removeComponent(SmartComponent smartComponent){
        smartComponents.add(smartComponent);
    }

    @Override
    public void turnOn() {
        for(SmartComponent smartComponent : smartComponents){
            smartComponent.turnOn();
        }
    }

    @Override
    public void turnOff() {
        for (SmartComponent smartComponent: smartComponents){
            smartComponent.turnOff();
        }
    }
}
public class CompositeDP {
    public static void main(String[] args) {
        // Create individual devices
        SmartComponent airConditioner = new AirConditionerCDP();
        SmartComponent smartLight = new SmartLightCDP();

        // Create a room and add devices
        CompositeSmartComponent room1 = new CompositeSmartComponent();
        room1.addComponents(airConditioner);
        room1.addComponents(smartLight);

        // Add more rooms for demonstration
        CompositeSmartComponent room2 = new CompositeSmartComponent();
        room2.addComponents(airConditioner);
        room2.addComponents(smartLight);

        CompositeSmartComponent floor1 = new CompositeSmartComponent();
        floor1.addComponents(room1);

        CompositeSmartComponent floor2 = new CompositeSmartComponent();
        floor2.addComponents(room2);

        // Create a house and add floors
        CompositeSmartComponent house = new CompositeSmartComponent();
        house.addComponents(floor1);

        // Control the entire house
        System.out.println("Turning ON all devices in the house:");
        house.turnOn();
        System.out.println("Turning OFF all devices in the house:");
        house.turnOff();

        // Control a single floor
        System.out.println("Turning ON all devices on the first floor:");
        floor1.turnOn();
        System.out.println("Turning OFF all devices on the first floor:");
        floor1.turnOff();

        // Control a single room
        System.out.println("Turning ON all devices in Room 1:");
        room1.turnOn();
        System.out.println("Turning OFF all devices in Room 1:");
        room1.turnOff();
    }
}
