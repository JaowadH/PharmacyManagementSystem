package menuUtils;


import java.util.List;
import java.util.Scanner;
import java.util.Date;
import medTracker.*;

public class MenuUtils {
    public static void addMed(List<Medication> medications, Scanner scanner) {
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
        // checking expired meds
        public static void checkExpiredMeds( List<Medication> medications ) {
            Date currDate = new Date();

            System.out.println("\n Expired Medications \n");
            boolean hasExpired = false;
            for (Medication med : medications) {
                if (med.getExpiryDate().compareTo(currDate) < 0 ) {
                    System.out.println("Expired: " + med);
                    hasExpired = true;
                }
            }

            if (!hasExpired) {
                System.out.println("No Expired Medications yet.");
            }
        }
    // System report print
    public static void printSystemReport(List<Medication> medications) {
        System.out.print("\n System Report \n");
        if (medications.isEmpty()) {
            System.out.println("No Medications in system yet.");
        } else {
            for (Medication med : medications) {
                System.out.println(med);
            }
        }
    }

    public static void addPatient(List<Patient> patients, Scanner scanner) {
        System.out.print("Enter Patient ID: ");
        int patientID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Patient Name: ");
        String patientName = scanner.nextLine();

        System.out.print("Enter Patient Age: ");
        int patientAge = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Patient Phone number: ");
        String patientPhoneNumber = scanner.nextLine();

        // patient object
        Patient newPatient = new Patient(patientID, patientName, patientAge, patientPhoneNumber);
        System.out.println("New Patient added: " + newPatient);
    }


    public static void addDoctor(List<Doctor> doctors, Scanner scanner) {
        System.out.print("Enter Doctors ID: ");
        int doctorID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Doctors Name: ");
        String doctorName = scanner.nextLine();

        System.out.print("Enter Doctors Age: ");
        int doctorAge = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Doctors Phone Number: ");
        String doctorPhoneNumber = scanner.nextLine();

        System.out.print("Enter Doctors Specialization: ");
        String Spec = scanner.nextLine();


        Doctor newDoctor = new Doctor(doctorID, doctorName, doctorAge, doctorPhoneNumber, Spec);
    }
}
