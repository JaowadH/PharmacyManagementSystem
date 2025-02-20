import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        // lets scanner take input
        Scanner scanner = new Scanner(System.in);
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
                    System.out.print("Enter Patient Name: ");

                    // add logic for function here from module packages
                    String patientName = scanner.nextLine();
                    System.out.println("Adding Patient: " + patientName + "...");
                    break;
                case 2:
                    System.out.print("Enter Dcotors Name: ");

                    // add logic for function here from module packages
                    String doctorName = scanner.nextLine();
                    System.out.println("Adding Doctor: " + doctorName + "...");
                    break;
                case 3:
                    System.out.print("Enter Medication Name: ");

                    // add logic for function here from module packages
                    String medName = scanner.nextLine();
                    System.out.println("Adding Medication: " + medName + "...");
                    break;
                case 4:
                    System.out.println("Generating systems report...");
                    // add logic for function here from module packages
                    break;
                case 5:
                    System.out.println("Checking expired medications...");
                    // add logic for function here from module packages
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
                    System.out.print("Enter Doctor's name to view prescriptions: ");
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
