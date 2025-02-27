package src.main.java.menuUtils;

import java.util.*;
import src.main.java.medTracker.*;

import static src.main.java.menuUtils.MenuUtils.readDoctorsFromJson;
import static src.main.java.menuUtils.MenuUtils.readPatientsFromJson;

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

    public void addMedication(Medication newMed) {
        if (!medications.contains(newMed)) {
            medications.add(newMed);
            System.out.println("Medication added successfully.");
        } else {
            System.out.println("Medication already exists.");
        }
    }

    public void addPatientToDoctor(String patientName, String doctorName) {
        Patient patient = findPatient(patientName);
        Doctor doctor = findDoctor(doctorName);
        if (patient != null && doctor != null) {
            doctor.addPatient(patient);
            System.out.println("Patient added to doctor's list.");
        } else {
            System.out.println("Doctor or patient not found.");
        }
    }

    public void acceptPrescription(int prescriptionId, Doctor doctor, Patient patient, Medication medication, Date issueDate) {
        if (patient != null && doctor != null && medication != null) {
            Prescription prescription = new Prescription(prescriptionId, doctor, patient, medication, issueDate);
            prescriptions.add(prescription);
            System.out.println("Prescription added successfully for " + patient.getName() + ".");
        } else {
            System.out.println("Invalid prescription data. Please check patient, doctor, or medication details.");
        }
    }

    public void editMedication(String oldName, String newName) {
        Medication med = findMedication(oldName);
        if (med != null) {
            med.setMedName(newName);
            System.out.println("Medication updated.");
        } else {
            System.out.println("Medication not found.");
        }
    }

    public void deletePatient(String name) {
        patients.removeIf(p -> p.getName().equalsIgnoreCase(name));
        System.out.println("Patient deleted successfully.");
    }

    public void deleteDoctor(String name) {
        doctors.removeIf(d -> d.getName().equalsIgnoreCase(name));
        System.out.println("Doctor deleted successfully.");
    }

    public void deleteMedication(String name) {
        medications.removeIf(m -> m.getMedName().equalsIgnoreCase(name));
        System.out.println("Medication deleted successfully.");
    }

    public void printDoctorPrescriptions(String doctorName) {
        Doctor doctor = findDoctor(doctorName);
        if (doctor != null) {
            System.out.println("Prescriptions issued by Dr. " + doctorName + ":");
            for (Prescription p : prescriptions) {
                if (p.getDoctor().equals(doctor)) {
                    System.out.println(p);
                }
            }
        } else {
            System.out.println("Doctor not found.");
        }
    }
    public void printPatientPrescriptions(String patientName) {
        Patient patient = findPatient(patientName);
        if (patient != null) {
            System.out.println("Prescriptions for " + patientName + ":");
            List<Prescription> patientPrescriptions = patient.getPrescriptions();
            if (patientPrescriptions.isEmpty()) {
                System.out.println("No prescriptions found for this patient.");
            } else {
                for (Prescription p : patientPrescriptions) {
                    System.out.println(p);
                }
            }
        } else {
            System.out.println("Patient not found.");
        }
    }


    public void restockMedication(String medName) {
        Scanner scanner = new Scanner(System.in);
        Medication med = findMedication(medName);
        if (med != null) {
            System.out.print("Enter quantity to restock: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            med.restock(quantity);
            System.out.println("Medication restocked by " + quantity + " units.");
        } else {
            System.out.println("Medication not found.");
        }
    }

    public void generateReport() {
        String patientPath = "src/main/java/medTracker/patients.json";
        String DoctorPath = "src/main/java/medTracker/doctors.json";
        List<Patient> loadedPatients = readPatientsFromJson(patientPath);
        List<Doctor> loadedDoctors = readDoctorsFromJson(DoctorPath);
        for (Patient patient : loadedPatients) {
            System.out.println(patient);
        }
        for (Doctor doctor : loadedDoctors) {
            System.out.println(doctor);
        }
    }

    public void checkExpiredMedications() {
        System.out.println("Checking for expired medications...");
        Date currDate = new Date();
        boolean foundExpired = false;
        for (Medication med : medications) {
            if (med.getExpiryDate().compareTo(currDate) < 0) {
                System.out.println("Expired: " + med.getMedName());
                foundExpired = true;
            }
        }
        if (!foundExpired) {
            System.out.println("No expired medications found.");
        }
    }

    public Patient findPatient(String name) {
        return patients.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public Doctor findDoctor(String name) {
        return doctors.stream().filter(d -> d.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public Medication findMedication(String name) {
        return medications.stream().filter(m -> m.getMedName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}
