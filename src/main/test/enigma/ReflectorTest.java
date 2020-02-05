package enigma;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReflectorTest {

    @Test
    public void should_translate_reflector() {
        Reflector reflector = new Reflector("REF");
        assertEquals(reflector.translateForward("A"),"V");
        assertEquals(reflector.translateForward("B"),"K");
    }
}