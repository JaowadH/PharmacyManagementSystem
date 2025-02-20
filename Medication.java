import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Medication {
    private int medID;
    private String medName;
    private String dose;
    private int quantity;
    private Date expiryDate;

    //constructor
    public Medication(int medID, String medName, String dose, int quantity, Date expiryDate) {
        this.medID = medID;
        this.medName = medName;
        this.dose = dose;
        this.quantity = quantity;
        this.expiryDate = generateExpiryDate();
    }

    private Date generateExpiryDate() {
        Calendar calendar = Calendar.getInstance(); // Get current date
        calendar.add(Calendar.YEAR, 2); // Add 2 years
        return calendar.getTime(); // Return updated date
    }

    // getters and setters

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

    public String getExpiryDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(expiryDate);
    }
// had to pull a object back, cannot compare object to string. Upper line needs fixing as well.
    public Date getExpiryDateObject() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    // methods


    // to string method
    @Override
    public String toString() {
        return "Medication{" +
                "medID=" + medID +
                ", medName='" + medName + '\'' +
                ", dose='" + dose + '\'' +
                ", quantity=" + quantity +
                ", expiryDate=" + expiryDate +
                '}';
    }
}