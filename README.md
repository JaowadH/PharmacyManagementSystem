# Pharmacy Management System Documentation
## Authors: Cody Collins, Colin Yetman, Jaowad Hossain

## 1. User Documentation

### 1.1 Introduction

The Pharmacy Management System is a Java-based application designed to streamline the management of medications, prescriptions, and patient records. This system allows users to add, update, and manage patients, doctors, prescriptions and medications efficiently.

### 1.2 Application Overview

- **Programming Language**: Java
- **Version Control**: GitHub
- **Usage**: Manage a pharmacy system with doctor, patient, medication, and prescription

### 1.3 Class Descriptions

Below is an overview of the main classes and their functionality:

- **Medication**: Manages medication details such as name, dosage, quantity, and expiry date.
- **Prescription**: Links patients and doctors to medications and maintains prescription expiry.
- **Doctor**: Stores information about doctors.
- **Patient**: Maintains patient details.
- **Menu**: Handles user interaction and system navigation.

### 1.4 How to Start the Application

1. Clone the GitHub repository: `git clone <repository-url>`
2. Compile the Java files: `javac *.java`
3. Run the application: `java Menu`
4. Follow on-screen instructions to interact with the system.

### 1.5 Class Diagram

![Class Diagram](/images/class-diagram.png)

---

## 2. Deployment Documentation

### 2.1 Installation Steps

1. Download the latest release from GitHub: `git clone <repository-url>`
2. Ensure Java is installed: `java -version`
3. Navigate to the project directory: `cd <main-path>`
4. Compile and run the application: `javac *.java && java Menu`

### 2.2 Troubleshooting

- **Issue:** Java not recognized
  - **Solution:** Install Java and set the environment variable.
- **Issue:** Compilation errors
  - **Solution:** Ensure all dependencies are included and paths are correct.