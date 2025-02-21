import java.util.Date;

public class TestPrescription {
    public static void main(String[] args) {
        // Create a sample doctor
        Doctor doctor = new Doctor(1, "Dr. Smith", 45, "123-456-7890", "Cardiology");

        // Create a sample patient
        Patient patient = new Patient(2, "John Doe", 30, "987-654-3210");

        // Create a sample medication
        Medication medication = new Medication(101, "Amoxicillin", "500mg", 20, new Date());

        // Create a prescription
        Prescription prescription = new Prescription(1001, doctor, patient, medication, new Date());

        // Print details
        System.out.println("Prescription Details:");
        System.out.println(prescription);

        // Verify expiry date format
        System.out.println("Formatted Expiry Date: " + prescription.getPrescriptionExpiryString());
        System.out.println();
    }
}
