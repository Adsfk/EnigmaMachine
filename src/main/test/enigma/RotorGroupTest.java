package enigma;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotorGroupTest {
    @Test
    public void should_pass_by_rotors_returning_G() {
        Rotor r0 = new Rotor("0");
        Rotor r1 = new Rotor("1");
        Rotor r2 = new Rotor("2");
        RotorGroup rotors = new RotorGroup(r0,r1,r2,null);
        assertEquals(rotors.code("A"),"G");
    }

    @Test
    public void should_pass_by_rotors_returning_H() {
        Rotor r0 = new Rotor("0");
        Rotor r1 = new Rotor("1");
        Rotor r2 = new Rotor("2");
        RotorGroup rotors = new RotorGroup(r0,r1,r2,null);
        assertEquals(rotors.code("B"),"H");
    }

}