package enigma;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class App extends Application {

    private Map<String, Integer> keysMap;
    private StackPane[] keys = new StackPane[36];
    private int lastPane = 99;
    private String keyPressed;

    @Override
    public void start(Stage stage) {
        setKeysMap();
        var root = new VBox();
        root.setStyle("-fx-background-color: black;");
        root.setAlignment(Pos.BOTTOM_CENTER);
        root.setSpacing(20);
        root.setPadding(new Insets(50,50,50,50));

        getRows(root);

        var scene = new Scene(root, 1080, 720, Color.BLACK);

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> setKeyPressedEvent(scene));
        scene.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> setKeyReleasedEvent(scene));

        stage.setScene(scene);
        stage.show();


    }

    private void setKeyReleasedEvent(Scene scene) {
        scene.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
            if (keyPressed != null && keyPressed.equals(key.getCode().getChar())) {
                turnOffLightning(lastPane);
                lastPane = 99;
                keyPressed = null;
            }
        });
    }

    private void setKeyPressedEvent(Scene scene) {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if (keyPressed == null) {
                keyPressed = key.getCode().getChar();
                if (keyPressed.matches("[A-Z]")) {
                    int num = keysMap.get(keyPressed);

                    turnOnLightning(num);
                    lastPane = num;
                }
            }
        });
    }

    private void turnOffLightning(int num) {
        if (lastPane < keys.length) {
            StackPane stackPane = keys[num];
            Label lab = (Label) stackPane.getChildren().get(1);
            Circle circle = (Circle) stackPane.getChildren().get(0);
            circle.setEffect(null);
            lab.setEffect(null);
        }
    }

    private void turnOnLightning(int num) {

        StackPane stackPane = keys[num];
        Label lab = (Label) stackPane.getChildren().get(1);
        Circle circle = (Circle) stackPane.getChildren().get(0);
        Light.Spot light = new Light.Spot();


        //Setting the color of the light
        light.setColor(Color.YELLOW);

        //setting the position of the light
        light.setX(stackPane.getLayoutX());
        light.setY(stackPane.getLayoutY());
        light.setZ(2000);


        //Instantiating the Lighting class
        Lighting lighting = new Lighting();

        //Setting the light source
        lighting.setLight(light);

        //Applying lighting effect to the circle
        circle.setEffect(lighting);
        lab.setEffect(lighting);
    }

    private void setKeysMap() {
        keysMap = new HashMap<>();
        keysMap.put("Q", 0);
        keysMap.put("W", 1);
        keysMap.put("E", 2);
        keysMap.put("R", 3);
        keysMap.put("T", 4);
        keysMap.put("Y", 5);
        keysMap.put("U", 6);
        keysMap.put("I", 7);
        keysMap.put("O", 8);
        keysMap.put("P", 9);

        keysMap.put("A", 10);
        keysMap.put("S", 11);
        keysMap.put("D", 12);
        keysMap.put("F", 13);
        keysMap.put("G", 14);
        keysMap.put("H", 15);
        keysMap.put("J", 16);
        keysMap.put("K", 17);
        keysMap.put("L", 18);

        keysMap.put("Z", 19);
        keysMap.put("X", 20);
        keysMap.put("C", 21);
        keysMap.put("V", 22);
        keysMap.put("B", 23);
        keysMap.put("N", 24);
        keysMap.put("M", 25);
    }


    private void getRows(VBox root) {
        var topRow = getRowBox();
        var midRow = getRowBox();
        var botRow = getRowBox();

        topRow.getChildren().addAll(getTopKey());
        midRow.getChildren().addAll(getMidKey());
        botRow.getChildren().addAll(getBotKey());

        root.getChildren().addAll(topRow, midRow, botRow);
    }

    private StackPane[] getBotKey() {
        keys[19] = getKeyFor("Z");
        keys[20] = getKeyFor("X");
        keys[21] = getKeyFor("C");
        keys[22] = getKeyFor("V");
        keys[23] = getKeyFor("B");
        keys[24] = getKeyFor("N");
        keys[25] = getKeyFor("M");
        return getSubArray(keys, 19, 26);
    }

    private StackPane[] getMidKey() {
        keys[10] = getKeyFor("A");
        keys[11] = getKeyFor("S");
        keys[12] = getKeyFor("D");
        keys[13] = getKeyFor("F");
        keys[14] = getKeyFor("G");
        keys[15] = getKeyFor("H");
        keys[16] = getKeyFor("J");
        keys[17] = getKeyFor("K");
        keys[18] = getKeyFor("L");
        return getSubArray(keys, 10, 19);
    }

    private StackPane[] getTopKey() {
        keys[0] = getKeyFor("Q");
        keys[1] = getKeyFor("W");
        keys[2] = getKeyFor("E");
        keys[3] = getKeyFor("R");
        keys[4] = getKeyFor("T");
        keys[5] = getKeyFor("Y");
        keys[6] = getKeyFor("U");
        keys[7] = getKeyFor("I");
        keys[8] = getKeyFor("O");
        keys[9] = getKeyFor("P");
        return getSubArray(keys, 0, 10);
    }

    private StackPane[] getSubArray(StackPane[] keys, int from, int to) {
        return Arrays.stream(keys, from, to).toArray(StackPane[]::new);
    }

    private StackPane getKeyFor(String letter) {
        var key = new StackPane();
        var circle = new Circle(25, Paint.valueOf("black"));
        var label = new Label();

        label.setText(String.valueOf(letter));
        label.setTextFill(Paint.valueOf("white"));
        circle.setStroke(Paint.valueOf("white"));

        key.getChildren().addAll(circle, label);
        return key;
    }


    private HBox getRowBox() {
        HBox box = new HBox();
        box.setStyle("-fx-background-color: black;");
        box.setAlignment(Pos.CENTER);
        box.setSpacing(20);
        return box;
    }

    public static void main(String[] args) {
        launch();
    }

}