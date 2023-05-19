package com.example.javafx_assignment;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class HelloMe extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane to hold the image views
        Pane pane = new VBox(20);
        pane.setPadding(new Insets(15, 15, 15, 15));

        // Image image = new Image("image/us.gif");
        Image image = new Image("file:image/icon1.png");

        pane.getChildren().add(new ImageView(image));

        Label label = new Label("Anh Thu Nguyen");
        label.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 20));
        pane.getChildren().add(label);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Hello Me!"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
