
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;

class ParkhausTest {
    @BeforeAll
    static void setupTest(){
    	System.out.println("Start!");
        for (int i =0;i<10;i++)
        Parkhaus.leave();
        Parkhaus.zahlung(10.7f);
        Parkhaus.zahlung(2.7f);
        Parkhaus.zahlung(1.3f);
    }

    @Test
    @DisplayName("Testet ob Summenfunktion funktioniert")
    void getSum() {
        assertEquals(Parkhaus.getSum(),(10.7f+2.7f+1.3f));
    }
    
    @Test
    @DisplayName("Testet ob Summenfunktion bei 0 Einkommen auch 0 zurück gibt")
    void getSumGleichNull() {
        assertEquals(Parkhaus.getSum(),(0f));
    }

    @Test
    void getAvg() {
        assertEquals(Parkhaus.getAvg(),(10.7f+2.7f+1.3f)/10);
    }

    @Test
    @DisplayName("Test bei leerer Fahrerstatistik")
    void getFahrstatistik() {
    	assertEquals("{\n" +
    		" \"data\": [\n" +
    		" {\n" +
    		" \"values\": [\n" +
    		"0,\n" +
    		"10\n" +
    		" ],\n" +
    		"\"labels\":[\"gebehindert\",\"gesund\"], \"type\": \"pie\"\n" +
    		" }\n" +
    		" ]\n" +
    		"}", Parkhaus.getFahrstatistik().build());
    }
    @Test
    @DisplayName("Testet 0 gesunde Kunden und 2 gehbehinderte Kunden")
    void getFahrstatistikNurGB() {
    	assertEquals("{\n" +
    		" \"data\": [\n" +
    		" {\n" +
    		" \"values\": [\n" +
    		"0,\n" +
    		"10\n" +
    		" ],\n" +
    		"\"labels\":[\"gebehindert\",\"gesund\"], \"type\": \"pie\"\n" +
    		" }\n" +
    		" ]\n" +
    		"}", Parkhaus.getFahrstatistik().build());
    }
    @Test
    @DisplayName("Testet 0 gehbehinderte Kunden und 2 gesunde Kunden")
    void getFahrstatistikNurGesunde() {
    	assertEquals("{\n" +
    		" \"data\": [\n" +
    		" {\n" +
    		" \"values\": [\n" +
    		"0,\n" +
    		"2\n" +
    		" ],\n" +
    		"\"labels\":[\"gebehindert\",\"gesund\"], \"type\": \"pie\"\n" +
    		" }\n" +
    		" ]\n" +
    		"}", Parkhaus.getFahrstatistik().build());
    }
    @Test
    void getPosWert() {
    }

    @Test
    void getNegWert() {
    }

    @Test
    @DisplayName("Test bei leeren Bewertung")
    void getNuErf() {
        assertEquals("{\n" +
                " \"data\": [\n" +
                " {\n" +
                " \"x\": [\n" +
                " \"Likes\",\n" +
                " \"Dislikes\"\n" +
                " ],\n" +
                " \"y\": [\n" +
                " 0,\n" +
                " 0\n" +
                " ],\n" +
                " \"type\": \"bar\"\n" +
                " }\n" +
                " ]\n" +
                "}",Parkhaus.getNuErf().build());
    }
    
    @Test
    @DisplayName("Testet 0 positive Bewertungen und 2 negative Bewertungen")
    void getNuErfNurNeg() {
        assertEquals("{\n" +
                " \"data\": [\n" +
                " {\n" +
                " \"x\": [\n" +
                " \"Likes\",\n" +
                " \"Dislikes\"\n" +
                " ],\n" +
                " \"y\": [\n" +
                " 0,\n" +
                " 2\n" +
                " ],\n" +
                " \"type\": \"bar\"\n" +
                " }\n" +
                " ]\n" +
                "}",Parkhaus.getNuErf().build());
    }

    @Test
    @DisplayName("Testet 0 negative Bewertungen und 2 positive Bewertungen")
    void getNuErfNurPos() {
        assertEquals("{\n" +
                " \"data\": [\n" +
                " {\n" +
                " \"x\": [\n" +
                " \"Likes\",\n" +
                " \"Dislikes\"\n" +
                " ],\n" +
                " \"y\": [\n" +
                " 2,\n" +
                " 0\n" +
                " ],\n" +
                " \"type\": \"bar\"\n" +
                " }\n" +
                " ]\n" +
                "}",Parkhaus.getNuErf().build());
    }
    
    @Test
    void leave() {
    }

    @Test
    void gb() {
    }

    @Test
    void zahlung() {
    }
    
	/**
	 * 
	 */
	@AfterAll
	public static void delete() {
		System.out.println("Test Ende!");
	}
}
