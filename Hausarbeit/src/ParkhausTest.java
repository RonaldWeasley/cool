
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ParkhausTest {
    @BeforeAll
    static void setupTest(){
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
    void getAvg() {
        assertEquals(Parkhaus.getAvg(),(10.7f+2.7f+1.3f)/10);
    }

    @Test
    void getFahrstatistik() {
    }

    @Test
    void getPosWert() {
    }

    @Test
    void getNegWert() {
    }

    @Test
    @DisplayName("Testet bei leeren Bewertung")
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
    void leave() {
    }

    @Test
    void gb() {
    }

    @Test
    void zahlung() {
    }
}
