import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {
    private List<Medication> medications;
    private List<Prescription> prescriptions;

    public Patient(int id, String name, int age, String phoneNumber) {
        super(id, name, age, phoneNumber);
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    // Add medication to patient's list
    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    // Add prescription to patient's list
    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    @Override
    public String toString() {
        return String.format("Patient ID: %d%n Patient name: %s%n, Patient age: %d%n Patient phone number: %s%n Patient medication: %d%n Patient prescription: %d%n ",
        getId(), getName(), getAge(), getPhoneNumber(), medications.size(), prescriptions.size() );
    }
}
