package menuUtils;

import java.util.InputMismatchException;
import java.util.Scanner;
import medTracker.*;

public class MenuUtils {

    // ✅ Add a patient
    public static void addPatient(MedicationTrackingSystem MTS, Scanner scanner) {
        int patientID = getValidInt(scanner, "Enter Patient ID: ");
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Patient Name: ");
        String patientName = scanner.nextLine();

        int patientAge = getValidInt(scanner, "Enter Patient Age: ");
        scanner.nextLine();

        System.out.print("Enter Patient Phone Number: ");
        String patientPhoneNumber = scanner.nextLine();

        Patient newPatient = new Patient(patientID, patientName, patientAge, patientPhoneNumber);
        MTS.addPatient(newPatient);
    }

    // ✅ Add a doctor
    public static void addDoctor(MedicationTrackingSystem MTS, Scanner scanner) {
        int doctorID = getValidInt(scanner, "Enter Doctor's ID: ");
        scanner.nextLine();

        System.out.print("Enter Doctor's Name: ");
        String doctorName = scanner.nextLine();

        int doctorAge = getValidInt(scanner, "Enter Doctor Age: ");
        scanner.nextLine();

        System.out.print("Enter Doctor's Phone Number: ");
        String doctorPhoneNumber = scanner.nextLine();

        System.out.print("Enter Doctor's Specialization: ");
        String specialization = scanner.nextLine();

        Doctor newDoctor = new Doctor(doctorID, doctorName, doctorAge, doctorPhoneNumber, specialization);
        MTS.addDoctor(newDoctor);
    }

    // ✅ Add a medication
    public static void addMed(MedicationTrackingSystem MTS, Scanner scanner) {
        int medID = getValidInt(scanner, "Enter Medication ID: ");
        scanner.nextLine();

        System.out.print("Enter Medication Name: ");
        String medName = scanner.nextLine();

        System.out.print("Enter Medication Dosage (mg): ");
        String dose = scanner.nextLine();

        int quantity = getValidInt(scanner, "Enter Medication Quantity: ");
        scanner.nextLine();

        Medication newMed = new Medication(medID, medName, dose, quantity);
        MTS.addMedication(newMed);
    }

    // ✅ Print System Report (Fixed)
    public static void printSystemReport(MedicationTrackingSystem MTS) {
        MTS.generateReport();
    }

    // ✅ Check expired meds (Fixed)
    public static void checkExpiredMeds(MedicationTrackingSystem MTS) {
        MTS.checkExpiredMedications();
    }

    // ✅ Process a new prescription (Placeholder for now)
    public static void processPrescription(MedicationTrackingSystem MTS, Scanner scanner) {
        System.out.println("Processing prescription... (Implementation needed)");
    }

    // ✅ Print all scripts for a specified doctor (Placeholder)
    public static void printDoctorPrescriptions(MedicationTrackingSystem MTS, Scanner scanner) {
        System.out.println("Printing doctor's prescriptions... (Implementation needed)");
    }

    // ✅ Restock pharmacy (Placeholder)
    public static void restockPharmacy(MedicationTrackingSystem MTS) {
        System.out.println("Restocking pharmacy... (Implementation needed)");
    }

    // ✅ Print all scripts for a specified patient (Placeholder)
    public static void printPatientPrescriptions(MedicationTrackingSystem MTS, Scanner scanner) {
        System.out.println("Printing patient's prescriptions... (Implementation needed)");
    }

    // ✅ Utility function to get valid integer input
    private static int getValidInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("ERROR: Invalid input. Please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
        }
    }
}
