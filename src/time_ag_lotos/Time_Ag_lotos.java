/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package time_ag_lotos;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Salah_Mer
 */
public class Time_Ag_lotos extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
       
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/views/FXMLcompilateur.fxml"));
        primaryStage.setTitle("Time AG-Lotos");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.setMaximized(true);
        primaryStage.show();  
      
      //  Scene scene = new Scene(root, 300, 250);
        
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
