package enigma;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReflectorTest {

    @Test
    public void should_translate_reflector() {
        Reflector reflector = new Reflector("REF");
        assertEquals(reflector.translate("A"),"V");
        assertEquals(reflector.translate("B"),"K");
    }
}