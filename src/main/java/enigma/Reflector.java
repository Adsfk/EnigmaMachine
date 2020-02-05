package enigma;

public class Reflector extends Rotor{

    public Reflector(String type){
        Rotor.getRotor(type,this);
    }


    public String translate(String letter) {
        int index = getInput().indexOf(letter);
        String result = String.valueOf(getOutput().charAt(index));
        return result;
    }
}
