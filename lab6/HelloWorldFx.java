/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworldfx;

import javafx.application.Application;
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
public class HelloWorldFx extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Rectangle r = new Rectangle(0, 0, 400, 400);
        r.setId("rect");
        
        Text t = new Text(10, 50, "Hello World");
        t.setId("text");
        
        Reflection reflection = new Reflection();
        reflection.setFraction(0.7);
        
        t.setEffect(reflection);
        
        
        
        StackPane root = new StackPane();
        root.getChildren().add(r);
        root.getChildren().add(t);
        Scene scene = new Scene(root, 300, 250);
        scene.getStylesheets().add(getClass().getResource("/helloworldfx/Style.css").toExternalForm());


        
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
