package src.main.java.medTracker;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
* Represents a Doctor.
* */
public class Doctor extends Person {
    /**
     * The unique Specialization for the doctor.
     * */
    private String specialization;
    /**
     * List of patients for doctor.
     * */
    private final List<Patient> patients;

    /**
    * Constructs a doctor with given details.
     *
     * @param id The Doctors ID.
     * @param name The Doctors Name.
     * @param age The Doctors Age.
     * @param phoneNumber The Doctors Contact number.
     * @param specialization The Doctors speciality.
     * */
    public Doctor(final int id
            , final String name
            , final int age
            , final String phoneNumber
            , final String specialization) {
        super(id, name, age, phoneNumber);
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    /**
     * retrieves list of patients assigned to doctor.
     *
     * @return a list of patients.
     * */
    public List<Patient> getPatients() {
        return patients;
    }

    /**
     * Adds a patient to the doctor list.
     *
     * @param patient The patient to add.
     * */
    public void addPatient(final Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
    }
    /**
     * Gets doctor speciality.
     *
     * @return the doctors specialization.
     * */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * Sets Doctor Speciality.
     *
     * @param specialization The Doctors specialization.
     * */
    public void setSpecialization(final String specialization) {
        this.specialization = specialization;
    }

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", getId());
        jsonObject.put("name", getName());
        jsonObject.put("age", getAge());
        jsonObject.put("phoneNumber", getPhoneNumber());
        jsonObject.put("specialization", getSpecialization());
        return jsonObject;
    }

    public static Doctor fromDoctorJson(JSONObject jsonObject) {
        int id = getIntValue(jsonObject.get("id"));
        String name = (String) jsonObject.get("name");
        int age = getIntValue(jsonObject.get("age"));
        String phoneNumber = (String) jsonObject.get("phoneNumber");
        String Spec = (String) jsonObject.get("Specialization");

        return new Doctor(id
                , name
                , age
                , phoneNumber
                , Spec);
    }

    private static int getIntValue(Object value) {
        if (value instanceof Long) {
            return ((Long) value).intValue();
        } else if (value instanceof Integer) {
            return (Integer) value;
        } else {
            throw new IllegalArgumentException("Invalid type for integer value: " + value.getClass());
        }
    }
    /**
     * Returns a string representation of the Doctor object.
     * The string includes the doctor's
     * ID, name, age, phone number, specialization,
     * and the number of patients assigned to the doctor.
     *
     * @return A formatted string containing the doctor's details.
     */
    @Override
    public String toString() {
        return String.format("Doctor ID: %d%n"
                        +"Doctor Name: %s%n"
                        +"Doctor Age: %d%n"
                        +"Doctor Phone Number: %s%n"
                        +"Specialization: %s%n"
                        +"Number of Patients: %d%n",
                getId()
                ,getName()
                ,getAge()
                ,getPhoneNumber()
                ,specialization
                ,patients.size()
        );
    }
}
