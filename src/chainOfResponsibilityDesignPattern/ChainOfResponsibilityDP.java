package chainOfResponsibilityDesignPattern;

abstract class Approver{
    protected Approver nextApprover;

    public void setNextApprover(Approver nextApprover){
        this.nextApprover = nextApprover;
    }

    public abstract void processLeaveRequest(int leaveDays);
}

class Supervisor extends Approver{
    @Override
    public void processLeaveRequest(int leaveDays){
        if(leaveDays <= 3){
            System.out.println("Supervisor approved the leaves");
        } else if (nextApprover != null) {
            nextApprover.processLeaveRequest(leaveDays);
        }
    }
}

class Manager extends Approver{
    @Override
    public void processLeaveRequest(int leaveDays){
        if(leaveDays <= 7) {
            System.out.println("Manager approved the leaves");
        } else if (nextApprover != null) {
            nextApprover.processLeaveRequest(leaveDays);
        }
    }
}

class Director extends Approver{
    @Override
    public void processLeaveRequest(int leaveDays) {
        if (leaveDays <= 14){
            System.out.println("Director approved the leaves");
        } else if (nextApprover != null) {
            nextApprover.processLeaveRequest(leaveDays);
        } else {
            System.out.println("Leave request denied. Too many days!");
        }
    }
}

public class ChainOfResponsibilityDP {
    public static void main(String[] args) {
        Approver supervisor = new Supervisor();
        Approver manager = new Manager();
        Approver director = new Director();

        supervisor.setNextApprover(manager);
        manager.setNextApprover(director);

        int leaveDays = 10;
        System.out.println("Leave days: " + leaveDays);
        supervisor.processLeaveRequest(leaveDays);
    }
}
