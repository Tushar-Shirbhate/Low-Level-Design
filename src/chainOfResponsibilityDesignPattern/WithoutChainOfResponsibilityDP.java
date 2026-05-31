package chainOfResponsibilityDesignPattern;

public class WithoutChainOfResponsibilityDP {
    public static void main(String[] args) {
        int leaveDays = 10;

        if(leaveDays <= 3){
            System.out.println("Supervisor approved the leaves");
        } else if (leaveDays <= 7) {
            System.out.println("Manager approved the leaves");
        } else if (leaveDays <= 14) {
            System.out.println("Director approved the leaves");
        }
        else {
            System.out.println("Leave request denied. Too many days!");
        }
    }
}
