package src.main.java.medTracker;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {
    private final List<Medication> medications;
    private final List<Prescription> prescriptions;

    public Patient(int id, String name, int age, String phoneNumber) {
        super(id, name, age, phoneNumber);
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    // New constructor that accepts additional parameters
    public Patient(int id, String name, int age, String phoneNumber, int medications, int prescriptions) {
        super(id, name, age, phoneNumber);
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    // Add medication to patient's list
    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    // Add prescription to patient's list
    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    public List<Medication> getMedications() {
        return medications;
    }

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
