package enigma;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotorTest {

    private Rotor rotor = new Rotor("I");

    @Test
    public void should_change_letter_a_by_b() {
        assertEquals("B",rotor.translate("A"));
    }

}