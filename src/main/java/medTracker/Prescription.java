package src.main.java.medTracker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Prescription {
    private int prescriptionID;
    private Doctor doctor;
    private Patient patient;
    private Medication medication;
    private Date prescriptionExpiry;

    // constructor
    public Prescription(int prescriptionID, Doctor doctor, Patient patient, Medication medication, Date prescriptionExpiry) {
        this.prescriptionID = prescriptionID;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.prescriptionExpiry = generatePrescriptionExpiry();
    }

    // generate prescription expiry (default is 1 year from date issued(date issued is current system date))
    private Date generatePrescriptionExpiry() {
        Calendar calendar = Calendar.getInstance(); // Get current date
        calendar.add(Calendar.YEAR, 1); // Add 1 year
        return calendar.getTime(); // Return updated date
    }

    // getters and setters
    public int getPrescriptionID() {
        return prescriptionID;
    }

    public void setPrescriptionID(int prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public Date getPrescriptionExpiry() {
        return prescriptionExpiry;
    }

    public void setPrescriptionExpiry(Date prescriptionExpiry) {
        this.prescriptionExpiry = prescriptionExpiry;
    }

    public String getPrescriptionExpiryString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(prescriptionExpiry);
    }

    // to string
    @Override
    public String toString() {
        return "\nPrescription" +
                "\nID: " + prescriptionID +
                "\ndoctor: " + doctor.getName() +
                "\npatient: " + patient.getName() +
                "\nmedication: " + medication.getMedName() +
                "\nprescriptionExpiry: " + getPrescriptionExpiry() +
                "\n";
    }
}
