package enigma;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotorTest {

    @Test
    public void should_change_letters() {
        Rotor rotor = new Rotor("0");
        assertEquals("B",rotor.translateForward("A"));
        assertEquals("C",rotor.translateForward("B"));
        assertEquals("D",rotor.translateForward("C"));
    }
}