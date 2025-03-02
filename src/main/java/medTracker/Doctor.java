/**
 * Represents a doctor in the medical tracking system.
 * A doctor is a specialized person who can have multiple patients.
 */

package medTracker;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person {
    private String specialization;
    private final List<Patient> patients;

    /**
     * Constructs a new Doctor with the specified details.
     *
     * @param id The unique identifier of the doctor.
     * @param name The name of the doctor.
     * @param age The age of the doctor.
     * @param phoneNumber The contact number of the doctor.
     * @param specialization The field of expertise of the doctor.
     */

    public Doctor(int id, String name, int age, String phoneNumber, String specialization) {
        super(id, name, age, phoneNumber);
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    /**
     * Returns the list of patients assigned to this doctor.
     *
     * @return List of patients.
     */

    public List<Patient> getPatients() {
        return patients;
    }

    /**
     * Adds a patient to the doctor's list of patients.
     *
     * @param patient The patient to be added.
     */

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    /**
     * Returns the doctor's specialization.
     *
     * @return The specialization of the doctor.
     */

    public String getSpecialization() {
        return specialization;
    }

    /**
     * Sets the doctor's specialization.
     *
     * @param specialization The new specialization of the doctor.
     */

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return String.format(
            "Doctor ID: %d%nDoctor Name: %s%nDoctor Age: %d%nDoctor Phone Number: %s%nSpecialization: %s%nNumber of Patients: %d%n",
            getId(), getName(), getAge(), getPhoneNumber(), specialization, patients.size()
        );
    }
}
