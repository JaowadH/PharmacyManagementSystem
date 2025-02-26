import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import medTracker.Doctor;
import medTracker.Patient;
import medTracker.Medication;
import menuUtils.MedicationTrackingSystem;
import menuUtils.MenuUtils;

public class Menu {
    // Lets scanner take input
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Medication> medications = new ArrayList<>();
    private static final MedicationTrackingSystem MTS = new MedicationTrackingSystem();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\nWelcome to the Med Tracker");
            System.out.println("What would you like to do?");
            System.out.println("1. Add a New Patient");
            System.out.println("2. Add a New Doctor");
            System.out.println("3. Add a Medication to the Pharmacy");
            System.out.println("4. Print System Report");
            System.out.println("5. Check if Meds are Expired");
            System.out.println("6. Process a New Prescription");
            System.out.println("7. Print all Scripts for Specified Doctor");
            System.out.println("8. Restock the drugs in the Pharmacy");
            System.out.println("9. Print all Scripts for specified Patient");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("ERROR: Invalid input, Please enter a number between 1 and 10.");
                System.out.print("Enter your Choice: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    MenuUtils.addPatient(MTS, scanner);
                    break;
                case 2:
                    MenuUtils.addDoctor(MTS, scanner);
                    break;
                case 3:
                    MenuUtils.addMed(MTS, scanner);
                    break;
                case 4:
                    MTS.generateReport();
                    break;
                case 5:
                    MTS.checkExpiredMedications();
                    break;
                case 6:
                    System.out.print("Enter Patient's name for prescription: ");
                    String prescriptPatient = scanner.nextLine();
                    System.out.print("Enter Doctor's name issuing the prescription: ");
                    String prescriptDoctor = scanner.nextLine();
                    System.out.print("Enter Medication Name: ");
                    String prescriptMed = scanner.nextLine();

                    Patient patient = MTS.findPatient(prescriptPatient);
                    Doctor doctor = MTS.findDoctor(prescriptDoctor);
                    Medication medication = MTS.findMedication(prescriptMed);

                    if (patient != null && doctor != null && medication != null) {
                        System.out.print("Enter Dosage: ");
                        int dosage = scanner.nextInt();
                        System.out.print("Enter Duration (days): ");
                        int duration = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        MTS.acceptPrescription(patient.getId(), doctor, patient, medication, new java.util.Date());
                        System.out.println("Prescription added successfully.");
                    } else {
                        System.out.println("Invalid input. Please check if the patient, doctor, or medication exists.");
                    }
                    break;
                case 7:
                    System.out.print("Enter Doctor's name to view prescriptions: ");
                    String scriptDoc = scanner.nextLine();
                    MTS.printDoctorPrescriptions(scriptDoc);
                    break;
                case 8:
                    System.out.print("Enter Medication Name to restock: ");
                    String restockMed = scanner.nextLine();
                    System.out.print("Enter quantity to restock: ");

                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a valid number.");
                        scanner.next();
                    }
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    MTS.restockMedication(restockMed);
                    break;
                case 9:
                    System.out.print("Enter Patient's name to view prescriptions: ");
                    String scriptPatient = scanner.nextLine();
                    MTS.printPatientPrescriptions(scriptPatient);
                    break;
                case 10:
                    System.out.println("Exiting system, Have a good day!");
                    break;
                default:
                    System.out.println("ERROR: Invalid input, Please enter a number between 1 and 10.");
            }
        } while (choice != 10);

        scanner.close();
    }
}
