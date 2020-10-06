import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FahrerstatistikTest {

	@BeforeEach
	void setUp() throws Exception {
	}

    @DisplayName("Test bei leerer Fahrerstatistik")
    void build() {
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
    		"}", Fahrerstatistik.build());
    }

}
