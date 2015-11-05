package com.example.jdbcdemo.service;

import com.example.jdbcdemo.domain.Sprzedawca;
import com.example.jdbcdemo.domain.Wlasciciel;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WlascicielMenagerTest {

    WlascicielMenager WlascicielMenager = new WlascicielMenager();

    private final static String IMIE_1 = "Marek";
    private final static String NAZWISKO_1 = "Kwasny";
    private final static int NR_TEL_1 = 520123123;

    private final static String IMIE_2 = "Mirek";
    private final static String NAZWISKO_2 = "Stoper";
    private final static int NR_TEL_2 = 123123123;


    @Test
    public void checkConnection(){
        assertNotNull(WlascicielMenager.getConnection());
    }


    @Test
    public void checkAdding(){

        Wlasciciel wlasciciel = new Wlasciciel(IMIE_1, NAZWISKO_1, NR_TEL_1);

        WlascicielMenager.wyczyscWlascicieli();
        assertEquals(1, WlascicielMenager.dodajWlasciciela(wlasciciel));

        List<Wlasciciel> wlasciciels = WlascicielMenager.GetWlascicieli();
        Wlasciciel wlascicelRetrieved = wlasciciels.get(0);

        assertEquals(IMIE_1, wlascicelRetrieved.getImie());
        assertEquals(NAZWISKO_1, wlascicelRetrieved.getNazwisko());
        assertEquals(NR_TEL_1, wlascicelRetrieved.getNr());

    }


    @Test
    public void testGetWlascicieli() throws Exception {

    }

    @Test
    public void testUpdateWlasciciel() throws Exception {

    }
}