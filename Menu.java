import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import medTracker.Doctor;
import medTracker.Patient;
import menuUtils.MedicationTrackingSystem;
import menuUtils.MenuUtils;
import medTracker.Medication;

public class Menu {
        // lets scanner take input
        private static final Scanner scanner = new Scanner(System.in);
        private static final List<Medication> medications = new ArrayList<>();
        private static final MedicationTrackingSystem MTS = new MedicationTrackingSystem();
    public static void main(String[] args) {
        // sets attributes for menu
        int choice;

        do {
            // build menu in sout
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
            // input must be integer

            while (!scanner.hasNextInt()) {
                System.out.println("ERROR: Invalid input, Please enter a number between 1 and 10.");
                System.out.print("Enter your Choice: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();


            // switch case for handling choice
            switch ( choice ) {
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
                    MenuUtils.printSystemReport(medications);
                    break;
                case 5:
                    MenuUtils.checkExpiredMeds(medications);
                    break;
                case 6:
                    System.out.print("Enter Patients name for prescription: ");
                    String prescriptPatient = scanner.nextLine();
                    System.out.print("Enter Medication Name: ");
                    String prescriptMed = scanner.nextLine();
                    System.out.println("Processing prescription for " + prescriptPatient + ", With Drug: " + prescriptMed + "...");
                    // add logic for function here from module packages
                    break;
                case 7:
                    System.out.print("Enter medTracker.Doctor's name to view prescriptions: ");
                    String scriptDoc = scanner.nextLine();
                    System.out.println("Fetching prescriptions for Dr. " + scriptDoc + "...");
                    // add logic for function here from module packages
                    break;
                case 8:
                    System.out.println("Restocking the drugs in Pharmacy...");
                    // add logic for function here from module packages
                    break;
                case 9:
                    System.out.print("Enter patients name to view prescriptions: ");
                    String scriptPatient = scanner.nextLine();
                    System.out.println("Fetching prescriptions for " + scriptPatient + "...");
                    // add logic for function here from module packages
                    break;
                case 10:
                    System.out.println("Exiting system, Have a good day!");
                    // add logic for function here from module packages
                    break;

                    // remove default for prod
                default:
                    System.out.println("ERROR: Invalid input, Please enter a number between 1 and 10.");
            }
        } while ( choice != 10);
        scanner.close();
    }
}

