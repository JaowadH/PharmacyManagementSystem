import java.util.*;

public class MedicationTrackingSystem {
    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Medication> medications;
    private List<Prescription> prescriptions;

    public MedicationTrackingSystem() {
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    // Search for a drug, patient, or doctor by name
    public void search(String name) {
        System.out.println("Searching for: " + name);
        boolean found = false;
        
        for (Medication med : medications) {
            if (med.getName().equalsIgnoreCase(name)) {
                System.out.println("Medication found: " + med);
                found = true;
            }
        }
        
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                System.out.println("Patient found: " + patient);
                found = true;
            }
        }
        
        for (Doctor doctor : doctors) {
            if (doctor.getName().equalsIgnoreCase(name)) {
                System.out.println("Doctor found: " + doctor);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No match found.");
        }
    }

    // Add a patient to a doctor's list
    public void addPatientToDoctor(Patient patient, Doctor doctor) {
        doctor.addPatient(patient);
        System.out.println("Patient " + patient.getName() + " added to Doctor " + doctor.getName());
    }

    // Accept a prescription
    public void acceptPrescription(Prescription prescription) {
        prescriptions.add(prescription);
        prescription.getPatient().addPrescription(prescription);
        System.out.println("Prescription added for Patient: " + prescription.getPatient().getName());
    }

    // Edit and delete medications, patients, and doctors
    public void editMedication(String name, Medication newMed) {
        for (int i = 0; i < medications.size(); i++) {
            if (medications.get(i).getName().equalsIgnoreCase(name)) {
                medications.set(i, newMed);
                System.out.println("Medication updated.");
                return;
            }
        }
        System.out.println("Medication not found.");
    }

    public void deleteMedication(String name) {
        if (medications.removeIf(med -> med.getName().equalsIgnoreCase(name))) {
            System.out.println("Medication deleted.");
        } else {
            System.out.println("Medication not found.");
        }
    }

    // Generate reports
    public void generateReport() {
        System.out.println("--- System Report ---");
        System.out.println("Patients: " + patients);
        System.out.println("Doctors: " + doctors);
        System.out.println("Medications: " + medications);
        System.out.println("Prescriptions: " + prescriptions);
    }

    // Check for expired medications
    public void checkExpiredMedications() {
        System.out.println("Checking for expired medications...");
        boolean found = false;
        for (Medication med : medications) {
            if (med.isExpired()) {
                System.out.println("Expired medication: " + med);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No expired medications found.");
        }
    }

    // Print all prescriptions by a specific doctor
    public void printPrescriptionsByDoctor(String doctorName) {
        System.out.println("Prescriptions by Doctor: " + doctorName);
        boolean found = false;
        for (Prescription prescription : prescriptions) {
            if (prescription.getDoctor().getName().equalsIgnoreCase(doctorName)) {
                System.out.println(prescription);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No prescriptions found for Dr. " + doctorName);
        }
    }

    // Print all prescriptions for a specific patient
    public void printPrescriptionsByPatient(String patientName) {
        System.out.println("Prescriptions for Patient: " + patientName);
        boolean found = false;
        for (Prescription prescription : prescriptions) {
            if (prescription.getPatient().getName().equalsIgnoreCase(patientName)) {
                System.out.println(prescription);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No prescriptions found for " + patientName);
        }
    }

    // Restock medications
    public void restockMedication(String name, int amount) {
        for (Medication med : medications) {
            if (med.getName().equalsIgnoreCase(name)) {
                med.restock(amount);
                System.out.println("Restocked " + name + " with " + amount + " units.");
                return;
            }
        }
        System.out.println("Medication not found.");
    }
}
