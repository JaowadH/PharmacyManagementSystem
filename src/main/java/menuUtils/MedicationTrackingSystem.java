package menuUtils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import medTracker.*;

import static medTracker.Doctor.fromDoctorJson;
import static medTracker.Patient.fromPatientJson;

/**
 * The MedicationTrackingSystem class manages patients, doctors, medications,
 * and prescriptions within a pharmacy management system.
 */

public class MedicationTrackingSystem {
    private final List<Patient> patients;
    private final List<Doctor> doctors;
    private static List<Medication> medications = List.of();
    private final List<Prescription> prescriptions;

    /**
     * Constructs a MedicationTrackingSystem with empty lists for patients,
     * doctors, medications, and prescriptions.
     */

    public MedicationTrackingSystem() {
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    /**
     * Adds a new patient to the system.
     *
     * @param newPatient The patient to be added.
     */

    public void addPatient(Patient newPatient) {
        if (!patients.contains(newPatient)) {
            patients.add(newPatient);
            System.out.println("Patient added successfully.");
        } else {
            System.out.println("Patient already exists.");
        }
    }

    /**
     * Returns the list of patients in the system.
     *
     * @return A list of patients.
     */

    public List<Patient> getPatients() {
        return patients;
    }

    /**
     * Adds a new doctor to the system.
     *
     * @param newDoctor The doctor to be added.
     */

    public void addDoctor(Doctor newDoctor) {
        if (!doctors.contains(newDoctor)) {
            doctors.add(newDoctor);
            System.out.println("Doctor added successfully.");
        } else {
            System.out.println("Doctor already exists.");
        }
    }

    /**
     * Adds a new medication to the system.
     *
     * @param newMed The medication to be added.
     */

    public void addMedication(Medication newMed) {
        if (!medications.contains(newMed)) {
            medications.add(newMed);
            System.out.println("Medication added successfully.");
        } else {
            System.out.println("Medication already exists.");
        }
    }

    /**
     * Finds a patient by name.
     *
     * @param name The name of the patient to find.
     * @return The patient object if found, otherwise null.
     */

    Patient findPatient(String name) {
        for (Patient p : patients) {
            if (p.getName().equalsIgnoreCase(name)) return p;
        }
        return null;
    }

    /**
     * Finds a doctor by name.
     *
     * @param name The name of the doctor to find.
     * @return The doctor object if found, otherwise null.
     */

    Doctor findDoctor(String name) {
        for (Doctor d : doctors) {
            if (d.getName().equalsIgnoreCase(name)) return d;
        }
        return null;
    }

    /**
     * Finds a medication by name.
     *
     *
     */

    public static void findMedication(Scanner scanner) {
        for (Medication m : medications) {
            if (m.getMedName().equalsIgnoreCase(scanner.nextLine())) return;
        }
    }

    public static void savePatientToJson(List<Patient> patients, String filePath) {
        JSONArray jsonArray = new JSONArray();
        for (Patient patient : patients) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", patient.getId());
            jsonObject.put("name", patient.getName());
            jsonObject.put("age", patient.getAge());
            jsonObject.put("phoneNumber", patient.getPhoneNumber());

            jsonArray.add(jsonObject);
        }
        try (FileWriter fileWriter = new FileWriter(filePath)) { // Append mode
            fileWriter.write(jsonArray.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Patient> readPatientsFromJson(String filePath) {
        List<Patient> patients = new ArrayList<>();
        try (FileReader fileReader = new FileReader(filePath)) {
            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(fileReader); // Parse the file into a JSONArray

            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;
                patients.add(fromPatientJson(jsonObject)); // Convert JSON object to Patient and add to the list
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return patients;
    }

    public static void saveDoctorToJson(List<Doctor> doctors, String filePath) {
        JSONArray jsonArray = new JSONArray();
        for (Doctor doctor : doctors) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", doctor.getId());
            jsonObject.put("name", doctor.getName());
            jsonObject.put("age", doctor.getAge());
            jsonObject.put("phoneNumber", doctor.getPhoneNumber());
            jsonObject.put("specialization", doctor.getSpecialization());

            jsonArray.add(jsonObject);
        }
        try (FileWriter fileWriter = new FileWriter(filePath)) { // Append mode
            fileWriter.write(jsonArray.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Doctor> readDoctorsFromJson(String filePath) {
        List<Doctor> doctors = new ArrayList<>();
        try (FileReader fileReader = new FileReader(filePath)) {
            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(fileReader); // Parse the file into a JSONArray

            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;
                doctors.add(fromDoctorJson(jsonObject));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    public void generateReport() {
        String patientPath = "src/main/java/medTracker/patients.json";
        String DoctorPath = "src/main/java/medTracker/doctors.json";
        List<Patient> loadedPatients = readPatientsFromJson(patientPath);
        List<Doctor> loadedDoctors = readDoctorsFromJson(DoctorPath);
        for (Patient patient : loadedPatients) {
            System.out.println(patient);
        }
        for (Doctor doctor : loadedDoctors) {
            System.out.println(doctor);
        }
    }

    public void checkExpiredMedications() {
        System.out.println("Checking for expired medications...");
        Date currDate = new Date();
        boolean foundExpired = false;
        for (Medication med : medications) {
            if (med.getExpiryDate().compareTo(currDate) < 0) {
                System.out.println("Expired: " + med.getMedName());
                foundExpired = true;
            }
        }
        if (!foundExpired) {
            System.out.println("No expired medications found.");
        }
    }
}

