/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworldfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.LinearGradient;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.Stop;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.effect.Reflection;
import javafx.scene.text.FontWeight;
/**
 *
 * @author nerme
 */
public class HelloWorldFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Stop[] stops = new Stop[] {new Stop(0, Color.BLACK),new Stop(0.5, Color.WHITE),new Stop(1, Color.BLACK) };
        Rectangle r = new Rectangle(0,0,400,400);
        LinearGradient lg = new LinearGradient(255, 0, 255, 400, false, CycleMethod.NO_CYCLE, stops);
        r.setFill(lg);
        
        Text t = new Text(10, 50, "Hello World");
        t.setFill(Color.RED);
        t.setFont(Font.font(null, FontWeight.BOLD, 40));
        
        Reflection reflection = new Reflection();
        reflection.setFraction(0.7);
        
        t.setEffect(reflection);
        
        
        
        StackPane root = new StackPane();
        root.getChildren().add(r);
        root.getChildren().add(t);
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Text reflection");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
