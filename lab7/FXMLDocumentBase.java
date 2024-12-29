package scenebuilder;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class FXMLDocumentBase extends BorderPane {

    protected final MenuBar menuBar;
    protected final Menu menuFile;
    protected final MenuItem menuNew;
    protected final MenuItem menuOpenLow;
    protected final MenuItem menuOpenHigh;
    protected final MenuItem menuSaveLow;
    protected final MenuItem menuSaveHigh;
    protected final MenuItem menuExit;
    protected final Menu menuEdit;
    protected final MenuItem menuCut;
    protected final MenuItem menuCopy;
    protected final MenuItem menuPaste;
    protected final MenuItem menuDelete;
    protected final MenuItem menuSelect;
    protected final Menu menuHelp;
    protected final MenuItem menuAbout;
    protected final TextArea textArea;
    TextArea t = new TextArea();
    public FXMLDocumentBase() {
        menuBar = new MenuBar();
        menuFile = new Menu();
        menuNew = new MenuItem();
        menuOpenLow = new MenuItem();
        menuOpenHigh = new MenuItem();
        menuSaveLow = new MenuItem();
        menuSaveHigh = new MenuItem();
        menuExit = new MenuItem();
        menuEdit = new Menu();
        menuCut = new MenuItem();
        menuCopy = new MenuItem();
        menuPaste = new MenuItem();
        menuDelete = new MenuItem();
        menuSelect = new MenuItem();
        menuHelp = new Menu();
        menuAbout = new MenuItem();
        textArea = new TextArea();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(menuBar, javafx.geometry.Pos.CENTER);

        menuFile.setMnemonicParsing(false);
        menuFile.setText("File");

        menuNew.setMnemonicParsing(false);
        menuNew.setText("New");
        menuNew.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
        menuNew.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {  
                textArea.clear();
            }
        });
        
        menuOpenLow.setMnemonicParsing(false);
        menuOpenLow.setText("OpenL");
        menuOpenLow.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
        menuOpenLow.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                FileChooser fc = new FileChooser();
                File file = fc.showOpenDialog(null);
                if(file!=null){
                    try {
                        FileInputStream fis = new FileInputStream(file);
                        int size = fis.available();
                        byte[] b = new byte[size];
                        fis.read(b);
                        textArea.setText(new String(b)); 
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } 
            }
        });
        menuOpenHigh.setMnemonicParsing(false);
        menuOpenHigh.setText("OpenH");
        menuOpenHigh.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {   
                FileChooser fc = new FileChooser();
                File file = fc.showOpenDialog(null);
                if(file!=null){
                    try {
                        FileInputStream fos = new FileInputStream(file);
                        DataInputStream dos = new DataInputStream(fos);
                        String text = dos.readUTF();
                        textArea.setText(text);
                        dos.close();
                        fos.close();
                        } catch (IOException ex) {
                            Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                        }  
                }
            }
        });
        
        menuSaveLow.setMnemonicParsing(false);
        menuSaveLow.setText("SaveL");
        menuSaveLow.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
        menuSaveLow.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {   
                FileChooser fc = new FileChooser();
                File file = fc.showSaveDialog(null);
                if(file!=null){
                    try {
                        FileOutputStream fos = new FileOutputStream(file);
                        byte[] b = textArea.getText().getBytes();
                        fos.write(b);
                        fos.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        
        menuSaveHigh.setMnemonicParsing(false);
        menuSaveHigh.setText("SaveH");
        menuSaveHigh.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {   
                FileChooser fc = new FileChooser();
                File file = fc.showSaveDialog(null);
                if(file!=null){
                    try {
                        FileOutputStream fos = new FileOutputStream(file);
                        DataOutputStream dos = new DataOutputStream(fos);
                        String text = textArea.getText();
                        dos.writeUTF(text);
                        fos.close();
                        } catch (IOException ex) {
                            Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                        }  
                }
            }
        });
        menuExit.setMnemonicParsing(false);
        menuExit.setText("Exit");
        menuExit.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
        menuExit.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        menuEdit.setMnemonicParsing(false);
        menuEdit.setText("Edit");

        menuCut.setMnemonicParsing(false);
        menuCut.setText("Cut");
        menuCut.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if (textArea.getSelectedText().isEmpty()!=true) {
                textArea.cut();
                }
            }
        });

        menuCopy.setMnemonicParsing(false);
        menuCopy.setText("Copy");
        menuCopy.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if (textArea.getSelectedText().isEmpty()!=true) {
                textArea.copy();
            }
            }
        });
        menuPaste.setMnemonicParsing(false);
        menuPaste.setText("Paste");
        menuPaste.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                textArea.paste();
            }
        });
        menuDelete.setMnemonicParsing(false);
        menuDelete.setText("Delete");
        menuDelete.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if (!textArea.getSelectedText().isEmpty()) {
                    textArea.deleteText(textArea.getSelection());
                }
            }
        });
        menuSelect.setMnemonicParsing(false);
        menuSelect.setText("Select All");
        menuSelect.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                textArea.selectAll();
            }
        });
        menuHelp.setMnemonicParsing(false);
        menuHelp.setText("Help");

        menuAbout.setMnemonicParsing(false);
        menuAbout.setText("About");
        setTop(menuBar);
        menuAbout.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setContentText("This is a Lab 7.");
                alert.showAndWait();
            }
        });

        BorderPane.setAlignment(textArea, javafx.geometry.Pos.CENTER);
        textArea.setPrefHeight(200.0);
        textArea.setPrefWidth(200.0);
        setCenter(textArea);

        menuFile.getItems().add(menuNew);
        menuFile.getItems().add(menuOpenLow);
        menuFile.getItems().add(menuOpenHigh);
        menuFile.getItems().add(menuSaveLow);
        menuFile.getItems().add(menuSaveHigh);
        menuFile.getItems().add(menuExit);
        menuBar.getMenus().add(menuFile);
        menuEdit.getItems().add(menuCut);
        menuEdit.getItems().add(menuCopy);
        menuEdit.getItems().add(menuPaste);
        menuEdit.getItems().add(menuDelete);
        menuEdit.getItems().add(menuSelect);
        menuBar.getMenus().add(menuEdit);
        menuHelp.getItems().add(menuAbout);
        menuBar.getMenus().add(menuHelp);

    }
}
