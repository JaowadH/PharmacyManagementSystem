package medTracker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**



 * The {@code Prescription} class represents a medical prescription issued by a doctor to a patient.


 * It includes details about the prescribing doctor, the patient, the prescribed medication, and the expiration date.


 */

public class Prescription {
    private int prescriptionID;
    private Doctor doctor;
    private Patient patient;
    private Medication medication;
    private Date prescriptionExpiry;

    /**



     * Constructs a new Prescription with the specified details.


     * The expiration date is automatically set to one year from the current system date.


     *


     * @param prescriptionID     The unique identifier of the prescription.


     * @param doctor             The doctor issuing the prescription.


     * @param patient            The patient receiving the prescription.


     * @param medication         The medication prescribed.


     * @param prescriptionExpiry The expiration date of the prescription.


     */

    public Prescription(int prescriptionID, Doctor doctor, Patient patient, Medication medication,
                        Date prescriptionExpiry) {
        this.prescriptionID = prescriptionID;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.prescriptionExpiry = generatePrescriptionExpiry();
    }

    /**



     * Generates the expiration date for the prescription.


     * The default expiration is set to one year from the current system date.


     *


     * @return The calculated expiration date.


     */

    private Date generatePrescriptionExpiry() {
        Calendar calendar = Calendar.getInstance(); // Get current date
        calendar.add(Calendar.YEAR, 1); // Add 1 year
        return calendar.getTime(); // Return updated date
    }

    // getters and setters

    /**



     * Gets the unique ID of the prescription.


     *


     * @return The prescription ID.


     */

    public int getPrescriptionID() {
        return prescriptionID;
    }
    /**



     * Sets the unique ID of the prescription.


     *


     * @param prescriptionID The new prescription ID.


     */
    public void setPrescriptionID(int prescriptionID) {
        this.prescriptionID = prescriptionID;
    }
    /**



     * Gets the doctor who issued the prescription.


     *


     * @return The prescribing doctor.


     */


    public Doctor getDoctor() {
        return doctor;
    }
    /**



     * Sets the doctor who issued the prescription.


     *


     * @param doctor The prescribing doctor.


     */


    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    /**



     * Gets the patient who received the prescription.


     *


     * @return The patient.


     */


    public Patient getPatient() {
        return patient;
    }
    /**



     * Sets the patient who received the prescription.


     *


     * @param patient The new patient.


     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    /**



     * Gets the prescribed medication.


     *


     * @return The medication.


     */
    public Medication getMedication() {
        return medication;
    }
    /**



     * Sets the prescribed medication.


     *


     * @param medication The new medication.


     */
    public void setMedication(Medication medication) {
        this.medication = medication;
    }
    /**



     * Gets the expiration date of the prescription.


     *


     * @return The prescription's expiration date.


     */
    public Date getPrescriptionExpiry() {
        return prescriptionExpiry;
    }
    /**



     * Sets the expiration date of the prescription.


     *


     * @param prescriptionExpiry The new expiration date.


     */
    public void setPrescriptionExpiry(Date prescriptionExpiry) {
        this.prescriptionExpiry = prescriptionExpiry;
    }
    /**



     * Gets the expiration date of the prescription as a formatted string (yyyy-MM-dd).


     *


     * @return The formatted expiration date.


     */


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
