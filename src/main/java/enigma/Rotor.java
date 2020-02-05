package enigma;

public class Rotor {

    private String type;
    private String input;
    private String output;
    private int position = 0;

    public Rotor(){}

    public Rotor(String type) {
        this.type = type;
        Rotor.getRotor(type, this);
    }

    public String translate(int letterIndex, String inString, String outString) {
        String result = String.valueOf(outString.charAt(letterIndex));
        return result;
    }

    protected static void getRotor(String type, Rotor rotor) {
        if (type.equals("0")) {
            rotor.setInput("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            rotor.setOutput("BCDEFGHIJKLMNOPQRSTUVWXYZA");
        }if (type.equals("1")) {
            rotor.setInput("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            rotor.setOutput("CDEFGHIJKLMNOPQRSTUVWXYZAB");
        }if (type.equals("2")) {
            rotor.setInput("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            rotor.setOutput("DEFGHIJKLMNOPQRSTUVWXYZABC");
        }if (type.equals("3")) {
            rotor.setInput("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            rotor.setOutput("ZEFGHIJKLMNOPQRSTUVWXYDCBA");
        }if (type.equals("RT")) {
            rotor.setInput("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            rotor.setOutput("ZYXWVUTSRQPONMLKJIHGFEDCBA");
        }


        if (type.equals("CDI")) {
            rotor.setInput("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            rotor.setOutput("PEZUOHXSCVFMTBGLRINQJWAYDK");
        }
        if (type.equals("CDII")) {
            rotor.setInput("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            rotor.setOutput("ZOUESYDKFWPCIQXHMVBLGNJRAT");
        }
        if (type.equals("CDIII")) {
            rotor.setInput("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            rotor.setOutput("EHRVXGAOBQUSIMZFLYNWKTPDJC");
        }
        if (type.equals("CDIV")) {
            rotor.setInput("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            rotor.setOutput("IMETCGFRAYSQBZXWLHKDVUPOJN");
        }
        if (type.equals("CDV")) {
            rotor.setInput("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            rotor.setOutput("QWERTZUIOASDFGHJKPYXCVBNML");
        }
        if (type.equals("REF")){
            rotor.setInput("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            rotor.setOutput("VKWRGIETFZBUSPQNODMHLACYXJ");
        }
    }

    public boolean rotate() {
        position = (position+1)%25;
        return position == 0;
    }

    private void setInput(String input) {
        this.input = input;
    }

    private void setOutput(String output) {
        this.output = output;
    }

    protected String getInput(){
        return input;
    }

    protected String getOutput(){
        return output;
    }

    public String translateBackwards(String letter) {
        return translate((output.indexOf(letter))%26,output,input);
    }

    public String translateForward(String letter) {
        return translate((input.indexOf(letter)+position)%26,input,output);
    }
}
