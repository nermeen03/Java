package clientgui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class FXMLDocumentBase extends FlowPane {

    protected final TextArea textArea;
    protected final TextField textField;
    protected final Button button;
    protected Socket server;
    protected DataInputStream ear;
    protected PrintStream mouth;

    public FXMLDocumentBase() {
        try {
            server = new Socket("127.0.0.1", 2);
            ear = new DataInputStream(server.getInputStream());
            mouth = new PrintStream(server.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
        }

        textArea = new TextArea();
        textField = new TextField();
        button = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        textArea.setEditable(false);
        textArea.setPrefHeight(305.0);
        textArea.setPrefWidth(601.0);

        textField.setPrefHeight(96.0);
        textField.setPrefWidth(535.0);

        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    String receivedText = ear.readLine();
                    Platform.runLater(() -> textArea.appendText(receivedText + "\n"));
                }
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        thread.setDaemon(true);
        thread.start();

        button.setMnemonicParsing(false);
        button.setText("Send");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String text = textField.getText();
                textField.clear();
                mouth.println(text);
            }
        });
        
        getChildren().add(textArea);
        getChildren().add(textField);
        getChildren().add(button);
    }
}
