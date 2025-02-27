package src.main.java.menuUtils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import src.main.java.medTracker.*;

import static src.main.java.medTracker.Doctor.fromDoctorJson;
import static src.main.java.medTracker.Patient.fromPatientJson;

public class MenuUtils {
    public static void addMed(MedicationTrackingSystem MTS, Scanner scanner) {
        // adding med id
        int medID;
        while (true) {
            System.out.print("Enter Medication ID: ");
            if (scanner.hasNextInt()) {
                medID = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("ERROR: Invalid input, Please enter a number for ID.");
                scanner.next();
            }
        }

        // adding med name
        System.out.print("Enter Medication Name: ");
        String medName = scanner.nextLine();

        // adding med dose
        System.out.print("Enter Dosage: ");
        String dose = scanner.nextLine();

        // adding quantity
        int quantity;
        while (true) {
            System.out.print("Enter Quantity: ");
            if (scanner.hasNextInt()) {
                quantity = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("ERROR: Invalid input, Please enter a number for Quantity.");
                scanner.next();
            }
        }

        // med object
        Medication newMed = new Medication(medID, medName, dose, quantity);
        MTS.addMedication(newMed);
        System.out.println("New Medication added: " + newMed);

        }
        // checking expired meds
        public static void checkExpiredMeds( List<Medication> medications ) {
            Date currDate = new Date();

            System.out.println("\n Expired Medications \n");
            boolean hasExpired = false;
            for (Medication med : medications) {
                if (med.getExpiryDate().compareTo(currDate) < 0 ) {
                    System.out.println("Expired: " + med);
                    hasExpired = true;
                }
            }

            if (!hasExpired) {
                System.out.println("No Expired Medications yet.");
            }
        }

    public Patient addPatient(Scanner scanner) {
        int patientID;
        while (true) {
            System.out.print("Enter Patient ID: ");
            if (scanner.hasNextInt()) {
                patientID = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("ERROR: Invalid input, Please enter a number for Patient ID.");
                scanner.next();
            }
        }

        System.out.print("Enter Patient Name: ");
        String patientName = scanner.nextLine();

        int patientAge;
        while (true) {
            System.out.print("Enter Patient Age: ");
            if (scanner.hasNextInt()) {
                patientAge = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("ERROR: Invalid input, Please enter a number for Patient Age.");
                scanner.next();
            }
        }

        System.out.print("Enter Patient Phone number: ");
        String patientPhoneNumber = scanner.nextLine();

        // patient object

        return new Patient(patientID, patientName, patientAge, patientPhoneNumber);
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


    public Doctor addDoctor(Scanner scanner) {
        int doctorID;
        while (true) {
            System.out.print("Enter Doctors ID: ");
            if (scanner.hasNextInt()) {
                doctorID = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("ERROR: Invalid input, Please enter a number for Doctor ID.");
                scanner.next();
            }
        }

        System.out.print("Enter Doctors Name: ");
        String doctorName = scanner.nextLine();

        int doctorAge;
        while (true) {
            System.out.print("Enter Doctor Age: ");
            if (scanner.hasNextInt()) {
                doctorAge = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("ERROR: Invalid input, Please enter a number for Doctor Age.");
                scanner.next();
            }
        }

        System.out.print("Enter Doctors Phone Number: ");
        String doctorPhoneNumber = scanner.nextLine();

        System.out.print("Enter Doctors Specialization: ");
        String Spec = scanner.nextLine();


        return new Doctor(doctorID, doctorName, doctorAge, doctorPhoneNumber, Spec);
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

    public static void handlePrescription(MedicationTrackingSystem MTS, Scanner scanner) {
        System.out.print("Enter Patient's name for prescription: ");
        String prescriptPatient = scanner.nextLine();
        System.out.print("Enter Doctor's name issuing the prescription: ");
        String prescriptDoctor = scanner.nextLine();
        System.out.print("Enter Medication Name: ");
        String prescriptMed = scanner.nextLine();

        Patient patient = MTS.findPatient(prescriptPatient);
        Doctor doctor = MTS.findDoctor(prescriptDoctor);
        Medication medication = MTS.findMedication(prescriptMed);

        if (patient != null && doctor != null && medication != null) {
            System.out.print("Enter Dosage: ");
            int dosage = scanner.nextInt();
            System.out.print("Enter Duration (days): ");
            int duration = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            MTS.acceptPrescription(patient.getId(), doctor, patient, medication, new java.util.Date());
            System.out.println("Prescription added successfully.");
        } else {
            System.out.println("Invalid input. Please check if the patient, doctor, or medication exists.");
        }
    }
    public static void docScript(MedicationTrackingSystem MTS, Scanner scanner) {
        System.out.print("Enter Doctor's name to view prescriptions: ");
        String scriptDoc = scanner.nextLine();
        MTS.printDoctorPrescriptions(scriptDoc);
    }

    public static void restockMedication(MedicationTrackingSystem MTS, Scanner scanner) {
        System.out.print("Enter Medication Name to restock: ");
        String restockMed = scanner.nextLine();
        System.out.print("Enter quantity to restock: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
        }
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        MTS.restockMedication(restockMed);
    }

    public static void printPatientPrescriptions(MedicationTrackingSystem MTS, Scanner scanner) {
        System.out.print("Enter Patient's name to view prescriptions: ");
        String scriptPatient = scanner.nextLine();
        MTS.printPatientPrescriptions(scriptPatient);
    }

}
