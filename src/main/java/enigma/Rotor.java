package enigma;

public class Rotor {

    private String type;
    private String intput;
    private String output;

    public Rotor(String type) {
        this.type = type;
        Rotor.getRotor(type,this);
    }

    public void setIntput(String intput) {
        this.intput = intput;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String translate(String letter) {
        if(letter.equals("A")) return "B";
        else return "D";
    }

    private static void getRotor(String type, Rotor rotor) {
        if (type.equals("0")) {
            rotor.setIntput("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            rotor.setOutput("BCDEFGHIJKLMNOPQRSTUVWXYZA");
        }
    }
}
