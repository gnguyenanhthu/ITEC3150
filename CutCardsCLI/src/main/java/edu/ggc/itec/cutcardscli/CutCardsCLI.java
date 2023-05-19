package edu.ggc.itec.cutcardscli;

import edu.ggc.itec.cutcardscli.GameController;
import edu.ggc.itec.cutcardscli.cardcontent.Card;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Scanner;

import static edu.ggc.itec.cutcardscli.GameController.State.*;

// extending Application is a bit of a hack, see comment in the start method below
public class CutCardsCLI extends Application {

    public static final String TOTAL_WINS_FORMAT = "%s Total Wins : %d";
    public static final String WINNER_FMT = "%s Wins";
    public static final String TIE = "Tie";

    public static void main(String[] args) {

        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the two player card cutter!\n");

        System.out.print("Please enter the name of player #1: ");
        String name1 = scanner.nextLine();
        System.out.print("Please enter the name of player #2: ");
        String name2 = scanner.nextLine();

        GameController game = new GameController(name1, name2);
        System.out.print("Enter [C]ut, [Q]uit: ");

        while (scanner.hasNext()) {
            String response = scanner.nextLine();
            switch (response) {
                case "q":
                    System.exit(0);
                    break;
                case "c":
                    Card draw = game.takeTurn();
                    if (game.state == PLAYER_1_COMPLETED) {
                        System.out.println(name1 + " draws " + draw.toString());
                    } else if (game.state == PLAYER_2_COMPLETED) {
                        System.out.println(name2 + " draws " + draw.toString());
                        if (game.winner != null) {
                            System.out.println(String.format(WINNER_FMT, game.winner.name) + "\n");
                        } else {
                            System.out.println(TIE);
                        }
                        game.state = NOT_STARTED;

                        System.out.println(String.format(TOTAL_WINS_FORMAT, game.p1.name, game.p1.numWins));
                        System.out.println(String.format(TOTAL_WINS_FORMAT, game.p2.name, game.p2.numWins));
                    }
                    System.out.print("Enter [C]ut, [Q]uit: ");
            }
        }*/
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // this is a bit of a hack. in order to use Card objet in a CLI, we need to go through the motions
        // of creating image objects
        /*Pane pane = new VBox(10);
        pane.setPadding(new Insets(5, 5, 5, 5));

        Image image = new Image("file:images/cards/card_back.png");
        GameController game = new GameController("Niecia" , "Stephen");

        ImageView p1CardImage = new ImageView(image);
        pane.getChildren().add(p1CardImage);
        Button btDraw = new Button("Draw");
        btDraw.setOnAction(actionEvent -> {
            Card draw = game.takeTurn();
            System.out.println(draw.toString());
            p1CardImage.setImage(draw.image());
        });
        pane.getChildren().add(btDraw);*/
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(15);
        gridPane.setHgap(15);

        Image image = new Image("file:images/cards/card_back.jpg");
        GameController game = new GameController("Sky" , "Robot");

        ImageView p1CardImage = new ImageView(image);
        ImageView p2CardImage = new ImageView(image);

        Text text1 = new Text("Sky Total Wins: " + game.p1.numWins);
        text1.setFill(Color.DARKBLUE);
        text1.setFont(Font.font("Times New Roman", 20));

        Text text2 = new Text("Robot Total Wins: " + game.p2.numWins);
        text2.setFill(Color.DARKBLUE);
        text2.setFont(Font.font("Times New Roman", 20));

        Text text3 = new Text("Wins");
        text3.setFill(Color.ORANGERED);
        text3.setFont(Font.font("Times New Roman", 20));
        text3.setVisible(false); //hide the last sentence

        Button btDraw = new Button("Sky Cuts");
        btDraw.setDisable(false);
        Button btStartOver = new Button("Start Over");
        btStartOver.setDisable(true);

        //Set up position for every child
        gridPane.add(text1, 0,0);
        gridPane.add(text2, 1,0);
        gridPane.add(p1CardImage, 0,1);
        gridPane.add(p2CardImage, 1,1);
        gridPane.add(btDraw,0,2);
        gridPane.add(btStartOver,1,2);
        gridPane.setHalignment(btStartOver, HPos.RIGHT);
        gridPane.add(text3,0,3);

        btDraw.setOnAction(actionEvent -> {
            /*Card draw = game.takeTurn();
            if (game.state == PLAYER_1_COMPLETED) {
                System.out.println("Sky draws " + draw.toString());
                p1CardImage.setImage(draw.image());
                btDraw.setText("Robot Cuts");
            } else if (game.state == PLAYER_2_COMPLETED) {
                System.out.println("Robot draws " + draw.toString());
                p2CardImage.setImage(draw.image());
                if (game.winner != null) {
                    System.out.println(String.format(WINNER_FMT, game.winner.name) + "\n");
                    text3.setText(String.format(WINNER_FMT, game.winner.name));
                } else {
                    System.out.println(TIE);
                    text3.setText(TIE);
                }
                game.state = NOT_STARTED;

                text1.setText("Sky Total Wins: " + game.p1.numWins);
                text2.setText("Robot Total Wins: " + game.p2.numWins);
                text3.setVisible(true);

                btDraw.setText("Sky Cuts");
                btDraw.setDisable(true);
                btStartOver.setDisable(false);
            }*/
            playingGame(game,p1CardImage,p2CardImage,btDraw,btStartOver,text1,text2,text3);
        });
        btDraw.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.C) {
                playingGame(game,p1CardImage,p2CardImage,btDraw,btStartOver,text1,text2,text3);
            }
        });

        btStartOver.setOnAction(actionEvent -> {
            /*text3.setVisible(false);
            btDraw.setDisable(false);
            btStartOver.setDisable(true);
            p1CardImage.setImage(image);
            p2CardImage.setImage(image);*/
            stateReset(text3,btDraw,btStartOver,image,p1CardImage,p2CardImage);
        });
        btStartOver.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.S) {
                stateReset(text3,btDraw,btStartOver,image,p1CardImage,p2CardImage);
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(gridPane);
        stage.setTitle("Cut Cards!"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage
    }

    public static void playingGame(GameController game, ImageView p1CardImage, ImageView p2CardImage, Button btDraw, Button btStartOver, Text text1, Text text2, Text text3){
        Card draw = game.takeTurn();
        if (game.state == PLAYER_1_COMPLETED) {
            System.out.println("Sky draws " + draw.toString());
            p1CardImage.setImage(draw.image());
            btDraw.setText("Robot Cuts");
        } else if (game.state == PLAYER_2_COMPLETED) {
            System.out.println("Robot draws " + draw.toString());
            p2CardImage.setImage(draw.image());
            if (game.winner != null) {
                System.out.println(String.format(WINNER_FMT, game.winner.name) + "\n");
                text3.setText(String.format(WINNER_FMT, game.winner.name));
            } else {
                System.out.println(TIE);
                text3.setText(TIE);
            }
            game.state = NOT_STARTED;

            text1.setText("Sky Total Wins: " + game.p1.numWins);
            text2.setText("Robot Total Wins: " + game.p2.numWins);
            text3.setVisible(true);

            btDraw.setText("Sky Cuts");
            btDraw.setDisable(true);
            btStartOver.setDisable(false);
        }
    }

    public static void stateReset(Text text3, Button btDraw, Button btStartOver, Image image, ImageView p1CardImage, ImageView p2CardImage){
        text3.setVisible(false);
        btDraw.setDisable(false);
        btStartOver.setDisable(true);
        p1CardImage.setImage(image);
        p2CardImage.setImage(image);
    }


}
