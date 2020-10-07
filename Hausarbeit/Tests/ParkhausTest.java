/**
 * @Author 
 */


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;

class ParkhausTest {
    @BeforeAll
    static void setup() {
    	System.out.println("Start!");
    }
   /* static void setupTest(){
    	System.out.println("Start!");
        for (int i =0;i<10;i++)
        Parkhaus.leave();
    }*/
    
    Parkhaus p;

    @Test
    @DisplayName("Testet ob Summenfunktion funktioniert")
    void getSum() {
    	p = new Parkhaus();
    	p.zahlung(10.7f*100);
        p.zahlung(2.7f*100);
        p.zahlung(1.3f*100);
        assertEquals((10.7f+2.7f+1.3f),(p.getSum()));
    }
    
    @Test
    @DisplayName("Keine negativen Zahlen bei getSum")
    void negativeZahlenSum(){
    	p = new Parkhaus();
       	assertTrue(p.getSum() >= 0);
    }
    
    @Test
    @DisplayName("Testet ob Summenfunktion bei 0 Einkommen auch 0 zurück gibt")
    void getSumGleichNull() {
    	p = new Parkhaus();
        assertEquals(p.getSum(),(0f));
    }

    @Test
    @DisplayName("Testet ob Avg funktioniert")
    void getAvg() {	
    	p = new Parkhaus();
    	for (int i =0;i<10;i++) {
            p.leave();
        }
    	p.zahlung(10.7f);
        p.zahlung(2.7f);
        p.zahlung(1.3f);
        assertEquals((10.7f+2.7f+1.3f)/10,p.getAvg());
    }
    
    @Test
    @DisplayName("Keine negativen Zahlen bei getAvg")
    void negativeZahlenAvg() {
    	p = new Parkhaus();
    	assertTrue(p.getAvg() >= 0);
    }

    @Test
    @DisplayName("Test bei leerer Fahrerstatistik")
    void getFahrstatistik() {
    	p = new Parkhaus();
    	assertEquals("{\n" +
    		" \"data\": [\n" +
    		" {\n" +
    		" \"values\": [\n" +
    		"0,\n" +
    		"0\n" +
    		" ],\n" +
    		"\"labels\":[\"gebehindert\",\"gesund\"], \"type\": \"pie\"\n" +
    		" }\n" +
    		" ]\n" +
    		"}", p.getFahrstatistik().build());
    }
    
    @Test
    @DisplayName("Testet 0 gesunde Kunden und 2 gehbehinderte Kunden")
    void getFahrstatistikNurGB() {
    	p = new Parkhaus();
    	p.getFahrstatistik().addGehbehindert();
    	p.getFahrstatistik().addGehbehindert();
    	assertEquals("{\n" +
    		" \"data\": [\n" +
    		" {\n" +
    		" \"values\": [\n" +
    		"2,\n" +
    		"0\n" +
    		" ],\n" +
    		"\"labels\":[\"gebehindert\",\"gesund\"], \"type\": \"pie\"\n" +
    		" }\n" +
    		" ]\n" +
    		"}", p.getFahrstatistik().build());
    }
    @Test
    @DisplayName("Testet 0 gehbehinderte Kunden und 2 gesunde Kunden")
    void getFahrstatistikNurGesunde() {
    	p = new Parkhaus();
    	p.getFahrstatistik().addFahrer();
    	p.getFahrstatistik().addFahrer();
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
    		"}", p.getFahrstatistik().build());
    }
    @Test
    void getPosWert() {
    	p = new Parkhaus();
    }

    @Test
    void getNegWert() {
    	p = new Parkhaus();
    }

    @Test
    @DisplayName("Test bei leeren Bewertung")
    void getNuErf() {
    	p = new Parkhaus();
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
                "}",p.getNuErf().build());
    }
    
    @Test
    @DisplayName("Testet 0 positive Bewertungen und 2 negative Bewertungen")
    void getNuErfNurNeg() {
    	p = new Parkhaus();
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
                "}",p.getNuErf().build());
    }

    @Test
    @DisplayName("Testet 0 negative Bewertungen und 2 positive Bewertungen")
    void getNuErfNurPos() {
    	p = new Parkhaus();
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
                "}",p.getNuErf().build());
    }
    
    @Test
    void leave() {
    	p = new Parkhaus();
    }

    @Test
    void gb() {
    	p = new Parkhaus();
    }

    @Test
    void zahlung() {
    	p = new Parkhaus();
    }
    
	/**
	 * 
	 */
	@AfterAll
	public static void delete() {
		System.out.println("Test Ende!");
	}
}
