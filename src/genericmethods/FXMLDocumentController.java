/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericmethods;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Kevin
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML TextArea txtDisplay,txtOrdenado; 
    @FXML Label labelTDato, labelOutput, labelSegundos;
    @FXML TextField tfDato;
    @FXML Pane paneBusqueda;
    String tipoDato, comparar;
    ArrayList<String> datos = new ArrayList<>();
    ArrayList<Integer> enteros=new ArrayList<Integer>();
    ArrayList<Float> flotantes=new ArrayList<Float>();
    ArrayList<Character> caracteres=new ArrayList<Character>();
    
    @FXML
    private Label label;
    
        @FXML   public void openFile(){
        txtDisplay.setText("");
        Stage stage1 = new Stage();
        FileChooser fc = new FileChooser();
        fc.setTitle("Abir archivo");
        String ruta = "C:\\Users\\Kevin\\Documents\\NetBeansProjects\\GenericMethods";
       // String ruta = "C:\\Users\\Arreola\\Google Drive\\Drive\\Politécnica\\C6\\Estructuras de Datos Avanzadas\\Programas\\Metodos-de-Ordenacion-y-Busqueda";
        fc.setInitialDirectory(new File(ruta));
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("TXT Files","*.txt");
        fc.getExtensionFilters().add(extensionFilter);
        fc.setInitialFileName("");
        File file = fc.showOpenDialog(stage1);
        int auxiliar=0;
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            auxiliar++;
            String cadena;
            while ((cadena = br.readLine()) != null) {
                txtDisplay.setText(txtDisplay.getText()+cadena+"\n");
                datos.add(cadena.trim());
            }
            for (int i=0; i < datos.size(); i++){
                    //System.out.println(i);
                    System.out.println("Arreglo en la posicion["+i+"]: " + datos.get(i));
            } 
            

        } catch (IOException e) {
                e.printStackTrace();
        }
        filtrarDato();
        
    }
        
        
        @FXML public void filtrarDato(){
        comparar = datos.get(0);
        System.out.println("Tipo de Dato: "+comparar);
        
        if(comparar.equals("i")){
            System.out.println("Entero");
            for(int i=2;i<datos.size();i++){
                //System.out.println(""+datos.get(i));
                enteros.add(Integer.parseInt(datos.get(i)));
            }
                
        }
        if(comparar.equals("f")){
            System.out.println("Flotante");
            for(int i=2;i<datos.size();i++){
                //System.out.println(""+datos.get(i));
                flotantes.add(Float.parseFloat(datos.get(i)));
            }
            
        }
        if(comparar.equals("C")){
            System.out.println("Caracter");
            for(int i=2;i<datos.size();i++){
                String string = datos.get(i);
                caracteres.add(string.charAt(0));
            }
            
        }
    }
        
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
