package enigma;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotorTest {

    @Test
    public void should_change_letter_a() {
        Rotor rotor = new Rotor("I");
        assertEquals("B",rotor.translate("A"));
    }


}