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
        assertEquals("G",rotors.code("A"));
    }

    @Test
    public void should_pass_by_rotors_returning_H() {
        Rotor r0 = new Rotor("0");
        Rotor r1 = new Rotor("1");
        Rotor r2 = new Rotor("2");
        RotorGroup rotors = new RotorGroup(r0,r1,r2,null);
        assertEquals("H",rotors.code("B"));
    }

    @Test
    public void should_pass_by_rotors_returning_C() {
        Rotor r0 = new Rotor("3");
        Rotor r1 = new Rotor("1");
        Rotor r2 = new Rotor("2");
        RotorGroup rotors = new RotorGroup(r0,r1,r2,null);
        assertEquals("E",rotors.code("A"));
    }

    @Test
    public void should_reflect_rotors_output_returning_T() {
        Rotor r0 = new Rotor("0");
        Rotor r1 = new Rotor("1");
        Rotor r2 = new Rotor("2");
        Reflector ref = new Reflector("RT");
        RotorGroup rotors = new RotorGroup(r0,r1,r2,null);
        String output = rotors.code("A");
        assertEquals("T", rotors.reflect(output));
    }
}