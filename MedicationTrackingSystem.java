import java.util.ArrayList;
import java.util.Date;
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

    public void checkExpiredMedications() {
        Date today = new Date();
        for (Medication m : medications) {
            if (m.getExpiryDate().before(today)) {
                System.out.println(m.getName() + " has expired!");
            }
        }
    }
}

// Placeholder Patient Class
class Patient {
    private int id;
    private String name;

    public Patient(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

// Placeholder Doctor Class
class Doctor {
    private int id;
    private String name;
    private List<Patient> assignedPatients = new ArrayList<>();

    public Doctor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addPatient(Patient patient) {
        assignedPatients.add(patient);
    }
}