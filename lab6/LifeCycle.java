/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifecycle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author nerme
 */
public class LifeCycle extends Application {
    
    public LifeCycle(){
        String name = Thread.currentThread().getName();
        System.out.println("constructor is "+name);
    }
    
    @Override
    public void init()
          throws Exception{
            String name = Thread.currentThread().getName();
            System.out.println("init is "+name);
    }
    @Override
    public void start(Stage primaryStage) {
        String name = Thread.currentThread().getName();
        System.out.println("start is "+name);
        
        StackPane root = new StackPane();        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Life cycle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void stop()
          throws Exception{
        String name = Thread.currentThread().getName();
        System.out.println("stop is "+name);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
