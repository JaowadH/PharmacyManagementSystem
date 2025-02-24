import java.util.*;
import medTracker.Patient;
import medTracker.Doctor;
import medTracker.Medication;
import medTracker.Prescription;

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

    // Add a new patient to the system
    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
            System.out.println("Patient " + patient.getName() + " added successfully.");
        } else {
            System.out.println("Patient " + patient.getName() + " already exists in the system.");
        }
    }

    // Add a new doctor to the system
    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
            System.out.println("Doctor " + doctor.getName() + " added successfully.");
        } else {
            System.out.println("Doctor " + doctor.getName() + " already exists in the system.");
        }
    }

    // Add a new medication to the system
    public void addMedication(Medication medication) {
        if (!medications.contains(medication)) {
            medications.add(medication);
            System.out.println("Medication " + medication.getName() + " added successfully.");
        } else {
            System.out.println("Medication " + medication.getName() + " already exists in the system.");
        }
    }

    // Accept a prescription
    public void acceptPrescription(Prescription prescription) {
        if (prescription != null) {
            prescriptions.add(prescription);
            prescription.getPatient().addPrescription(prescription);
            System.out.println("Prescription added for Patient: " + prescription.getPatient().getName());
        } else {
            System.out.println("Error: Prescription is null.");
        }
    }

    // Generate system report
    public void generateReport() {
        System.out.println("\n--- Pharmacy Management System Report ---");

        System.out.println("\nPatients:");
        if (patients.isEmpty()) {
            System.out.println("No patients in the system.");
        } else {
            for (Patient p : patients) {
                System.out.println(p);
            }
        }

        System.out.println("\nDoctors:");
        if (doctors.isEmpty()) {
            System.out.println("No doctors in the system.");
        } else {
            for (Doctor d : doctors) {
                System.out.println(d);
            }
        }

        System.out.println("\nMedications:");
        if (medications.isEmpty()) {
            System.out.println("No medications in stock.");
        } else {
            for (Medication m : medications) {
                System.out.println(m);
            }
        }

        System.out.println("\nPrescriptions:");
        if (prescriptions.isEmpty()) {
            System.out.println("No prescriptions in the system.");
        } else {
            for (Prescription pr : prescriptions) {
                System.out.println(pr);
            }
        }
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
}
