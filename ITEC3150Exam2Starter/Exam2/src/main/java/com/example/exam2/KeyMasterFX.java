package com.example.exam2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class KeyMasterFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        pane.setPadding(new Insets(5, 5, 5, 5));
        pane.setAlignment(Pos.CENTER);

        Label label = new Label("-");
        // TODO set font according to spec
        label.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 60));
        pane.getChildren().add(label);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 300, 200);

        //TODO setup key pressed events according ot the spec
        primaryStage.setTitle("Key Master"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show();

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.W) {
                label.setText("Forward");
                label.setTextFill(Color.BLACK);
            }
            if (e.getCode() == KeyCode.A) {
                label.setText("Left");
                label.setTextFill(Color.BLACK);
            }
            if (e.getCode() == KeyCode.D) {
                label.setText("Right");
                label.setTextFill(Color.BLACK);
            }
            if (e.getCode() == KeyCode.S){
                label.setText("Backward");
                label.setTextFill(Color.RED);
            }
        });
    }
}
