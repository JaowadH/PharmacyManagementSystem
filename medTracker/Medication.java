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
    private final Date manufactureDate;
    private final Date expiryDate;

    // Constructor
    public Medication(int medID, String medName, String dose, int quantity) {
        this.medID = medID;
        this.medName = medName;
        this.dose = dose;
        this.quantity = quantity;
        this.manufactureDate = generateManufactureDate();
        this.expiryDate = generateExpiryDate(); // ✅ Auto-generates expiry date
    }

    // Generate a manufacture date within the last 2 years
    private Date generateManufactureDate() {
        Random random = new Random();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -random.nextInt(731)); // Random date within last 2 years
        return calendar.getTime();
    }

    // Generate expiry date (2 years after manufacture date)
    private Date generateExpiryDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(manufactureDate);
        calendar.add(Calendar.YEAR, 2);
        return calendar.getTime();
    }

    // Getters
    public int getMedID() { return medID; }
    public String getMedName() { return medName; }
    public String getDose() { return dose; }
    public int getQuantity() { return quantity; }
    public Date getManufactureDate() { return manufactureDate; }
    public Date getExpiryDate() { return expiryDate; }

    public String getExpiryDateString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(expiryDate);
    }

    @Override
    public String toString() {
        return "Medication{" +
                "medID=" + medID +
                ", medName='" + medName + '\'' +
                ", dose='" + dose + '\'' +
                ", quantity=" + quantity +
                ", expiryDate=" + getExpiryDateString() +
                '}';
    }
}
