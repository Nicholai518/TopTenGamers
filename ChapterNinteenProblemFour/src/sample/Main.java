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
import java.util.Scanner;

public class Main extends Application
{


    @Override
    public void start(Stage stage) throws Exception
    {
        // Reference to linked list.
        RSortLinkedList ll = new RSortLinkedList();
        //LinkedList1 ll = new LinkedList1();

        // listView shows current list elements.
        TextArea listView = new TextArea();
        listView.setEditable(false);

        // Input for user command.
        TextField cmdTextField = new TextField();
        cmdTextField.setPrefColumnCount(5);

        // Displays result of list method that was
        // invoked by the user command.
        TextField resultTextField = new TextField();
        resultTextField.setPrefColumnCount(5);
        resultTextField.setEditable(false);

        // Attach event handler to cmdTextField
        EventHandler<ActionEvent> handler =
                new CommandHandler(ll, listView, resultTextField);
        cmdTextField.setOnAction(handler);

        // HBox to contain command result label and text field. Commenting out for time being. Not needed.
//        HBox hBox1 = new HBox(10);
//        Label resultLabel = new Label("Command Result");
//        hBox1.getChildren().addAll(resultLabel, resultTextField);

        // HBox to contain label and text field for command input.
        HBox hBox2 = new HBox(10);
        Label cmdLabel = new Label("Command: ");
        hBox2.getChildren().addAll(cmdLabel, cmdTextField);

        // VBox to contain the user interface components
        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(listView, hBox2);

        // Set up the scene and show the stage.
        stage.setScene(new Scene(vBox));
        stage.setTitle("Top 10 Players");
        stage.show();
    }


    public static void main(String[] args)
    {
        launch(args);
    }


    // Event Handler class for the command text field.
    class CommandHandler implements EventHandler<ActionEvent>
    {
        // Fields to hold information passed to the constructor.
        private final RSortLinkedList ll;
        private final TextField resultTextField;
        private final TextArea listView;

        CommandHandler(RSortLinkedList lList, TextArea lView,
                       TextField rTfield)
        {
            ll = lList;
            resultTextField = rTfield;
            listView = lView;
        }

        @Override
        public void handle(ActionEvent event)
        {
            // Get the command from the command textfield.
            TextField cmdTextField = (TextField) event.getTarget();
            String cmdText = cmdTextField.getText();

            // Use a scanner to read the name of the linked list
            // method and do a switch on it.
            Scanner sc = new Scanner(cmdText);
            String cmd = sc.next();
            switch (cmd)
            {
                case "add":
                    if (sc.hasNextInt())
                    {
                        // add index element
                        int index = sc.nextInt();
                        String element = sc.next();
                        ll.add(index, element);
                    }
                    else
                    {
                        // add element
                        String element = sc.next();
                        ll.add(element);
                    }
                    listView.setText(ll.toString());
                    return;
                case "remove":
                    if (sc.hasNextInt())
                    {
                        // remove index
                        int index = sc.nextInt();
                        String res = ll.remove(index);
                        resultTextField.setText(res);
                    }
                    else
                    {
                        // remove element
                        String element = sc.next();
                        boolean res = ll.remove(element);
                        String resText = String.valueOf(res);
                        resultTextField.setText(resText);
                    }
                    listView.setText(ll.toString());
                    return;
                case "isempty":
                    String resText = String.valueOf(ll.isEmpty());
                    resultTextField.setText(resText);
                    return;
                case "size":
                    String resText1 = String.valueOf(ll.size());
                    resultTextField.setText(resText1);
                    return;

                case "sort":
                    if (cmd.equalsIgnoreCase("sort"))
                    {
                        ll.sort();
                        listView.setText(ll.toString());
                        return;
                    }

                case "reverse":
                    if (cmd.equalsIgnoreCase("reverse"))
                    {
                        ll.reverse();
                        listView.setText(ll.toString());
                        return;
                    }

                case "insert":
                    if(cmd.equalsIgnoreCase("insert"))
                    {

                    }
            }
        }
    }
}
