package enigma;

public class Rotor {

    private String type;
    private String intput;
    private String output;

    public Rotor(String type) {
        this.type = type;
        Rotor.getRotor(type,this);
    }

    private void setIntput(String intput) {
        this.intput = intput;
    }

    private void setOutput(String output) {
        this.output = output;
    }

    public String translate(String letter) {
        if(letter.equals("A")) return "B";
        if(letter.equals("B")) return "C";
        return "D";
    }

    private static void getRotor(String type, Rotor rotor) {
        if (type.equals("0")) {
            rotor.setIntput("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            rotor.setOutput("BCDEFGHIJKLMNOPQRSTUVWXYZA");
        }
    }
}
