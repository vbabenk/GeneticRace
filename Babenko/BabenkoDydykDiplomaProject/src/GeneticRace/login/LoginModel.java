package GeneticRace.login;

import org.sqlite.JDBC;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class LoginModel {

    public boolean checkAccount(String username, String password) throws SQLException {
        DriverManager.registerDriver(new JDBC());
        Connection con = DriverManager.getConnection("jdbc:sqlite:D:\\MyDatabases\\HeartDefects.db");
        String select = "SELECT COUNT(*) FROM Users WHERE username = '" + username + "' AND password = '" + password + "'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        if (rs.getInt(1) == 1) {
            con.close();
            return true;
        } else {
            con.close();
            return false;
        }
    }

    public void writeAccount(String username, String password) throws SQLException, IOException {
        DriverManager.registerDriver(new JDBC());
        Connection con = DriverManager.getConnection("jdbc:sqlite:D:\\MyDatabases\\HeartDefects.db");
        String select = "SELECT realname FROM Users WHERE username = '" + username + "' AND password = '" + password + "'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        String name = rs.getString(1);
        select = "SELECT userRole FROM Users WHERE username = '" + username + "' AND password = '" + password + "'";
        stmt = con.createStatement();
        rs = stmt.executeQuery(select);
        String userRole = rs.getString(1);
        select = "SELECT userID FROM Users WHERE username = '" + username + "' AND password = '" + password + "'";
        stmt = con.createStatement();
        rs = stmt.executeQuery(select);
        String userID = rs.getString(1);
        con.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\JavaProjects\\Babenko\\Files\\realName.txt"));
        writer.write(name);
        writer.close();
        writer = new BufferedWriter(new FileWriter("D:\\JavaProjects\\Babenko\\Files\\userRole.txt"));
        writer.write(userRole);
        writer.close();
        writer = new BufferedWriter(new FileWriter("D:\\JavaProjects\\Babenko\\Files\\userID.txt"));
        writer.write(userID);
        writer.close();
    }
}