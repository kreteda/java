package com.example.jdbcdemo.service;

/**
 * Created by dell on 2015-11-05.
 */

import static org.junit.Assert.*;

import java.util.List;
import com.example.jdbcdemo.domain.Sprzedawca;

import org.junit.Test;

public class SprzedawcaMenagerTest {

    SprzedawcaMenager SprzedawcaMenager = new SprzedawcaMenager();

    private final static String IMIE_1 = "Marek";
    private final static String NAZWISKO_1 = "Kwasny";
    private final static int NR_TEL_1 = 520123123;

    private final static String IMIE_2 = "Mirek";
    private final static String NAZWISKO_2 = "Stoper";
    private final static int NR_TEL_2 = 123123123;

    @Test
    public void checkConnection(){
        assertNotNull(SprzedawcaMenager.getConnection());
    }

    @Test
    public void checkAdding(){

        Sprzedawca sprzedawca = new Sprzedawca(IMIE_1, NAZWISKO_1, NR_TEL_1);

        SprzedawcaMenager.wyczyscSprzedawcow();
        assertEquals(1, SprzedawcaMenager.dodajSprzedawca(sprzedawca));

        List<Sprzedawca> sprzedawcy = SprzedawcaMenager.GetSprzedawcow();
        Sprzedawca sprzedawcaRetrieved = sprzedawcy.get(0);

        assertEquals(IMIE_1, sprzedawcaRetrieved.getImie());
        assertEquals(NAZWISKO_1, sprzedawcaRetrieved.getNazwisko());
        assertEquals(NR_TEL_1, sprzedawcaRetrieved.getNr());

    }

    @Test
    public void checkUpdate(){

        Sprzedawca sprzedawca= new Sprzedawca(IMIE_1, NAZWISKO_1, NR_TEL_1);

        SprzedawcaMenager.wyczyscSprzedawcow();
        assertEquals(1,SprzedawcaMenager.dodajSprzedawca(sprzedawca));

        List<Sprzedawca> sprzedawcy = SprzedawcaMenager.GetSprzedawcow();
        Sprzedawca sprzedawcaRetrieved = sprzedawcy.get(0);

        sprzedawcaRetrieved.setImie(IMIE_2);
        sprzedawcaRetrieved.setNazwisko(NAZWISKO_2);
        sprzedawcaRetrieved.setNr(NR_TEL_2);


        assertEquals(1, SprzedawcaMenager.updateSprzedawca(sprzedawcaRetrieved));

        List<Sprzedawca> sp = SprzedawcaMenager.GetSprzedawcow();
        Sprzedawca sprzedawcaRetrieved2 = sp.get(0);

        assertEquals(IMIE_2, sprzedawcaRetrieved2.getImie());
        assertEquals(NAZWISKO_2, sprzedawcaRetrieved2.getNazwisko());
        assertEquals(NR_TEL_2, sprzedawcaRetrieved2.getNr());
        assertEquals(sprzedawcaRetrieved2.getId(), sprzedawcaRetrieved2.getId());

    }

    @Test
    public void checkDelete() {
        Sprzedawca sprzedawca = new Sprzedawca(IMIE_1, NAZWISKO_1, NR_TEL_1);

        SprzedawcaMenager.wyczyscSprzedawcow();
        assertEquals(1, SprzedawcaMenager.dodajSprzedawca(sprzedawca));

        List<Sprzedawca> sprzedawcy = SprzedawcaMenager.GetSprzedawcow();
        Sprzedawca sprzedawcaRetrieved = sprzedawcy.get(0);

        assertEquals(1, SprzedawcaMenager.usunSprzedawca(sprzedawcaRetrieved));

    }


}
