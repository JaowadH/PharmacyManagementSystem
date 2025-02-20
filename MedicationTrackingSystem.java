import java.util.ArrayList;
import java.util.List;

public class MedicationTrackingSystem {
    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private List<Medication> medications = new ArrayList<>();
    private List<Prescription> prescriptions = new ArrayList<>();

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }
}
public void addMedication(Medication medication) {
    medications.add(medication);
}

public void assignPatientToDoctor(int patientId, int doctorId) {
    Patient patient = findPatientById(patientId);
    Doctor doctor = findDoctorById(doctorId);
    if (patient != null && doctor != null) {
        doctor.addPatient(patient);
    }
}

private Patient findPatientById(int id) {
    return patients.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
}

private Doctor findDoctorById(int id) {
    return doctors.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
}
