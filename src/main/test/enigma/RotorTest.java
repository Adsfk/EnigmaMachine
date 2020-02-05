package enigma;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotorTest {

    private Rotor rotor = new Rotor("0");

    @Test
    public void should_change_letters() {
        assertEquals("B",rotor.translate("A"));
        assertEquals("C",rotor.translate("B"));
        assertEquals("D",rotor.translate("C"));
    }

}