package com.example.javafxlistview;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

import static javafx.application.Application.launch;

public class ListViewAssignment extends Application{
    private String[] carList = {"Azure Dream", "Dark Sea Shark", "God Shadow - Snow Sound",
            "Jade Rabbit - Renault", "King of Phantom Sea", "Koenigsegg", "Mysterious Moon", "Night Warrior",
            "Past and Present", "Polar Shadow Star", "Purple Charm - Ice Lord", "Shining Star", "Skywalker Flame Fox",
            "Spirit Fox - Royal Soul", "Time Emissary"};

    // Declare an ImageView array for the national flags of 9 countries
    private ImageView[] ImageViews = {
            new ImageView("file:image/Azure Dream.png"),
            new ImageView("file:image/Dark Sea Shark.png"),
            new ImageView("file:image/God Shadow - Snow Sound.png"),
            new ImageView("file:image/Jade Rabbit - Renault.png"),
            new ImageView("file:image/King of Phantom Sea.png"),
            new ImageView("file:image/Koenigsegg.png"),
            new ImageView("file:image/Mysterious Moon.png"),
            new ImageView("file:image/Night Warrior.png"),
            new ImageView("file:image/Past and Present.png"),
            new ImageView("file:image/Polar Shadow Star.png"),
            new ImageView("file:image/Purple Charm - Ice Lord.png"),
            new ImageView("file:image/Shining Star.png"),
            new ImageView("file:image/Skywalker Flame Fox.png"),
            new ImageView("file:image/Spirit Fox - Royal Soul.png"),
            new ImageView("file:image/Time Emissary.png")
    };

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        ListView<String> lv = new ListView<>
                (FXCollections.observableArrayList(carList));
        lv.setPrefSize(200, 350);
        lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // Create a pane to hold image views
        FlowPane imagePane = new FlowPane(10, 10);
        ScrollPane scrollImage = new ScrollPane();
        scrollImage.setFitToWidth(true);
        scrollImage.setFitToHeight(true);
        scrollImage.setContent(imagePane);

        BorderPane pane = new BorderPane();
        pane.setLeft(new ScrollPane(lv));
        pane.setCenter(scrollImage);


        lv.getSelectionModel().selectedItemProperty().addListener(
                ov -> {
                    imagePane.getChildren().clear();
                    for (Integer i: lv.getSelectionModel().getSelectedIndices()) {
                        imagePane.getChildren().add(ImageViews[i]);
                    }
                });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 700,450);
        primaryStage.setTitle("QQ Speed Cars"); // Set the stage title
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

