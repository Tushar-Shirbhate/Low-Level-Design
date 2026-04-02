package commandDesignPattern;

class LightWCDP {
    public void turnOn(){
        System.out.println("Light is turned on");
    }
    public void turnOff(){
        System.out.println("Light is turned off");
    }
}

class FanWCDP {
    public void turnOn(){
        System.out.println("Fan is turned on");
    }
    public void turnOff(){
        System.out.println("Fan is turned off");
    }
}

class RemoteControlWCDP {
    LightWCDP lightWCDP = new LightWCDP();
    FanWCDP fanWCDP = new FanWCDP();

    public void pressButton(String action){
        if(action.equals("LIGHT_ON")){
            lightWCDP.turnOn();
        }
        else if (action.equals("LIGHT_OFF")){
            lightWCDP.turnOff();
        }
        else if (action.equals("FAN_ON")){
            fanWCDP.turnOn();
        }
        else if (action.equals("FAN_OFF")){
            fanWCDP.turnOff();
        }
    }
}

public class WithoutCommandDP {
    public static void main(String[] args){
        RemoteControlWCDP remoteControlWCDP = new RemoteControlWCDP();
        remoteControlWCDP.pressButton("LIGHT_ON");
        remoteControlWCDP.pressButton("LIGHT_OFF");
        remoteControlWCDP.pressButton("FAN_ON");
        remoteControlWCDP.pressButton("FAN_OFF");
    }
}
