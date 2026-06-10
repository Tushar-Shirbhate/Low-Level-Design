package visitorDesignPattern;

//ChildPatient.java
class ChildPatient{
    public void diagnosis(){
        System.out.println("Diagnosing a child patient");
    }
    public void billing(){
        System.out.println("Calculating billing a child patient");
    }
}

//AdultPatient.java
class AdultPatient{
    public void diagnosis(){
        System.out.println("Diagnosing an adult patient");
    }
    public void billing(){
        System.out.println("Calculating billing an adult patient");
    }
}

//SeniorPatient.java
class SeniorPatient{
    public void diagnosis(){
        System.out.println("Diagnosing a senior patient");
    }
    public void billing(){
        System.out.println("Calculating billing for a senior patient");
    }
}
public class WithoutVisitorDP {
    public static void main(String[] args) {
        Object patient = new AdultPatient();

        if (patient instanceof ChildPatient){
            ((ChildPatient)patient).diagnosis();
            ((ChildPatient)patient).billing();
        } else if (patient instanceof AdultPatient) {
            ((AdultPatient)patient).diagnosis();
            ((AdultPatient)patient).billing();
        } else if (patient instanceof SeniorPatient) {
            ((SeniorPatient)patient).diagnosis();
            ((SeniorPatient)patient).billing();
        }
    }
}
