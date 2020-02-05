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

    public String forward(String letter) {
        String res = rotor1.translateForward(letter);
        res = rotor2.translateForward(res);
        return rotor3.translateForward(res);
    }

    public String reflect(String output) {
        return reflector.translateForward(output);
    }

    public String backwards(String letter) {
        String res = rotor3.translateBackwards(letter);
        res = rotor2.translateBackwards(res);
        return rotor1.translateBackwards(res);
    }

    public String getCodification(String letter) {
        String output = forward(letter);
        output = reflect(output);
        output = backwards(output);
        rotate();
        System.out.println(output );
        return output;
    }

    private void rotate() {
        if(rotor1.rotate())
            if(rotor2.rotate())
                rotor3.rotate();
    }
}
