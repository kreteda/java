package com.example.jdbcdemo.domain;

/**
 * Created by dell on 2015-11-05.
 */
public class sprzedawca {

    private long sprzedawca_id;

    private String imie;
    private String nazwisko;
    private int nr_tel;

    public sprzedawca() {
    }

    public sprzedawca(String imie, String nazwisko, int nr_tel) {
        super();
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nr_tel = nr_tel;
    }
    public long getId() {
        return sprzedawca_id;
    }
    public void setId(long sprzedawca_id) {
        this.sprzedawca_id = sprzedawca_id;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getNr() {
        return nr_tel;
    }
    public void setNr(int nr_tel) {
        this.nr_tel = nr_tel;
    }

}
