package medTracker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
/**



 * Represents a medication in the medical tracking system.


 */
public class Medication {
    private int medID;
    private String medName;
    private String dose;
    private int quantity;
    private final Date manufactureDate;
    private final Date expiryDate;

    /**
     * Constructs a new Medication with the specified details.
     *
     * @param medID The unique identifier of the medication.
     * @param medName The name of the medication.
     * @param dose The dosage information of the medication.
     * @param quantity The quantity available.
     */

    public Medication(int medID, String medName, String dose, int quantity) {
        this.medID = medID;
        this.medName = medName;
        this.dose = dose;
        this.quantity = quantity;
        this.manufactureDate = generateManufactureDate();
        this.expiryDate = generateExpiryDate();
    }

    // Generate a manufacture date within the last 2 years
    private Date generateManufactureDate() {
        Random random = new Random();
        Calendar calendar = Calendar.getInstance();
        
        // Subtract up to 730 days (2 years)
        int daysToSubtract = random.nextInt(731); // 0 to 730 days
        calendar.add(Calendar.DAY_OF_YEAR, -daysToSubtract);
        
        return calendar.getTime();
    }

    // Generate expiry date exactly 2 years from manufacture date
    private Date generateExpiryDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(manufactureDate); // Set to manufacture date
        calendar.add(Calendar.YEAR, 2); // Add 2 years
        return calendar.getTime();
    }

    // Getters and Setters

    /**
     * Gets the medication ID.
     *
     * @return The medication ID.
     */

    public int getMedID() {
        return medID;
    }

    /**
     * Sets the medication ID.
     *
     * @param medID The new medication ID.
     */

    public void setMedID(int medID) {
        this.medID = medID;
    }

    /**
     * Gets the name of the medication.
     *
     * @return The medication name.
     */

    public String getMedName() {
        return medName;
    }

    /**
     * Sets the name of the medication.
     *
     * @param medName The new medication name.
     */

    public void setMedName(String medName) {
        this.medName = medName;
    }

    /**
     * Gets the dosage of the medication
     *
     * @return The Medication dose.
     */

    public String getDose() {
        return dose;
    }

    /**
     * Sets the Medication dosage.
     *
     * @param dose The Medication dosage.
     */
    public void setDose(String dose) {
        this.dose = dose;
    }

    /**
     *  Gets the Quantity of Medication.
     *
     * @return Quantity of Medication.
     */

    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets Quantity of Medication.
     *
     * @param quantity Quantity of Medication.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets Dates for Manufacturer
     *
     * @return Manufacture date
     */
    public Date getManufactureDate() {
        return manufactureDate;
    }

    /**
     * Gets expiry date.
     *
     * @return The expiry date.
     */
    public Date getExpiryDate() {
        return expiryDate;
    }

    // Format dates for display

    /**
     * Gets the manufacture date and displays it as a string
     *
     * @return The Manufacture date as string
     */
    public String getManufactureDateString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(manufactureDate);
    }

    /**
     * Gets expiry date and displays as string.
     *
     * @return Expiry date as string.
     */

    public String getExpiryDateString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(expiryDate);
    }

    // toString method
    @Override
    public String toString() {
        return "Medication{" +
                "medID=" + medID +
                ", medName='" + medName + '\'' +
                ", dose='" + dose + '\'' +
                ", quantity=" + quantity +
                ", manufactureDate=" + getManufactureDateString() +
                ", expiryDate=" + getExpiryDateString() +
                '}';
    }
}
