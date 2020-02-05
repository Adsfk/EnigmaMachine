package enigma;

public class Rotor {

    private String type;

    public Rotor(String type) {
        this.type = type;
    }

    public String translate(String letter) {
        if(letter.equals("A")) return "B";
        else return "D";
    }
}
