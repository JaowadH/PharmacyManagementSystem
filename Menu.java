import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import medTracker.Doctor;
import medTracker.Patient;
import menuUtils.MenuUtils;
import medTracker.Medication;

public class Menu {
        // lets scanner take input
        private static final Scanner scanner = new Scanner(System.in);
        private static final ArrayList<Medication> medications = new ArrayList<>();
        private static final ArrayList<Patient> patients = new ArrayList<>();
        private static final ArrayList<Doctor> doctors = new ArrayList<>();
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
                    MenuUtils.addPatient(patients, scanner);
                    break;
                case 2:
                    System.out.print("Enter Doctors Name: ");

                    // add logic for function here from module packages
                    String doctorName = scanner.nextLine();
                    System.out.println("Adding Doctor: " + doctorName + "...");
                    break;
                case 3:
                    addMed();
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

    // setters for menu
    private static void addMed() {
        // adding med id
        System.out.print("Enter Medication ID: ");
        int medID = scanner.nextInt();
        scanner.nextLine(); // removes newLine for nextLine

        // adding med name
        System.out.print("Enter Medication Name: ");
        String medName = scanner.nextLine();

        // adding med dose
        System.out.print("Enter Dosage: ");
        String dose = scanner.nextLine();

        // adding quantity
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        // med object
        Medication newMed = new Medication(medID, medName, dose, quantity, new Date());
        medications.add(newMed);
        System.out.println("New Medication added: " + newMed);
    }

    // System report print
    private static void printSystemReport() {
        System.out.print("\n System Report \n");
        if (medications.isEmpty()) {
            System.out.println("No Medications in system yet.");
        } else {
            for (Medication med : medications) {
                System.out.println(med);
            }
        }
    }

    // checking expired meds
    private static void checkExpiredMeds() {
        Date currDate = new Date();

        System.out.println("\n Expired Medications \n");
        boolean hasExpired = false;
        for (Medication med : medications) {
            if (med.getExpiryDateObject().compareTo(currDate) < 0 ) {
                System.out.println("Expired: " + med);
                hasExpired = true;
            }
        }

        if (!hasExpired) {
            System.out.println("No Expired Medications yet.");
        }
    }
}

