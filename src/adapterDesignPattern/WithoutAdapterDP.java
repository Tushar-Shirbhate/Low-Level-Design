package adapterDesignPattern;

import java.util.Scanner;

class SmartHomeController{
    public void controlDevice(String deviceType){
        if(deviceType.equalsIgnoreCase("AirConditioner")){
            System.out.println("Connecting to AirConditioner via Bluetooth...");
        } else if (deviceType.equalsIgnoreCase("SmartLight")) {
            System.out.println("Connecting to SmartLight via Wi-Fi...");
        } else if (deviceType.equalsIgnoreCase("CoffeeMachine")) {
            System.out.println("Connecting to CoffeeMachine via Zigbee...");
        } else {
            System.out.println("Device type not supported!");
        }
    }
}

public class WithoutAdapterDP {
    public static void main(String[] args) {
        SmartHomeController controller = new SmartHomeController();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Smart Home Controller!");

        System.out.println("Available devices: AirConditioner, SmartLight, CoffeeMachine");

        while (true){
            System.out.println("Enter the device you want to control (or type 'exit' to quit): ");
            String deviceType = scanner.nextLine();
            if(deviceType.equalsIgnoreCase("exit")){
                System.out.println("Exiting the Smart Home Controller. Goodbye!");
                break;
            }
            controller.controlDevice(deviceType);
        }
        scanner.close();
    }
}
