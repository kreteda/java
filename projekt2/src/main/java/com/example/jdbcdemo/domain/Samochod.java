package com.example.jdbcdemo.domain;

/**
 * Created by dell on 2015-11-06.
 */
public class Samochod {

    private long samochod_id;

    private String imie;
    private String model;
    private String data_przyjecia;
    private long sprzedawca_id;
    private long wlasciciel_id;

    public Samochod() {
    }

    public Samochod(String imie, String model, String data_przyjecia, long sprzedawca_id, long wlasciciel_id) {
        super();
        this.imie = imie;
        this.model = model;
        this.data_przyjecia = data_przyjecia;
        this.sprzedawca_id = sprzedawca_id;
        this.wlasciciel_id = wlasciciel_id;
    }
    public long getId() {
        return samochod_id;
    }
    public void setId(long samochod_id) {
        this.samochod_id = samochod_id;
    }
    public String getImie() {
        return imie;
    }

    public String getmodel() {
        return model;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setmodel(String model) {
        this.model = model;
    }

    public String getData_przyjecia() {
        return data_przyjecia;
    }

    public void setData_przyjecia(String data_przyjecia) {
        this.data_przyjecia = data_przyjecia;
    }

    public long getsprzedawca_id() {
        return sprzedawca_id;
    }

    public void setsprzedawca_id(long sprzedawca_id) {
        this.sprzedawca_id = sprzedawca_id;
    }

    public long getWlasciciel_id() {
        return wlasciciel_id;
    }

    public void setWlasciciel_id(long wlasciciel_id) {
        this.wlasciciel_id = wlasciciel_id;
    }

    
}
