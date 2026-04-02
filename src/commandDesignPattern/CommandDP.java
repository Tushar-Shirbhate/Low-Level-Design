package commandDesignPattern;

class LightCDP{
    public void turnOn(){
        System.out.println("Light is turned on");
    }
    public void turnOff(){
        System.out.println("Light is turned off");
    }
}

class FanCDP{
    public void turnOn(){
        System.out.println("Fan is turned on");
    }
    public void turnOff(){
        System.out.println("Fan is turned off");
    }
}

interface Command{
    void execute();
}

class LightOnCommand implements Command{
    private LightCDP lightCDP;

    public LightOnCommand(LightCDP lightCDP){
        this.lightCDP = lightCDP;
    }

    @Override
    public void execute(){
        lightCDP.turnOn();
    }
}

class LightOffCommand implements Command{
    private LightCDP lightCDP;

    public LightOffCommand(LightCDP lightCDP){
        this.lightCDP = lightCDP;
    }

    @Override
    public void execute(){
        lightCDP.turnOff();
    }
}

class FanOnCommand implements Command{
    private FanCDP fanCDP;

    public FanOnCommand(FanCDP fanCDP){
        this.fanCDP = fanCDP;
    }

    @Override
    public void execute(){
        fanCDP.turnOn();
    }
}

class FanOffCommand implements Command{
    private FanCDP fanCDP;

    public FanOffCommand(FanCDP fanCDP){
        this.fanCDP = fanCDP;
    }

    @Override
    public void execute(){
        fanCDP.turnOff();
    }
}

class RemoteControlCDP{
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton(){
        command.execute();
    }
}

public class CommandDP {
    public static void main(String[] args){
        RemoteControlCDP remoteControlCDP = new RemoteControlCDP();
        LightCDP lightCDP = new LightCDP();
        FanCDP fanCDP = new FanCDP();

        remoteControlCDP.setCommand(new LightOnCommand(lightCDP));
        remoteControlCDP.pressButton();

        remoteControlCDP.setCommand(new LightOffCommand(lightCDP));
        remoteControlCDP.pressButton();

        remoteControlCDP.setCommand(new FanOnCommand(fanCDP));
        remoteControlCDP.pressButton();

        remoteControlCDP.setCommand(new FanOffCommand(fanCDP));
        remoteControlCDP.pressButton();
    }
}
