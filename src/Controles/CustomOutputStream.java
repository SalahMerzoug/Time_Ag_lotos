/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.io.OutputStream;
import javafx.application.Platform;
import javafx.scene.control.TextArea;
  
/**
 * This class extends from OutputStream to redirect output to a JTextArrea
 * @author www.codejava.net
 *
 */
public class CustomOutputStream extends OutputStream {
    private TextArea textArea;
     
    public CustomOutputStream(TextArea textArea) {
        this.textArea = textArea;
    }
     
    @Override
    public void write(int b) throws IOException {
        // redirects data to the text area
        Platform.runLater(new Runnable() { 
        public void run() {
            textArea.appendText(String.valueOf((char) b));
        }
    });
        // scrolls the text area to the end of data
       // textArea.setCaretPosition(textArea. .getLength());
    }
}