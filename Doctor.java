import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person {
    private String specialization;
    private List<Patient> patients;

    public Doctor(int id, String name, int age, String phoneNumber, String specialization) {
        super(id, name, age, phoneNumber);
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    public List<Patient> getPatients() {
        return patients;
    }
    
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return String.format(
            "Doctor ID: %d%nDoctor Name: %s%nDoctor Age: %d%nDoctor Phone Number: %s%nSpecialization: %s%nNumber of Patients: %d%n",
            getId(), getName(), getAge(), getPhoneNumber(), specialization, patients.size()
        );
    }
}
