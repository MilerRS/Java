package MAIN;

import DAO.ArtistController;
import DataBase.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.Statement;

public class MAIN {
    public static void main(String args[]) {
        try {
            Statement stmt = DatabaseConnection.getInstance().getConnection().createStatement();
            stmt.executeQuery("DROP TABLE albums");
            stmt.executeQuery("DROP TABLE artists");
            String createTable = "create table albums(" +
                    "    id integer not null," +
                    "    nume varchar(100) not null," +
                    "    artist_id integer not null," +
                    "    release_year integer," +
                    "    primary key (id)" +
                    ")";
            stmt.execute(createTable);

            createTable = "create table artists(" +
                    "    id integer not null," +
                    "    nume_artist varchar(100) not null," +
                    "    country varchar(100)," +
                    "    primary key (id)" +
                    ")";
            stmt.execute(createTable);

            DatabaseConnection.getInstance().getConnection().close();

            DAO.ArtistController.create("Dan","Romania");
            DAO.ArtistController.create("Ion","Romania");
            DAO.ArtistController.create("Mirel","Romania");
            DAO.ArtistController.create("Gigi","Romania");
            DAO.ArtistController.create("Leila","Romania");
            stmt = DatabaseConnection.getInstance().getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select * from artists");
            while (rs.next())
                System.out.println("ID: " + rs.getInt(1) + " NAME: " + rs.getString(2) + " COUNTRY: " + rs.getString(3));
            System.out.println();
            DAO.ArtistController.findByName("Mirel");
            System.out.println();
            DatabaseConnection.getInstance().getConnection().close();

            DAO.AlbumController.create("Cry",1,2000);
            DAO.AlbumController.create("Battle",1,2010);
            DAO.AlbumController.create("WeAre",3,2011);
            DAO.AlbumController.create("NOW",2,2019);
            DAO.AlbumController.create("FOREVER",4,1988);
            stmt = DatabaseConnection.getInstance().getConnection().createStatement();
            ResultSet rs2 = stmt.executeQuery("select * from albums");
            while (rs2.next())
                System.out.println("ID: " + rs2.getInt(1) + " NAME: " + rs2.getString(2) + " ARTIST ID: " + rs2.getString(3) + " RELEASE YEAR: " + rs2.getString(4));
            System.out.println();
            DAO.AlbumController.findByArtist(3);
            System.out.println();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

