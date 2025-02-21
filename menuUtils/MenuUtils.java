package menuUtils;


import java.util.List;
import java.util.Scanner;
import java.util.Date;
import medTracker.*;

public class MenuUtils {
    public static void addMed(List<Medication> medications, Scanner scanner) {
        // adding med id
        System.out.print("Enter medTracker.Medication ID: ");
        int medID = scanner.nextInt();
        scanner.nextLine(); // removes newLine for nextLine

        // adding med name
        System.out.print("Enter medTracker.Medication Name: ");
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
        System.out.println("New medTracker.Medication added: " + newMed);
    }
}
