package persondetails;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class FXMLDocumentBase extends BorderPane {

    protected final FlowPane flowPane;
    protected final Button newButton;
    protected final Button saveButton;
    protected final Button UpdateButton;
    protected final Button deleteButton;
    protected final Button firstButton;
    protected final Button prevButton;
    protected final Button nextButton;
    protected final Button lastButton;
    protected final FlowPane flowPane0;
    protected final Label label;
    protected final TextField textField;
    protected final Label label0;
    protected final TextField textField0;
    protected final Label label1;
    protected final TextField textField1;
    protected final Label label2;
    protected final TextField textField2;
    protected final Label label3;
    protected final TextField textField3;
    protected final Label label4;
    protected final TextField textField4;
    protected boolean flag = false;
    public FXMLDocumentBase() {

        flowPane = new FlowPane();
        newButton = new Button();
        saveButton = new Button();
        UpdateButton = new Button();
        deleteButton = new Button();
        firstButton = new Button();
        prevButton = new Button();
        nextButton = new Button();
        lastButton = new Button();
        flowPane0 = new FlowPane();
        label = new Label();
        textField = new TextField();
        label0 = new Label();
        textField0 = new TextField();
        label1 = new Label();
        textField1 = new TextField();
        label2 = new Label();
        textField2 = new TextField();
        label3 = new Label();
        textField3 = new TextField();
        label4 = new Label();
        textField4 = new TextField();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);
        flowPane.setPrefHeight(80.0);
        flowPane.setPrefWidth(600.0);

        newButton.setMnemonicParsing(false);
        newButton.setPrefHeight(37.0);
        newButton.setPrefWidth(80.0);
        newButton.setText("New");
        newButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    textField.clear();
                    textField0.clear();
                    textField1.clear();
                    textField2.clear();
                    textField3.clear();
                    textField4.clear();
                    flag = !flag; 
                    flowPane.getChildren().clear();
                    flowPane.getChildren().add(flag ? saveButton : newButton);
                    addChildren();
            }
        });

                
        saveButton.setMnemonicParsing(false);
        saveButton.setPrefHeight(37.0);
        saveButton.setPrefWidth(80.0);
        saveButton.setText("Insert");
        saveButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Information user = new Information(Integer.parseInt(textField.getText()), textField0.getText(), textField1.getText(),
                    textField2.getText(), textField3.getText(), textField4.getText());
            try {
                boolean result = DataAccessLayer.insert(user);
                if (result) {
                    System.out.println("Data inserted successfully.");
                    flag = !flag; 
                    flowPane.getChildren().clear();
                    flowPane.getChildren().add(flag ? saveButton : newButton);
                    addChildren();
                }
            } catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Data Insertion Failed");
                    alert.setContentText("An error occurred while inserting data into the database.");
                    alert.showAndWait();
                }
                
            }
        });
        
        
        
        UpdateButton.setMnemonicParsing(false);
        UpdateButton.setPrefHeight(37.0);
        UpdateButton.setPrefWidth(80.0);
        UpdateButton.setText("Update");
        UpdateButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Information user = new Information(Integer.parseInt(textField.getText()), textField0.getText(), textField1.getText(), textField2.getText(), textField3.getText(), textField4.getText());
                try {
                    boolean result = DataAccessLayer.update(user);
                    if (result) {
                    System.out.println("Data updated successfully.");
                    } 
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Data updated Failed");
                    alert.setContentText("An error occurred while updating data into the database.");
                    alert.showAndWait();
                }
                
            }
        });

        deleteButton.setMnemonicParsing(false);
        deleteButton.setPrefHeight(37.0);
        deleteButton.setPrefWidth(80.0);
        deleteButton.setText("Delete");
        deleteButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                try {
                    boolean result = result = DataAccessLayer.delete(Integer.parseInt(textField.getText()));
                    if (result) {
                    System.out.println("Data deleted successfully.");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        firstButton.setMnemonicParsing(false);
        firstButton.setPrefHeight(37.0);
        firstButton.setPrefWidth(80.0);
        firstButton.setText("First");
        firstButton.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        try {
            Information user = DataAccessLayer.first();
            textField.setText(String.valueOf(user.getID()));
            textField0.setText(user.getFirstName());
            textField1.setText(user.getSecondName());
            textField2.setText(user.getLastName());
            textField3.setText(user.getEmail());
            textField4.setText(user.getPhone());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Failed to Retrieve Data");
            alert.setContentText("An error occurred while fetching the data from the database.");
            alert.showAndWait();
        }
    }
});

        prevButton.setMnemonicParsing(false);
        prevButton.setPrefHeight(37.0);
        prevButton.setPrefWidth(80.0);
        prevButton.setText("Previous");
        prevButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Information user = DataAccessLayer.prev();
                    textField.setText(String.valueOf(user.getID()));
                    textField0.setText(user.getFirstName());
                    textField1.setText(user.getSecondName());
                    textField2.setText(user.getLastName());
                    textField3.setText(user.getEmail());
                    textField4.setText(user.getPhone());
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Failed to Retrieve Data");
                    alert.setContentText("An error occurred while fetching the data from the database.");
                    alert.showAndWait();
                }
            }
        });
        
        nextButton.setMnemonicParsing(false);
        nextButton.setPrefHeight(37.0);
        nextButton.setPrefWidth(80.0);
        nextButton.setText("Next");
        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Information user = DataAccessLayer.next();
                    textField.setText(String.valueOf(user.getID()));
                    textField0.setText(user.getFirstName());
                    textField1.setText(user.getSecondName());
                    textField2.setText(user.getLastName());
                    textField3.setText(user.getEmail());
                    textField4.setText(user.getPhone());
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Failed to Retrieve Data");
                    alert.setContentText("An error occurred while fetching the data from the database.");
                    alert.showAndWait();
                }
            }
        });
        lastButton.setMnemonicParsing(false);
        lastButton.setPrefHeight(37.0);
        lastButton.setPrefWidth(80.0);
        lastButton.setText("Last");
        lastButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Information user = DataAccessLayer.last();
                    textField.setText(String.valueOf(user.getID()));
                    textField0.setText(user.getFirstName());
                    textField1.setText(user.getSecondName());
                    textField2.setText(user.getLastName());
                    textField3.setText(user.getEmail());
                    textField4.setText(user.getPhone());
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Failed to Retrieve Data");
                    alert.setContentText("An error occurred while fetching the data from the database.");
                    alert.showAndWait();
                }
            }
        });
        
        setBottom(flowPane);

        BorderPane.setAlignment(flowPane0, javafx.geometry.Pos.CENTER);
        flowPane0.setPrefHeight(200.0);
        flowPane0.setPrefWidth(200.0);

        label.setPrefHeight(48.0);
        label.setPrefWidth(155.0);
        label.setText("             ID");

        textField.setPrefHeight(42.0);
        textField.setPrefWidth(439.0);

        label0.setPrefHeight(48.0);
        label0.setPrefWidth(155.0);
        label0.setText("       First Name");

        textField0.setPrefHeight(42.0);
        textField0.setPrefWidth(439.0);

        label1.setPrefHeight(48.0);
        label1.setPrefWidth(155.0);
        label1.setText("    Middele Name");

        textField1.setPrefHeight(42.0);
        textField1.setPrefWidth(439.0);

        label2.setPrefHeight(48.0);
        label2.setPrefWidth(155.0);
        label2.setText("      Last Name");

        textField2.setPrefHeight(42.0);
        textField2.setPrefWidth(439.0);

        label3.setPrefHeight(48.0);
        label3.setPrefWidth(155.0);
        label3.setText("         Email");

        textField3.setPrefHeight(42.0);
        textField3.setPrefWidth(439.0);

        label4.setPrefHeight(48.0);
        label4.setPrefWidth(155.0);
        label4.setText("         Phone");

        textField4.setPrefHeight(42.0);
        textField4.setPrefWidth(439.0);
        setCenter(flowPane0);

        flowPane.getChildren().add(flag ? saveButton : newButton);
        addChildren();
        

    }
    private void addChildren(){
        flowPane.getChildren().add(UpdateButton);
        flowPane.getChildren().add(deleteButton);
        flowPane.getChildren().add(firstButton);
        flowPane.getChildren().add(prevButton);
        flowPane.getChildren().add(nextButton);
        flowPane.getChildren().add(lastButton);
        flowPane0.getChildren().add(label);
        flowPane0.getChildren().add(textField);
        flowPane0.getChildren().add(label0);
        flowPane0.getChildren().add(textField0);
        flowPane0.getChildren().add(label1);
        flowPane0.getChildren().add(textField1);
        flowPane0.getChildren().add(label2);
        flowPane0.getChildren().add(textField2);
        flowPane0.getChildren().add(label3);
        flowPane0.getChildren().add(textField3);
        flowPane0.getChildren().add(label4);
        flowPane0.getChildren().add(textField4);
    }
}
