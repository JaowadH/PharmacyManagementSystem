import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.main.java.medTracker.*;
import src.main.java.menuUtils.*;

public class Menu {
    // Lets scanner take input
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Medication> medications = new ArrayList<>();
    private static final MedicationTrackingSystem MTS = new MedicationTrackingSystem();
    private static final List<Patient> patients = new ArrayList<>();

    public static void main(String[] args) {

        String filePath = "src/main/java/medTracker/patients.json";
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
                    patients.add(new Patient(1, "John Doe", 30, "123-456-7890"));
                    patients.add(new Patient(2, "Jane Smith", 25, "987-654-3210"));
                    MenuUtils.addPatient(MTS, scanner);
                    MenuUtils.savePatientToJson(patients, filePath);
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
                    MenuUtils.handlePrescription(MTS, scanner);
                    break;
                case 7:
                    MenuUtils.docScript(MTS, scanner);
                    break;
                case 8:
                    MenuUtils.restockMedication(MTS, scanner);
                    break;
                case 9:
                    MenuUtils.printPatientPrescriptions(MTS, scanner);
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
