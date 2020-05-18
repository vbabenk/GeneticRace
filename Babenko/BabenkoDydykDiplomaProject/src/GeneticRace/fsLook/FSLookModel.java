// Copyright © 2019. All rights reserved.
// Authors: Vitalii Babenko, Anastasiia Dydyk
// Contacts: vbabenko2191@gmail.com

package GeneticRace.fsLook;

import org.sqlite.JDBC;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class FSLookModel {
    public ArrayList<String> loadPatient() throws SQLException, IOException {
        ArrayList<String> patient = new ArrayList<>();
        String id = null;
        BufferedReader reader = new BufferedReader(new FileReader("D:\\JavaProjects\\Babenko\\Files\\currentPatient.txt"));
        String currLine;
        while ((currLine = reader.readLine()) != null) {
            id = currLine;
        }
        reader.close();
        String conStr = "jdbc:sqlite:D:\\MyDatabases\\HeartDefects.db";
        DriverManager.registerDriver(new JDBC());
        Connection con = DriverManager.getConnection(conStr);
        Statement stmt = con.createStatement();
        String select = "SELECT * FROM Patients WHERE patientId = " + id;
        ResultSet rs = stmt.executeQuery(select);
        if (rs.next()) {
            patient.add(rs.getString(4));
            patient.add(rs.getString(5));
            patient.add(rs.getString(6));
            patient.add(rs.getString(7));
            patient.add(rs.getString(8));
        }
        select = "SELECT * FROM FirstStage WHERE patientID = " + id;
        rs = stmt.executeQuery(select);
        if (rs.next()) {
            patient.add(rs.getString(3));
            patient.add(rs.getString(4));
            patient.add(rs.getString(5));
            patient.add(rs.getString(6));
            patient.add(rs.getString(7));
            patient.add(rs.getString(8));
            patient.add(rs.getString(9));
            patient.add(rs.getString(10));
            patient.add(rs.getString(11));
            patient.add(rs.getString(12));
        }
        return patient;
    }
}
