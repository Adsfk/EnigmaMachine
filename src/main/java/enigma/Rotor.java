package enigma;

public class Rotor {

    private String type;
    private String input;
    private String output;


    public Rotor(String type) {
        this.type = type;
        Rotor.getRotor(type, this);
    }

    private void setInput(String input) {
        this.input = input;
    }

    private void setOutput(String output) {
        this.output = output;
    }

    public String translate(String letter) {
        int index = input.indexOf(letter);
        String result = String.valueOf(output.charAt(index));
        System.out.println(index);
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
        input = input.substring(1) + input.charAt(0);
        output = output.substring(1) + output.charAt(0);
    }

}
