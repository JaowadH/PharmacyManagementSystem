package menuUtils;

import java.sql.*;
import java.util.Date;
import medTracker.*;

public class MedicationTrackingSystem {

    public MedicationTrackingSystem() {
        DatabaseManager.initializeDatabase();
    }

    // ✅ Add a new patient
    public void addPatient(Patient newPatient) {
        String query = "INSERT INTO Patients (patientID, name, age, phoneNumber) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, newPatient.getId());
            stmt.setString(2, newPatient.getName());
            stmt.setInt(3, newPatient.getAge());
            stmt.setString(4, newPatient.getPhoneNumber());
            stmt.executeUpdate();
            System.out.println("Patient added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding patient: " + e.getMessage());
        }
    }

    // ✅ Add a new doctor
    public void addDoctor(Doctor newDoctor) {
        String query = "INSERT INTO Doctors (doctorID, name, age, phoneNumber, specialization) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, newDoctor.getId());
            stmt.setString(2, newDoctor.getName());
            stmt.setInt(3, newDoctor.getAge());
            stmt.setString(4, newDoctor.getPhoneNumber());
            stmt.setString(5, newDoctor.getSpecialization());
            stmt.executeUpdate();
            System.out.println("Doctor added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding doctor: " + e.getMessage());
        }
    }

    // ✅ Add a new medication
    public void addMedication(Medication newMed) {
        String query = "INSERT INTO Medications (medID, medName, dose, quantity, expiryDate) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, newMed.getMedID());
            stmt.setString(2, newMed.getMedName());
            stmt.setString(3, newMed.getDose());
            stmt.setInt(4, newMed.getQuantity());
            stmt.setDate(5, new java.sql.Date(newMed.getExpiryDate().getTime()));
            stmt.executeUpdate();
            System.out.println("Medication added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding medication: " + e.getMessage());
        }
    }

    // ✅ Generate system report
    public void generateReport() {
        System.out.println("\n--- Pharmacy Management System Report ---");
        try (Connection conn = DatabaseManager.connect()) {
            reportCount(conn, "Patients");
            reportCount(conn, "Doctors");
            reportCount(conn, "Medications");
            reportCount(conn, "Prescriptions");
        } catch (SQLException e) {
            System.out.println("Error generating report: " + e.getMessage());
        }
    }

    private void reportCount(Connection conn, String tableName) throws SQLException {
        String query = "SELECT COUNT(*) AS total FROM " + tableName;
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                System.out.println(tableName + ": " + rs.getInt("total"));
            }
        }
    }

    // ✅ Check for expired medications
    public void checkExpiredMedications() {
        String query = "SELECT medName FROM Medications WHERE expiryDate < ?";
        try (Connection conn = DatabaseManager.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDate(1, new java.sql.Date(new Date().getTime()));
            ResultSet rs = stmt.executeQuery();
            boolean hasExpired = false;
            while (rs.next()) {
                System.out.println("Expired: " + rs.getString("medName"));
                hasExpired = true;
            }
            if (!hasExpired) System.out.println("No expired medications.");
        } catch (SQLException e) {
            System.out.println("Error checking expired medications: " + e.getMessage());
        }
    }
}
