import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MedicationTrackingSystem {
    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private List<Medication> medications = new ArrayList<>();
    private List<Prescription> prescriptions = new ArrayList<>();

    public void addPatient(Patient patient) {
        if (patient != null) {
            patients.add(patient);
        }
    }

    public void addDoctor(Doctor doctor) {
        if (doctor != null) {
            doctors.add(doctor);
        }
    }

    public void addMedication(Medication medication) {
        if (medication != null) {
            medications.add(medication);
        }
    }

    public void assignPatientToDoctor(int patientId, int doctorId) {
        Patient patient = findPatientById(patientId);
        Doctor doctor = findDoctorById(doctorId);

        if (patient == null) {
            System.out.println("Patient with ID " + patientId + " not found.");
            return;
        }
        if (doctor == null) {
            System.out.println("Doctor with ID " + doctorId + " not found.");
            return;
        }

        doctor.addPatient(patient);
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
            if (m.getExpiryDate() != null && m.getExpiryDate().before(today)) {
                System.out.println(m.getName() + " has expired!");
            }
        }
    }
}
