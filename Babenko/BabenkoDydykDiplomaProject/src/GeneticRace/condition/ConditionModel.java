// Copyright © 2019. All rights reserved.
// Authors: Vitalii Babenko, Anastasiia Dydyk
// Contacts: vbabenko2191@gmail.com

package GeneticRace.condition;

import org.sqlite.JDBC;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class ConditionModel {
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
        return patient;
    }

    public boolean addNewCondition(String pe, String vab, String pEarly, String plicat, String stroke, String thrombosis,
                                String chyle, String avb, String snd) throws SQLException, IOException {
        DriverManager.registerDriver(new JDBC());
        Connection con = DriverManager.getConnection("jdbc:sqlite:D:\\MyDatabases\\HeartDefects.db");
        String id = null;
        BufferedReader reader = new BufferedReader(new FileReader("D:\\JavaProjects\\Babenko\\Files\\currentPatient.txt"));
        String currLine;
        while ((currLine = reader.readLine()) != null) {
            id = currLine;
        }
        String select = "SELECT COUNT(*) FROM PatientPC WHERE patientID = " + id;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        int count = rs.getInt(1);
        if(count == 0) {
            String comma = ",";
            String symbol = "'";
            String insert = "INSERT INTO PatientPC VALUES(" + id + comma + symbol + pe + symbol + comma + symbol + vab +
                    symbol + comma + symbol + pEarly + symbol + comma + symbol + plicat + symbol + comma + symbol + stroke +
                    symbol + comma + symbol + thrombosis + symbol + comma + symbol + chyle + symbol + comma + symbol + avb +
                    symbol + comma + symbol + snd + "')";
            stmt = con.createStatement();
            stmt.executeUpdate(insert);
            con.close();
            return true;
        }
        else{
            con.close();
            return false;
        }
    }
}
