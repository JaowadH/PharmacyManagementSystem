package menuUtils;

import java.util.*;
import medTracker.*;

import javax.print.Doc;

public class MedicationTrackingSystem {
    private final List<Patient> patients;
    private final List<Doctor> doctors;
    private final List<Medication> medications;
    private final List<Prescription> prescriptions;

    public MedicationTrackingSystem() {
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    public void addPatient(Patient newPatient) {
        if (!patients.contains(newPatient)) {
            patients.add(newPatient);
            System.out.println("Patient added successfully.");
        } else {
            System.out.println("Patient already exists.");
        }
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void addDoctor(Doctor newDoctor) {
        if (!doctors.contains(newDoctor)) {
            doctors.add(newDoctor);
            System.out.println("Doctor added successfully.");
        } else {
            System.out.println("Doctor already exists.");
        }
    }

    public void addMedication(Medication newMed) {
        if (!medications.contains(newMed)) {
            medications.add(newMed);
            System.out.println("Medication added successfully.");
        } else {
            System.out.println("Medication already exists.");
        }
    }
    

    private Patient findPatient(String name) {
        for (Patient p : patients) {
            if (p.getName().equalsIgnoreCase(name)) return p;
        }
        return null;
    }

    private Doctor findDoctor(String name) {
        for (Doctor d : doctors) {
            if (d.getName().equalsIgnoreCase(name)) return d;
        }
        return null;
    }

    private Medication findMedication(String name) {
        for (Medication m : medications) {
            if (m.getMedName().equalsIgnoreCase(name)) return m;
        }
        return null;
    }


    public void generateReport() {
        System.out.println("\n--- Pharmacy Management System Report ---");
        System.out.println("Patients: " + patients.size());
        System.out.println("Doctors: " + doctors.size());
        System.out.println("Medications: " + medications.size());
        System.out.println("Prescriptions: " + prescriptions.size());
    }

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
