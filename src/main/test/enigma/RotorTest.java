package enigma;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotorTest {

    private Rotor rotor = new Rotor("0");

    @Test
    public void should_change_letter_a_by_b() {
        assertEquals("B",rotor.translate("A"));
    }

    @Test
    public void should_change_letter_b_by_c() {
        assertEquals("C",rotor.translate("B"));
    }


    @Test
    public void should_change_letter_c_by_d() {
        assertEquals("D",rotor.translate("C"));
    }
}