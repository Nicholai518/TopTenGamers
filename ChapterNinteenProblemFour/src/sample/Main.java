package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main extends Application
{


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // Reference to gaming linked list.
        GamingLinkedList topTenGamers = new GamingLinkedList();

        // (Top of menu) Top 10 gamers text
        Text topDescription = new Text("Top 10 Gamers!");
        topDescription.setFont(new Font("Verdana", 20));
        topDescription.setFill(Color.BLACK);

        //  Used to display all the players names and scores
        Label topTenListLabel = new Label();
        Label topTenListDottedLine = new Label("---------------------------");

        VBox topTenVBox = new VBox(10, topDescription, topTenListLabel, topTenListDottedLine);
        topTenVBox.setAlignment(Pos.CENTER);
        topTenVBox.setPadding(new Insets(10));

        // insert controls
        Text insertYourScoreText = new Text("Insert Your Score!");

        // Player Name Controls
        Label playerNameLabel = new Label("Player Name: ");
        TextField playerNameTextField = new TextField();
        HBox playerNameHBox = new HBox(10, playerNameLabel, playerNameTextField);
        playerNameHBox.setAlignment(Pos.CENTER);
        playerNameHBox.setPadding(new Insets(10));

        // Player Score Controls
        Label playerScoreLabel = new Label("Player Score: ");
        TextField playerScoreTextField = new TextField();
        HBox playerScoreHBox = new HBox(10, playerScoreLabel, playerScoreTextField);
        playerScoreHBox.setAlignment(Pos.CENTER);
        playerScoreHBox.setPadding(new Insets(10));

        // Buttons
        Button insertButton = new Button("Insert");

        // Vbox container for insert controls
        VBox insertControlsVBox = new VBox(10, insertYourScoreText, playerNameHBox, playerScoreHBox, insertButton);
        insertControlsVBox.setAlignment(Pos.CENTER);
        insertControlsVBox.setPadding(new Insets(10));

        insertButton.setOnAction(e->
        {
            // Insert player into linked list
            topTenGamers.insert(playerNameTextField.getText(),Integer.parseInt(playerScoreTextField.getText()) );

            // Store new linked list in String and update topTenListLabel
            String topTenPlayers = topTenGamers.toString();

            topTenListLabel.setText(topTenPlayers);

        });

        // Main Menu container containing the top 10 player data and insert controls
        VBox mainMenuVBox = new VBox(10, topTenVBox, insertControlsVBox);
        mainMenuVBox.setAlignment(Pos.CENTER);
        mainMenuVBox.setPadding(new Insets(10));

        // Setting Scene and Stage
        Scene mainMenuScene = new Scene(mainMenuVBox, 500, 500);
        primaryStage.setScene(mainMenuScene);
        primaryStage.setTitle("groupingBy() Collector Example");
        primaryStage.show();


    }


    public static void main(String[] args)
    {
        launch(args);
    }



}
