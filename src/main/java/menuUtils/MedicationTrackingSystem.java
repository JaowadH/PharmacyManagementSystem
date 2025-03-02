package menuUtils;

import java.util.*;
import medTracker.*;

/**
 * The MedicationTrackingSystem class manages patients, doctors, medications,
 * and prescriptions within a pharmacy management system.
 */

public class MedicationTrackingSystem {
    private final List<Patient> patients;
    private final List<Doctor> doctors;
    private final List<Medication> medications;
    private final List<Prescription> prescriptions;

    /**
     * Constructs a MedicationTrackingSystem with empty lists for patients,
     * doctors, medications, and prescriptions.
     */

    public MedicationTrackingSystem() {
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    /**
     * Adds a new patient to the system.
     *
     * @param newPatient The patient to be added.
     */

    public void addPatient(Patient newPatient) {
        if (!patients.contains(newPatient)) {
            patients.add(newPatient);
            System.out.println("Patient added successfully.");
        } else {
            System.out.println("Patient already exists.");
        }
    }

    /**
     * Returns the list of patients in the system.
     *
     * @return A list of patients.
     */

    public List<Patient> getPatients() {
        return patients;
    }

    /**
     * Adds a new doctor to the system.
     *
     * @param newDoctor The doctor to be added.
     */

    public void addDoctor(Doctor newDoctor) {
        if (!doctors.contains(newDoctor)) {
            doctors.add(newDoctor);
            System.out.println("Doctor added successfully.");
        } else {
            System.out.println("Doctor already exists.");
        }
    }

    /**
     * Adds a new medication to the system.
     *
     * @param newMed The medication to be added.
     */

    public void addMedication(Medication newMed) {
        if (!medications.contains(newMed)) {
            medications.add(newMed);
            System.out.println("Medication added successfully.");
        } else {
            System.out.println("Medication already exists.");
        }
    }

    /**
     * Finds a patient by name.
     *
     * @param name The name of the patient to find.
     * @return The patient object if found, otherwise null.
     */

    private Patient findPatient(String name) {
        for (Patient p : patients) {
            if (p.getName().equalsIgnoreCase(name)) return p;
        }
        return null;
    }

    /**
     * Finds a doctor by name.
     *
     * @param name The name of the doctor to find.
     * @return The doctor object if found, otherwise null.
     */

    private Doctor findDoctor(String name) {
        for (Doctor d : doctors) {
            if (d.getName().equalsIgnoreCase(name)) return d;
        }
        return null;
    }

    /**
     * Finds a medication by name.
     *
     * @param name The name of the medication to find.
     * @return The medication object if found, otherwise null.
     */

    private Medication findMedication(String name) {
        for (Medication m : medications) {
            if (m.getMedName().equalsIgnoreCase(name)) return m;
        }
        return null;
    }

    /**
     * Generates a report of the current state of the system, including the
     * number of patients, doctors, medications, and prescriptions.
     */

    public void generateReport() {
        System.out.println("\n--- Pharmacy Management System Report ---");
        System.out.println("Patients: " + patients.size());
        System.out.println("Doctors: " + doctors.size());
        System.out.println("Medications: " + medications.size());
        System.out.println("Prescriptions: " + prescriptions.size());
    }

    /**
     * Checks for expired medications in the system and prints their names.
     */

    public void checkExpiredMedications() {
        System.out.println("Checking for expired medications...");
        Date currDate = new Date();
        boolean hasExpired = false;

        for (Medication med : medications) {
            if (med.getExpiryDate().compareTo(currDate) < 0) {
                System.out.println("Expired: " + med.getMedName());
                hasExpired = true;
            }
        }
        if (!hasExpired) {
            System.out.println("No expired medications.");
        }
    }
}
