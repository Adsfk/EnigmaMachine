package enigma;

public class Rotor {

    private String type;
    private String input;
    private String output;

    public Rotor(){
        setRotors("0");
    }

    public Rotor(String type) {
        this.type = type;
        setRotors(type);
    }

    private void setInput(String input) {
        this.input = input;
    }

    private void setOutput(String output) {
        this.output = output;
    }

    public String translate(String letter) {
        if(input==null) setRotors("0");
        String result =String.valueOf(output.charAt(input.indexOf(letter)));
        this.rotate();
        return result;
    }

    private static void getRotor(String type, Rotor rotor) {
        if (type.equals("0")) {
            rotor.setInput("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            rotor.setOutput("BCDEFGHIJKLMNOPQRSTUVWXYZA");
        }
    }

    public void rotate() {

    }

    public void setRotors(String s) {
        Rotor.getRotor(s,this);
    }
}
