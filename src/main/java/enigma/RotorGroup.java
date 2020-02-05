package enigma;

public class RotorGroup {

    private final Rotor rotor1;
    private final Rotor rotor2;
    private final Rotor rotor3;
    private final Reflector reflector;

    public RotorGroup(Rotor rotor1, Rotor rotor2, Rotor rotor3, Reflector reflector){
        this.rotor1 = rotor1;
        this.rotor2 = rotor2;
        this.rotor3 = rotor3;
        this.reflector = reflector;
    }

    public String code(String letter) {
        return null;
    }
}
