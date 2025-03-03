import java.util.Scanner;
import menuUtils.DatabaseManager;
import menuUtils.MenuUtils;
import menuUtils.MedicationTrackingSystem;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
    private static final MedicationTrackingSystem MTS = new MedicationTrackingSystem();

    public static void main(String[] args) {
        DatabaseManager.initializeDatabase(); // Ensures database is set up before usage

        int choice;
        do {
            System.out.println("\nWelcome to the Med Tracker");
            System.out.println("1. Add a New Patient");
            System.out.println("2. Add a New Doctor");
            System.out.println("3. Add a Medication to the Pharmacy");
            System.out.println("4. Print System Report");
            System.out.println("5. Check if Meds are Expired");
            System.out.println("6. Process a New Prescription");
            System.out.println("7. Print all Scripts for Specified Doctor");
            System.out.println("8. Restock the drugs in the Pharmacy");
            System.out.println("9. Print all Scripts for Specified Patient");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("ERROR: Invalid input, Please enter a number between 1 and 10.");
                System.out.print("Enter your Choice: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> MenuUtils.addPatient(MTS, scanner);
                case 2 -> MenuUtils.addDoctor(MTS, scanner);
                case 3 -> MenuUtils.addMed(MTS, scanner);  // ✅ Fixed missing method reference
                case 4 -> MenuUtils.printSystemReport(MTS);
                case 5 -> MenuUtils.checkExpiredMeds(MTS);
                case 6 -> MenuUtils.processPrescription(MTS, scanner);
                case 7 -> MenuUtils.printDoctorPrescriptions(MTS, scanner);
                case 8 -> MenuUtils.restockPharmacy(MTS);
                case 9 -> MenuUtils.printPatientPrescriptions(MTS, scanner);
                case 10 -> System.out.println("Exiting system, Have a good day!");
                default -> System.out.println("ERROR: Invalid input, Please enter a number between 1 and 10.");
            }
        } while (choice != 10);
        scanner.close();
    }
}
