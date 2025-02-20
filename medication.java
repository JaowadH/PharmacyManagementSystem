import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Medication {
    private int medID;
    private String medName;
    private String dose;
    private int quantity;
    private Date expiryDate;

    // Constructor
    public Medication(int medID, String medName, String dose, int quantity, Date expiryDate) {
        this.medID = medID;
        this.medName = medName;
        this.dose = dose;
        this.quantity = quantity;
        this.expiryDate = generateExpiryDate();
    }

    // Generates an expiry date 2 years from today
    private Date generateExpiryDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 2);
        return calendar.getTime();
    }

    // Getters and Setters
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

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    // Returns expiry date as a formatted string (YYYY-MM-DD)
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
                ", expiryDate=" + getExpiryDateString() +
                '}';
    }
}
