import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import medTracker.*;
import menuUtils.*;

public class Menu {
    // Lets scanner take input
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Medication> medications = new ArrayList<>();
    private static final MedicationTrackingSystem MTS = new MedicationTrackingSystem();
    private static final List<Patient> patients = new ArrayList<>();
    private static final List<Doctor> doctors = new ArrayList<>();
    public static void main(String[] args) {
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
            scanner.nextLine(); // Consume newline character


            // switch case for handling choice
            switch ( choice ) {
                case 1:
                    String patientPath = "src/main/java/medTracker/patients.json";
                    Patient newPatient = menuUtils.MenuUtils.addPatient(scanner);
                    patients.add(newPatient);
                    MenuUtils.savePatientToJson(patients, patientPath);
                    break;
                case 2:
                    String doctorPath = "src/main/java/medTracker/doctors.json";
                    Doctor newDoctor = menuUtils.MenuUtils.addDoctor(scanner);
                    doctors.add(newDoctor);
                    MenuUtils.saveDoctorToJson(doctors, doctorPath);
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
                    // logic not added
                    break;
                case 7:
                    // logic not added
                    break;
                case 8:
                    // logic not added
                    break;
                case 9:
                    menuUtils.MedicationTrackingSystem.findMedication(scanner);
                    break;
                case 10:
                    System.out.println("Exiting system, Have a good day!");
                    // add logic for function here from module packages
                    break;

                    // remove default for prod
                default:
                    System.out.println("ERROR: Invalid input, Please enter a number between 1 and 10.");
            }
        } while (choice != 10);

        scanner.close();
    }
}

