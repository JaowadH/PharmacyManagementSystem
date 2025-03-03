package menuUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:pharmacy.db";

    public static Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC"); // ✅ Ensure SQLite driver is loaded
            return DriverManager.getConnection(URL);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("SQLite JDBC Driver not found", e);
        } catch (SQLException e) {
            throw new RuntimeException("Database connection failed", e);
        }
    }

    public static void initializeDatabase() {
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {

            // ✅ Always Drop Old Tables (Ensures Schema is Updated)
            stmt.execute("DROP TABLE IF EXISTS Patients");
            stmt.execute("DROP TABLE IF EXISTS Doctors");
            stmt.execute("DROP TABLE IF EXISTS Medications");

            // ✅ Create Patients Table with Correct Schema
            String createPatientsTable = "CREATE TABLE Patients (" +
                    "patientID INTEGER PRIMARY KEY AUTOINCREMENT, " +  // ✅ Auto-increment Primary Key
                    "name TEXT NOT NULL, " +
                    "age INTEGER NOT NULL, " +
                    "phoneNumber TEXT NOT NULL)";

            // ✅ Create Doctors Table
            String createDoctorsTable = "CREATE TABLE Doctors (" +
                    "doctorID INTEGER PRIMARY KEY AUTOINCREMENT, " +  // ✅ Auto-increment Primary Key
                    "name TEXT NOT NULL, " +
                    "age INTEGER NOT NULL, " +
                    "phoneNumber TEXT NOT NULL, " +
                    "specialization TEXT NOT NULL)";

            // ✅ Create Medications Table
            String createMedicationsTable = "CREATE TABLE Medications (" +
                    "medID INTEGER PRIMARY KEY AUTOINCREMENT, " +  // ✅ Auto-increment Primary Key
                    "medName TEXT NOT NULL, " +
                    "dose TEXT NOT NULL, " +
                    "quantity INTEGER NOT NULL, " +
                    "expiryDate TEXT NOT NULL)";

            // Execute table creation
            stmt.execute(createPatientsTable);
            stmt.execute(createDoctorsTable);
            stmt.execute(createMedicationsTable);

            System.out.println("✅ Database initialized successfully with fresh tables.");

        } catch (SQLException e) {
            throw new RuntimeException("❌ Database initialization failed", e);
        }
    }
}
