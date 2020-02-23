/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXTextArea;
import cup.example.Parser;
import cup.example.expression.TFormula;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;
import org.apache.commons.lang.StringUtils;

/**
 * FXML Controller class
 *
 * @author Salah_Mer
 */
public class compilateurController implements Initializable {

    /**
     * Initializes the controller class.
     */
    boolean etat=false;
  JFXDialog mLoad;
    @FXML 
    StackPane  root;
    @FXML 
    Button  miPaste;
     @FXML 
    Button  miCut;
      @FXML 
    Button  miCopy;
    @FXML
    TabPane tabpane;
    @FXML
    TextArea console;
    @FXML
    JFXDrawer hist;
    @FXML
    HBox hb;
    @FXML
    BorderPane bp;
    @FXML
      JFXTextArea txt;
    PrintStream standardOut;
    int counter = 1;
     Clipboard systemClipboard = Clipboard.getSystemClipboard();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO  
        systemClipboard = Clipboard.getSystemClipboard();
        hist = new JFXDrawer();
      //  txt.setg
          PrintStream printStream = new PrintStream(new CustomOutputStream(console));
            System.setOut(printStream);
            System.setErr(printStream);
// keeps reference of standard output stream
         standardOut = System.out;
        System.setOut(printStream);
        System.setErr(printStream);
        hist.setDirection(JFXDrawer.DrawerDirection.RIGHT);
        hist.close();
        hist.prefWidth(250);
        Tab newtab = new Tab();
        newtab.setText("+");
        // action event 
        EventHandler<Event> event
                = new EventHandler<Event>() {

            public void handle(Event e) {
                if (newtab.isSelected()) {
                    Tab tab = new Tab("New File" + (int) (counter + 1));
                     TextArea t= new TextArea();
                     tab.setContent(t);
                    counter++;
                    tabpane.getTabs().add(
                            tabpane.getTabs().size() - 1, tab);
                    tabpane.getSelectionModel().select(
                            tabpane.getTabs().size() - 2);
                }
            }
        };
        // set event handler to the tab 
        newtab.setOnSelectionChanged(event);
        //   add newtab 
        tabpane.getTabs().add(newtab);
    }
    @FXML
    private void goToDeveloppez(ActionEvent event) throws IOException {
        if (hist.isClosed()) {
            bp.setRight(hist);
            AnchorPane p = (AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("resources/views/FXMLhist.fxml"));
            hist.setDefaultDrawerSize(250);
            hist.setSidePane(p);
            hist.open();
            System.out.println("open hist");
        } else {
            System.out.println("close hist");
            bp.getChildren().remove(hist);
            hist.close();
            hist.prefWidth(10);
        }
    }
     @FXML
private void newfile(ActionEvent event) throws IOException {
     Tab tab = new Tab("New File" + (int) (counter + 1));
     TextArea t= new TextArea();
                     tab.setContent(t);
                    counter++;
                    tabpane.getTabs().add(
                            tabpane.getTabs().size() - 1, tab);
                    tabpane.getSelectionModel().select(
                            tabpane.getTabs().size() - 2);
}
@FXML
private void openfile(ActionEvent event) throws IOException{
  FileChooser fileChooser = new FileChooser();
File selectedFile = fileChooser.showOpenDialog(null);
 
if (selectedFile != null) {
 
  TextArea t=  (TextArea) tabpane.getSelectionModel().getSelectedItem().getContent();
  System.out.println("File selected: " + selectedFile.getAbsolutePath());
   try (BufferedReader reader = new BufferedReader(new FileReader(new File(selectedFile.getAbsolutePath())))) { 
     String line; 
     while ((line = reader.readLine()) != null) 
     {  System.out.println(line); 
       t.appendText(line+"\n");}
     reader.close();
    } catch (IOException e) { 
     e.printStackTrace(); 
    } 
} 
else {
  //   tabpane.getSelectionModel().getSelectedItem()
  System.out.println("File selection cancelled.");
}  
}
@FXML
private void run(ActionEvent event) throws IOException, Exception{

    TextArea t= (TextArea) tabpane.getSelectionModel().getSelectedItem().getContent();
    if(t.getText().length()>2)
    { 
     System.out.println("Runnig ......");
        FileWriter fw = new FileWriter("input.txt");
      BufferedWriter bw = new BufferedWriter(fw); 
    bw.write(t.getText()); 
    bw.flush(); 
    bw.close(); 
     Parser parser = new Parser();
     parser.parse();
     savehist(t.getText());
    }
    else
    {
        System.err.println("error code ");
    }
  
}
  @FXML
private void DFS(ActionEvent event) throws IOException 
{
    if(!TFormula.IsEmpty())
    {
         System.out.println("running ...... Dijkstra's SPF algorithm");
        TFormula.Dijkstra();
    }
    else
    {
        System.out.println("graph is null");
    }
}
 public void save() throws IOException {     
      TextArea t= (TextArea) tabpane.getSelectionModel().getSelectedItem().getContent();
   JFileChooser chooser = new JFileChooser(); 
    chooser.setCurrentDirectory(new java.io.File("."));
    chooser.setDialogTitle("save file txt");
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    //
    // disable the "All files" option.
    //
    chooser.setAcceptAllFileFilterUsed(false);
    //    
    if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) { 
      System.out.println("getCurrentDirectory(): " 
         +  chooser.getCurrentDirectory());
      System.out.println("getSelectedFile() : " 
         +  chooser.getSelectedFile());
       FileWriter fw = new FileWriter(chooser.getSelectedFile()+"/file.txt");
      BufferedWriter bw = new BufferedWriter(fw); 
    bw.write(t.getText()); 
    bw.flush(); 
    bw.close(); 
      }
    else {
      System.out.println("No Selection ");
      }
     }
public void savehist(String linec) throws IOException
  {
      ArrayList<String> l=new  ArrayList<>();
      l.add(linec);
      try (BufferedReader reader = new BufferedReader(new FileReader(new File("hist.txt")))) { 
     String line; 
     while ((line = reader.readLine()) != null) 
     {  
         l.add(line);
       }
      reader.close();
    } catch (IOException e) { 
     e.printStackTrace(); 
    } 
      
      FileWriter fw = new FileWriter("hist.txt");
      BufferedWriter bw = new BufferedWriter(fw); 
      for(String t:l)    
      {
          bw.write(t);
          bw.newLine();         
      } 
    bw.flush(); 
    bw.close(); 
    fw.close();
  }
private String getSelectedText() {
       TextArea t= (TextArea) tabpane.getSelectionModel().getSelectedItem().getContent();
  TextArea[] tfs = new TextArea[] { console, t};
  for( TextArea tf : tfs ) {
   if( StringUtils.isNotEmpty(tf.getSelectedText() ) ) {
    return tf.getSelectedText();
   }
  }
  return null;
 }
@FXML
 public void copy() {
  String text = getSelectedText();
  ClipboardContent content = new ClipboardContent();
  content.putString(text);
  systemClipboard.setContent(content);
   adjustForClipboardContents();
 }
  private TextArea getFocusedTextField() {
  TextArea t= (TextArea) tabpane.getSelectionModel().getSelectedItem().getContent();
  TextArea[] tfs = new TextArea[] { console, t};
  for( TextArea tf : tfs ) {
   if( tf.isFocused() ) {
    return tf;
   }
  }
  return null;  
 }
  @FXML
   public void cut() {
  
  //TextArea focusedTF = getFocusedTextField();
  TextArea focusedTF =(TextArea) tabpane.getSelectionModel().getSelectedItem().getContent();
  String text = focusedTF.getSelectedText();
  
  ClipboardContent content = new ClipboardContent();
  content.putString(text);
  systemClipboard.setContent(content);
  
  IndexRange range = focusedTF.getSelection();
  String origText = focusedTF.getText();
  String firstPart = StringUtils.substring( origText, 0, range.getStart() );
  String lastPart = StringUtils.substring( origText, range.getEnd(), StringUtils.length(origText) );
  focusedTF.setText( firstPart + lastPart );
  
  focusedTF.positionCaret( range.getStart() );
  adjustForClipboardContents();

 }
   public void paste() {
  if( !systemClipboard.hasContent(DataFormat.PLAIN_TEXT) ) {
   adjustForEmptyClipboard();
   return;
  }
  
  String clipboardText = systemClipboard.getString();
  
  TextArea focusedTF = (TextArea) tabpane.getSelectionModel().getSelectedItem().getContent();
  IndexRange range = focusedTF.getSelection();
  
  String origText = focusedTF.getText();
  
  int endPos = 0;
  String updatedText = "";
  String firstPart = StringUtils.substring( origText, 0, range.getStart() );
  String lastPart = StringUtils.substring( origText, range.getEnd(), StringUtils.length(origText) );

  updatedText = firstPart + clipboardText + lastPart;
  
  if( range.getStart() == range.getEnd() ) {
   endPos = range.getEnd() + StringUtils.length(clipboardText);
  } else {
   endPos = range.getStart() + StringUtils.length(clipboardText);
  }
  
  focusedTF.setText( updatedText );
  focusedTF.positionCaret( endPos );
 }
 private void adjustForEmptyClipboard() {
  miPaste.setDisable(true);  // nothing to paste
 }

 private void adjustForClipboardContents() {
  miPaste.setDisable(false);  // something to paste 
 }
 
 private void adjustForSelection() {
  miCut.setDisable(false);
  miCopy.setDisable(false);
 }

 private void adjustForDeselection() {
  miCut.setDisable(true);
  miCopy.setDisable(true);
 } 
 public void helep() throws IOException
 {
      FXMLLoader fx = new FXMLLoader(getClass().getClassLoader().getResource("resources/views/help.fxml"));
            AnchorPane pane = fx.load();
            etat = true;
            root.getChildren().clear();
            root.toFront();
            root.setVisible(true);
            mLoad = new JFXDialog(root, pane, JFXDialog.DialogTransition.CENTER);
            mLoad.setOnDialogClosed(closeEvent -> {
                if (etat) {
                    etat = false;
                    root.setVisible(false);
                    root.toBack();
                    mLoad.close();
                }
            });
            mLoad.show();
 }
}