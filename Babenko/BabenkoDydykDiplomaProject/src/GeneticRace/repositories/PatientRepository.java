// Copyright © 2019. All rights reserved.
// Authors: Vitalii Babenko, Anastasiia Dydyk
// Contacts: vbabenko2191@gmail.com

package GeneticRace.repositories;

import GeneticRace.classes.Patient;
import org.sqlite.JDBC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class PatientRepository {
    private ArrayList<Patient> patientList;

    public PatientRepository() {
        patientList = new ArrayList<>();
    }

    public ArrayList<Patient> getPatientList(String userRole) throws SQLException, IOException {
        String conStr = "jdbc:sqlite:D:\\MyDatabases\\HeartDefects.db";
        DriverManager.registerDriver(new JDBC());
        Connection con = DriverManager.getConnection(conStr);
        if(userRole.equals("Admin")) {
            Statement stmt = con.createStatement();
            String select = "SELECT * FROM Patients";
            ResultSet rs = stmt.executeQuery(select);
            while (rs.next()) {
                Patient patient = new Patient(rs.getInt(1), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8));
                patientList.add(patient);
            }
            con.close();
            return patientList;
        }
        else{
            Statement stmt = con.createStatement();
            BufferedReader reader = new BufferedReader(new FileReader("D:\\JavaProjects\\Babenko\\Files\\userID.txt"));
            String currLine;
            String doctorID = null;
            while((currLine = reader.readLine()) != null){
                doctorID = currLine;
            }
            reader.close();
            String select = "SELECT * FROM Patients WHERE doctorID = " + doctorID + " OR secondDoctorID = " + doctorID;
            ResultSet rs = stmt.executeQuery(select);
            while (rs.next()) {
                Patient patient = new Patient(rs.getInt(1), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8));
                patientList.add(patient);
            }
            con.close();
            return patientList;
        }
    }
}
