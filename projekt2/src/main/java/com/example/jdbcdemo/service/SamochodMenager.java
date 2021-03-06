package com.example.jdbcdemo.service;

/**
 * Created by dell on 2015-11-06.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.jdbcdemo.domain.Samochod;

public class SamochodMenager {

    private Connection connection;

    private String url = "jdbc:hsqldb:hsql://localhost/workdb";

    private String createTableSamochod = "CREATE TABLE Samochod(samochod_id bigint GENERATED BY DEFAULT AS IDENTITY, imie varchar(20), gatunek varchar(20), sprzedawca_id bigint, wlasciciel_id bigint,   FOREIGN KEY (sprzedawca_id) REFERENCES sprzedawca(sprzedawca_id),\n" +
            "  FOREIGN KEY (wlasciciel_id) REFERENCES wlasciciel(wlasciciel_id))";

    private PreparedStatement DodajSamochod;
    private PreparedStatement UsunSamochody;
    private PreparedStatement UsunSamochod;
    private PreparedStatement GetSamochody;
    private PreparedStatement UpdateSamochod;

    private Statement statement;

    public SamochodMenager() {
        try {
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();

            ResultSet rs = connection.getMetaData().getTables(null, null, null,
                    null);
            boolean tableExists = false;
            while (rs.next()) {
                if ("Zwierze".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
                    tableExists = true;
                    break;
                }
            }

            if (!tableExists)
                statement.executeUpdate(createTableSamochod);

            DodajSamochod = connection
                    .prepareStatement("INSERT INTO Zwierze (imie, gatunek, data_przyecia, opiekun_id, wlasciciel_id) VALUES (?, ?, ?, ?, ?)");
            UsunSamochody = connection
                    .prepareStatement("DELETE FROM Zwierze");
            UsunSamochod = connection
                    .prepareStatement("DELETE FROM Zwierze WHERE zwierze_id = ?");
            GetSamochody = connection
                    .prepareStatement("SELECT zwierze_id, imie, gatunek, data_przyjecia, opiekun_id, wlasciciel_id FROM Zwierze");
            UpdateSamochod = connection
                    .prepareStatement("UPDATE Zwierze SET imie = ?, gatunek = ?, data_przyjecia = ?, opiekun_id = ?, wlasciciel_id = ? WHERE zwierze_id = ?");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    Connection getConnection() {
        return connection;
    }

    void wyczyscSamochody() {
        try {
            UsunSamochody.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int usunSamochod(Samochod samochod) {
        int count = 0;
        try {
            UsunSamochod.setLong(1, samochod.getId());

            count = UsunSamochod.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int dodajZwierze(Samochod samochod) {
        int count = 0;
        try {
            DodajSamochod.setString(1, samochod.getImie());
            DodajSamochod.setString(2, samochod.getmodel());
            DodajSamochod.setString(3, samochod.getData_przyjecia());
            DodajSamochod.setLong(4, samochod.getsprzedawca_id());
            DodajSamochod.setLong(5, samochod.getWlasciciel_id());

            count = DodajSamochod.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }


    public List<Samochod> GetSamochody(){
        List<Samochod> samochody = new ArrayList<Samochod>();

        try{
            ResultSet rs = GetSamochody.executeQuery();

            while(rs.next()){
                Samochod z = new Samochod();
                z.setId(rs.getLong("samochod_id"));
                z.setImie(rs.getString("imie"));
                z.setmodel(rs.getString("Model"));
                z.setData_przyjecia(rs.getString("data_przyjecia"));
                z.setsprzedawca_id(rs.getLong("sprzedawca_id"));
                z.setWlasciciel_id(rs.getLong("wlasciciel_id"));
                samochody.add(z);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return samochody;
    }

    public int updateSamochod(Samochod samochod){
        int count = 0;
        try{
            UpdateSamochod.setString(1, samochod.getImie());
            UpdateSamochod.setString(2, samochod.getmodel());
            UpdateSamochod.setLong(3, samochod.getId());
            UpdateSamochod.setString(4, samochod.getData_przyjecia());
            UpdateSamochod.setLong(5, samochod.getsprzedawca_id());
            UpdateSamochod.setLong(6, samochod.getWlasciciel_id());


            count = UpdateSamochod.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return count;
    }


}
