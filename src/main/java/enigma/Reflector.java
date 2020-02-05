package enigma;

public class Reflector extends Rotor{

    public Reflector(String type){
        Rotor.getRotor(type,this);
    }


    public String translate(String letter) {
        return "V";
    }
}
