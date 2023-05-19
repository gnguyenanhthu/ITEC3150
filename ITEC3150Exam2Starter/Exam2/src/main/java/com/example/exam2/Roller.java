package com.example.exam2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Roller extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox box = new VBox(10);
        box.setPadding(new Insets(5, 5, 5, 5));
        box.setAlignment(Pos.CENTER);

        Label lblResult = new Label("#");
        Button btTurn = new Button("Roll");
        // TODO add a event handler for btRoll clicks
        // TODO set the application title
        // TODO set the app's window size

        btTurn.setOnAction(actionEvent -> {
            long roll = Math.round(10 * Math.random()) + 2;
            lblResult.setText(String.valueOf(roll));
        });


        lblResult.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 35));

        box.getChildren().addAll(lblResult, btTurn);

        // Create a scene and place it in the stage
        Scene scene = new Scene(box,200,100);
        primaryStage.setTitle("Feeling Lucky!");
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}
