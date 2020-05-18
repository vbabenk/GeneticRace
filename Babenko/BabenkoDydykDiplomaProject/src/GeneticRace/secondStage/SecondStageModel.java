// Copyright © 2019. All rights reserved.
// Authors: Vitalii Babenko, Anastasiia Dydyk
// Contacts: vbabenko2191@gmail.com

package GeneticRace.secondStage;

import org.sqlite.JDBC;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class SecondStageModel {

    public ArrayList<String> loadPatient() throws SQLException, IOException {
        ArrayList<String> patient = new ArrayList<>();
        String id = null;
        BufferedReader reader = new BufferedReader(new FileReader("D:\\JavaProjects\\Babenko\\Files\\currentPatient.txt"));
        String currLine;
        while((currLine = reader.readLine()) != null){
            id = currLine;
        }
        reader.close();
        String conStr = "jdbc:sqlite:D:\\MyDatabases\\HeartDefects.db";
        DriverManager.registerDriver(new JDBC());
        Connection con = DriverManager.getConnection(conStr);
        Statement stmt = con.createStatement();
        String select = "SELECT * FROM Patients WHERE patientId = " + id;
        ResultSet rs = stmt.executeQuery(select);
        if(rs.next()) {
            patient.add(rs.getString(4));
            patient.add(rs.getString(5));
            patient.add(rs.getString(6));
            patient.add(rs.getString(7));
            patient.add(rs.getString(8));
        }
        select = "SELECT * FROM PatientPC WHERE patientID = " + id;
        rs = stmt.executeQuery(select);
        if(rs.next()){
            patient.add(rs.getString(2));
            patient.add(rs.getString(3));
            patient.add(rs.getString(4));
            patient.add(rs.getString(5));
            patient.add(rs.getString(6));
            patient.add(rs.getString(7));
            patient.add(rs.getString(8));
            patient.add(rs.getString(9));
            patient.add(rs.getString(10));
        }
        return patient;
    }

    public ArrayList<String> calculateTreatment(ArrayList<String> patient) throws IOException, InterruptedException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\JavaProjects\\Babenko\\Files\\currentInput.txt"));
        for(int i = 5; i < patient.size(); i++){
            String value = patient.get(i);
            if(value.equals("Ні")){
                value = "1.0";
            }
            if(value.equals("Так")){
                value = "2.0";
            }
            if(i < patient.size()-1) {
                writer.write(value + " ");
            }
            else{
                writer.write(value);
            }
        }
        writer.close();
        ArrayList<String> resultList = new ArrayList<>();
        Process p = Runtime.getRuntime().exec("D:\\Anaconda3\\python.exe " +
                "D:\\JavaProjects\\Babenko\\BabenkoDydykDiplomaProject\\src\\GeneticRace\\python\\SecondStage.py");
        p.waitFor();
        Scanner s = new Scanner(new File("D:\\JavaProjects\\Babenko\\Files\\currentResult.txt"));
        while(s.hasNext()){
            resultList.add(s.next());
        }
        s.close();
        return resultList;
    }

    public void saveResult(ArrayList<String> resultList) throws SQLException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String commit = formatter.format(calendar.getTime());
        String conStr = "jdbc:sqlite:D:\\MyDatabases\\HeartDefects.db";
        DriverManager.registerDriver(new JDBC());
        Connection con = DriverManager.getConnection(conStr);
        Statement stmt = con.createStatement();
        String comma = ",";
        String symbol = "'";
        String insert = "INSERT INTO SecondStage(patientID, x401, x402, x403, x404, x405, x406, x407, x408, x409, " +
                "lastcommit) VALUES(" + symbol + resultList.get(0) + symbol + comma + symbol + resultList.get(1) +
                symbol + comma + symbol + resultList.get(2) + symbol + comma + symbol + resultList.get(3) + symbol +
                comma + symbol + resultList.get(4) + symbol + comma + symbol + resultList.get(5) + symbol + comma +
                symbol + resultList.get(6) + symbol + comma + symbol + resultList.get(7) + symbol + comma + symbol +
                resultList.get(8) + symbol + comma + symbol + resultList.get(9) + symbol + comma + symbol + commit +
                symbol + ")";
        stmt.executeUpdate(insert);
        con.close();
    }
}
