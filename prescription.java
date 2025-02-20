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
        this.prescriptionExpiry = prescriptionExpiry;
    }
}
