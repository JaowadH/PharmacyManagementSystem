import java.util.Date;

public class TestMedication {
    public static void main(String[] args) {
        // Create a Medication object
        Medication med1 = new Medication(1, "Ibuprofen", "200mg", 50, null);
        Medication med2 = new Medication(2, "Amoxicillin", "500mg", 30, null);

        // Display the details of each medication
        System.out.println("\nMedication 1:");
        System.out.println("ID: " + med1.getMedID());
        System.out.println("Name: " + med1.getMedName());
        System.out.println("Dosage: " + med1.getDose());
        System.out.println("Quantity: " + med1.getQuantity());
        System.out.println("Expiry Date: " + med1.getExpiryDate());
        System.out.println();

        System.out.println("\nMedication 2:");
        System.out.println("ID: " + med2.getMedID());
        System.out.println("Name: " + med2.getMedName());
        System.out.println("Dosage: " + med2.getDose());
        System.out.println("Quantity: " + med2.getQuantity());
        System.out.println("Expiry Date: " + med2.getExpiryDate());
        System.out.println();

        // edit details of med 1SS
        med1.setMedID(3);
        med1.setMedName("Adderall");
        med1.setDose("300mg");
        med1.setQuantity(25);
        med1.setExpiryDate(new Date());

        //print edited medication
        System.out.println("\nEdited Medication 1:");
        System.out.println("ID: " + med1.getMedID());
        System.out.println("Name: " + med1.getMedName());
        System.out.println("Dosage: " + med1.getDose());
        System.out.println("Quantity: " + med1.getQuantity());
        System.out.println("Expiry Date: " + med1.getExpiryDate());
        System.out.println();
    }
}
