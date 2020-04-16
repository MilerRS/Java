package DAO;

import DataBase.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.Statement;

public class AlbumController {
    private static int id = 1;

    public static void create(String name, int artistId, int releaseYear) {
        try {
            Statement stmt = DatabaseConnection.getInstance().getConnection().createStatement();
            String inserttable = "INSERT INTO albums VALUES (" +
                    id +
                    ", " +
                    "'" + name + "'" +
                    ", " +
                    artistId +
                    ", " +
                    releaseYear +
                    ")";
            stmt.executeUpdate(inserttable);
            id++;
            DatabaseConnection.getInstance().getConnection().close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void findByArtist(int artistId) {
        try {
            Statement stmt = DatabaseConnection.getInstance().getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select * from albums where artist_id = " + artistId);
            while (rs.next())
                System.out.println("ID: " + rs.getInt(1) + " NAME: " + rs.getString(2) + " ARTIST ID: " + rs.getString(3) + " RELEASE YEAR: " + rs.getString(4));
            DatabaseConnection.getInstance().getConnection().close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
