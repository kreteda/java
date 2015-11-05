package com.example.jdbcdemo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.example.jdbcdemo.domain.Sprzedawca;

public class SprzedawcaManagerTest {
	
	
	SprzedawcaManager SprzedawcaManager = new SprzedawcaManager();
	
	private final static String IMIE_1 = "Michał";
	private final static String NAZWISKO_1 = "Jaworski";
	private final static int NR_TEL_1 = 512186646;
	
	@Test
	public void checkConnection(){
		assertNotNull(SprzedawcaManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		
		Sprzedawca Sprzedawca = new Sprzedawca(IMIE_1, NAZWISKO_1, NR_TEL_1);

		SprzedawcaManager.wyczyscSprzedawcow();
		assertEquals(1,SprzedawcaManager.dodajSprzedawce(Sprzedawca));
		
		List<Sprzedawca> Sprzedawcy = SprzedawcaManager.PobierzSprzedawcow();
		Sprzedawca SprzedawcaRetrieved = Sprzedawcy.get(0);
		
		assertEquals(IMIE_1, SprzedawcaRetrieved.getImie());
		assertEquals(NAZWISKO_1, SprzedawcaRetrieved.getNazwisko());
		assertEquals(NR_TEL_1, SprzedawcaRetrieved.getNr());
		
	}

}
