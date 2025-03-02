package medTracker;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
/**



 * Represents a patient in the medication tracking system.


 * A patient has an ID, name, age, phone number, and lists of medications and prescriptions.


 */


public class Patient extends Person {
    private final List<Medication> medications;
    private final List<Prescription> prescriptions;
    /**



     * Constructs a new Patient with the given details.


     *


     * @param id          The unique identifier for the patient.


     * @param name        The name of the patient.


     * @param age         The age of the patient.


     * @param phoneNumber The phone number of the patient.


     */
    public Patient(int id, String name, int age, String phoneNumber) {
        super(id, name, age, phoneNumber);
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    public Patient(int id, String name, int age, String phoneNumber, int medications, int prescriptions) {
        super(id, name, age, phoneNumber);
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    /**



     * Adds a medication to the patient's medication list.


     *


     * @param medication The medication to be added.


     */


    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    /**



     * Adds a prescription to the patient's prescription list.


     *


     * @param prescription The prescription to be added.


     */
    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }
    /**



     * Retrieves the list of medications assigned to the patient.


     *


     * @return A list of medications.


     */
    public List<Medication> getMedications() {
        return medications;
    }
    /**



     * Retrieves the list of prescriptions assigned to the patient.


     *


     * @return A list of prescriptions.


     */
    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", getId());
        jsonObject.put("name", getName());
        jsonObject.put("age", getAge());
        jsonObject.put("phoneNumber", getPhoneNumber());
        jsonObject.put("medications", getMedications());
        jsonObject.put("prescriptions", getPrescriptions());
        return jsonObject;
    }

    public static Patient fromPatientJson(JSONObject jsonObject) {
        int id = getIntValue(jsonObject.get("id"));
        String name = (String) jsonObject.get("name");
        int age = getIntValue(jsonObject.get("age"));
        String phoneNumber = (String) jsonObject.get("phoneNumber");
        return new Patient(id
                , name
                , age
                , phoneNumber);
    }

    private static int getIntValue(Object value) {
        if (value instanceof Long) {
            return ((Long) value).intValue();
        }
        return (Integer) value;
    }
    @Override
    public String toString() {
        return String.format("Patient ID: %d%n " +
                        "Patient name: %s%n " +
                        "Patient age: %d%n " +
                        "Patient phone number: %s%n " +
                        "Patient medication: %d%n " +
                        "Patient prescription: %d%n "
        ,getId(), getName(), getAge(), getPhoneNumber(), medications.size(), prescriptions.size() );
    }
}
