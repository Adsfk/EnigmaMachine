package enigma;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotorGroupTest {
    @Test
    public void should_pass_by_rotors() {
        Rotor r0 = new Rotor("0");
        Rotor r1 = new Rotor("1");
        Rotor r2 = new Rotor("2");
        RotorGroup rotors = new RotorGroup(r0,r1,r2,null);
        assertEquals("G",rotors.forward("A"));
        assertEquals("H",rotors.forward("B"));
    }


    @Test
    public void should_pass_by_rotors_returning_C() {
        Rotor r0 = new Rotor("3");
        Rotor r1 = new Rotor("1");
        Rotor r2 = new Rotor("2");
        RotorGroup rotors = new RotorGroup(r0,r1,r2,null);
        assertEquals("E",rotors.forward("A"));
    }

    @Test
    public void should_reflect_rotors_output_returning_T() {
        Rotor r0 = new Rotor("0");
        Rotor r1 = new Rotor("1");
        Rotor r2 = new Rotor("2");
        Reflector ref = new Reflector("RT");
        RotorGroup rotors = new RotorGroup(r0,r1,r2,ref);
        String output = rotors.forward("A");
        assertEquals("T", rotors.reflect(output));
    }

    @Test
    public void should_pass_by_rotors_backwards_returning_N(){
        Rotor r0 = new Rotor("0");
        Rotor r1 = new Rotor("1");
        Rotor r2 = new Rotor("2");
        Reflector ref = new Reflector("RT");
        RotorGroup rotors = new RotorGroup(r0,r1,r2,ref);
        String output = rotors.forward("A");
        output = rotors.reflect(output);
        assertEquals("N", rotors.backwards(output));
    }

    @Test
    public void should_pass_by_rotors_backwards_returning_M(){
        Rotor r0 = new Rotor("0");
        Rotor r1 = new Rotor("1");
        Rotor r2 = new Rotor("2");
        Reflector ref = new Reflector("RT");
        RotorGroup rotors = new RotorGroup(r0,r1,r2,ref);
        String output = rotors.forward("B");
        output = rotors.reflect(output);
        assertEquals("M", rotors.backwards(output));
    }
}