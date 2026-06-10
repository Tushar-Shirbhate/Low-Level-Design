package visitorDesignPattern;

interface Patient {
    void accept(Visitor visitor);
}

class ChildPatientVDP implements Patient{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class AdultPatientVDP implements Patient{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class SeniorPatientVDP implements Patient{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

interface Visitor {
    void visit(ChildPatientVDP childPatient);
    void visit(AdultPatientVDP adultPatient);
    void visit(SeniorPatientVDP seniorPatient);
}

class DiagnosisVisitor implements Visitor{
    @Override
    public void visit(ChildPatientVDP seniorPatient) {
        System.out.println("Diagnosing a child patient");
    }

    @Override
    public void visit(AdultPatientVDP adultPatient) {
        System.out.println("Diagnosing an adult patient");
    }

    @Override
    public void visit(SeniorPatientVDP seniorPatient) {
        System.out.println("Diagnosing a senior patient");
    }
}

class BillingVisitor implements Visitor{
    @Override
    public void visit(ChildPatientVDP childPatient) {
        System.out.println("Calculating billing a child patient");
    }

    @Override
    public void visit(AdultPatientVDP adultPatient) {
        System.out.println("Calculating billing an adult patient");
    }

    @Override
    public void visit(SeniorPatientVDP seniorPatient) {
        System.out.println("Calculating billing for a senior patient");
    }
}

public class VisitorDP {
    public static void main(String[] args) {
        Patient[] patients = {new ChildPatientVDP(), new AdultPatientVDP(), new SeniorPatientVDP()};

        Visitor diagnosisVisitor = new DiagnosisVisitor();
        Visitor billingVisitor = new BillingVisitor();

        for (Patient patient : patients){
            patient.accept(diagnosisVisitor);
            patient.accept(billingVisitor);
        }
    }
}
