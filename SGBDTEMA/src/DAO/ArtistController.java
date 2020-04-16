package DAO;

import DataBase.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.Statement;

public class ArtistController {
    private static int id = 1;

    public static void create(String name, String country) {
        try {
            Statement stmt = DatabaseConnection.getInstance().getConnection().createStatement();
            String inserttable = "INSERT INTO artists VALUES (" +
                    id +
                    "," +
                    "'" +
                    name +
                    "'" +
                    "," +
                    "'" +
                    name +
                    "')";
            stmt.executeUpdate(inserttable);
            id++;
            DatabaseConnection.getInstance().getConnection().close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void findByName(String name) {
        try {
            Statement stmt = DatabaseConnection.getInstance().getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select * from artists where nume_artist = " + "'" + name + "'");
            while (rs.next())
                System.out.println("ID: " + rs.getInt(1) + " NAME: " + rs.getString(2) + " COUNTRY: " + rs.getString(3));
            DatabaseConnection.getInstance().getConnection().close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
