package enigma;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotorTest {

    @Test
    public void should_change_letters() {
        Rotor rotor = new Rotor("0");
        assertEquals("B",rotor.translate("A"));
        assertEquals("C",rotor.translate("B"));
        assertEquals("D",rotor.translate("C"));
    }
}