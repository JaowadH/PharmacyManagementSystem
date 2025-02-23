package medTracker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Medication {
    private int medID;
    private String medName;
    private String dose;
    private int quantity;
    private Date manufactureDate;
    private Date expiryDate;

    // Constructor
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

    // Getters and setters
    public int getMedID() {
        return medID;
    }

    public void setMedID(int medID) {
        this.medID = medID;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    // Format dates for display
    public String getManufactureDateString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(manufactureDate);
    }

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