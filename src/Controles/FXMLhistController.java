/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Salah_Mer
 */
public class FXMLhistController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TextArea console;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         try (BufferedReader reader = new BufferedReader(new FileReader(new File("hist.txt")))) { 
     String line; 
     while ((line = reader.readLine()) != null) 
     {  
       console.appendText(line+"\n");}
      reader.close();
    } catch (IOException e) { 
     e.printStackTrace(); 
    } 
    }    
    
}
