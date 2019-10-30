package GeneticRace.profile;

import org.sqlite.JDBC;

import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class ProfileModel {
    public void addNewPatient(String surname, String firstname, String middlename, String sex,
                              String birthday, String secondDoctor,  String lpa, String nakata, String vedp, String ppa,
                              String edi, String pvr, String risk, String zScore, String hypertrophy, String r,
                              String bas) throws SQLException, ParseException, IOException {
        DriverManager.registerDriver(new JDBC());
        Connection con = DriverManager.getConnection("jdbc:sqlite:D:\\MyDatabases\\HeartDefects.db");
        String doctorID = null;
        BufferedReader reader = new BufferedReader(new FileReader("D:\\JavaProjects\\Babenko\\Files\\userID.txt"));
        String currLine;
        while ((currLine = reader.readLine()) != null) {
            doctorID = currLine;
        }
        String secondDoctorID = null;
        String select = "SELECT userID FROM Users WHERE surname = '" + secondDoctor + "'";
        Statement stmt = con.createStatement();
        if (!secondDoctor.equals("")) {
            ResultSet rs = stmt.executeQuery(select);
            secondDoctorID = Integer.toString(rs.getInt(1));
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Date d = sdf.parse(birthday);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        LocalDate l = LocalDate.of(year, month, date);
        LocalDate now = LocalDate.now();
        String admit = now.format(dtf);
        Period diff = Period.between(l, now);
        double age = 12.0 * diff.getYears() + diff.getMonths();
        String comma = ",";
        String symbol = "'";
        String insert;
        if (secondDoctorID == null) {
            insert = "INSERT INTO Patients(doctorID, surname, firstname, middlename, sex, birthday, " +
                    "admit, age, lpa, nakata, vedp, ppa, edi, pvr, risk, zScore, hypertrophy, r, bas) VALUES(" + doctorID
                    + comma + symbol + surname + symbol + comma + symbol + firstname + symbol + comma + symbol +
                    middlename + symbol + comma + symbol + sex + symbol + comma + symbol + birthday + symbol + comma +
                    symbol + admit + symbol + comma + Double.toString(age) + comma + lpa + comma + nakata + comma + vedp
                    + comma + ppa + comma + edi + comma + pvr + comma + risk + comma + zScore + comma + symbol +
                    hypertrophy + symbol + comma + symbol + r + symbol + comma + symbol + bas + "')";
        } else {
            insert = "INSERT INTO Patients(doctorID, secondDoctorID, surname, firstname, middlename, sex, birthday, " +
                    "admit, age, lpa, nakata, vedp, ppa, edi, pvr, risk, zScore, hypertrophy, r, bas) VALUES(" + doctorID +
                    comma + secondDoctorID + comma + symbol + surname + symbol + comma + symbol + firstname + symbol + comma +
                    symbol + middlename + symbol + comma + symbol + sex + symbol + comma + symbol + birthday + symbol +
                    comma + symbol + admit + symbol + comma + Double.toString(age) + comma + lpa + comma + nakata + comma +
                    vedp + comma + ppa + comma + edi + comma + pvr + comma + risk + comma + zScore + comma + symbol +
                    hypertrophy + symbol + comma + symbol + r + symbol + comma + symbol + bas + "')";
        }
        stmt = con.createStatement();
        stmt.executeUpdate(insert);
        con.close();
    }
}
