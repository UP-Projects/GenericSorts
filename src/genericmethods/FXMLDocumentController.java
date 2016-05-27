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
    
    @FXML TextArea txtDisplay,txtOrdenado,taOutput; 
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
           
            String cadena;
            while ((cadena = br.readLine()) != null) {
                
                datos.add(cadena.trim());
            }
            for (int i=0; i < datos.size(); i++){
                    //System.out.println(i);
                    System.out.println("Arreglo en la posicion["+i+"]: " + datos.get(i));
                    txtDisplay.appendText("\n"+(i+1)+".-"+datos.get(i));
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
        
   
    @FXML public void orderSorts(){
        
       //insertionSort insercion = new insertionSort();
       quickSortMethod quicksort = new quickSortMethod();
       seleccionMethod seleccion = new seleccionMethod();
       busquedaSecuencial busqueda= new busquedaSecuencial();
       //Burbuja burbuja = new Burbuja();
       
        if(comparar.equals("i")){
            //ORDENAR ENTEROS
                ArrayList<Integer> ordenarI = new ArrayList<Integer>(enteros);                
//                ArrayList<Integer> arrayInsercion = new ArrayList<Integer>(insercion.ordenar(ordenarI));
//                System.out.println("insercion"+ arrayInsercion);
//                System.out.println("Tiempo en nanosegundos: "+insercion.tiempo+ " e iteraciones: "+insercion.iteraciones);                
                ArrayList<Integer> arrayQuicksort = new ArrayList<Integer>(quicksort.quickSort(ordenarI, 0, ordenarI.size()-1));
                System.out.println("Quicksort"+arrayQuicksort);
                taOutput.appendText("Quicksort\n"+arrayQuicksort);
                taOutput.appendText("\nTiempo en nanosegundos: "+quicksort.tTime+ " e iteraciones: "+quicksort.iteraciones);
                System.out.println("Tiempo en nanosegundos: "+quicksort.tTime+ " e iteraciones: "+quicksort.iteraciones);                
                ArrayList<Integer> arraySeleccion = new ArrayList<Integer>(seleccion.selectionSort(ordenarI));
                System.out.println("\nSeleccion\n"+arraySeleccion);
                taOutput.appendText("\nSeleccion\n"+arraySeleccion);
                taOutput.appendText("\nTiempo en nanosegundos: "+seleccion.tTime+ " e iteraciones: "+seleccion.iteraciones);
                System.out.println("Tiempo en nanosegundos: "+seleccion.tTime+ " e iteraciones: "+seleccion.iteraciones);                
//                ArrayList<Integer> arrayBurbuja = new ArrayList<Integer>(burbuja.burbuja(ordenarI));
//                System.out.println("Burbuja"+arrayBurbuja);
//                System.out.println("Tiempo en nanosegundos: "+burbuja.tiempo+" e iteraciones: "+burbuja.iteraciones);
                System.out.println("Busqueda secuencial "+busqueda.busquedaSecuencial(arrayQuicksort,Integer.parseInt(tfDato.getText()))+" con un tiempo de: "+busqueda.tTime+ " nanosegundos y "+busqueda.iteraciones+" iteraciones");
                taOutput.appendText("\nBusqueda secuencial posicion "+(busqueda.busquedaSecuencial(arrayQuicksort,Integer.parseInt(tfDato.getText()))+1)+" con un tiempo de: "+busqueda.tTime+ " nanosegundos y "+busqueda.iteraciones+" iteraciones");
                txtDisplay.setText("");
                for (int i=0; i < enteros.size(); i++){
                    txtDisplay.appendText("\n"+(i+1)+".-"+arrayQuicksort.get(i));
            } 
        
        }
        if(comparar.equals("f")){
            //ORDENAR FLOTANTES
                ArrayList<Float> ordenarI = new ArrayList<Float>(flotantes);                
//                ArrayList<Integer> arrayInsercion = new ArrayList<Integer>(insercion.ordenar(ordenarI));
//                System.out.println("insercion"+ arrayInsercion);
//                System.out.println("Tiempo en nanosegundos: "+insercion.tiempo+ " e iteraciones: "+insercion.iteraciones);                
                ArrayList<Float> arrayQuicksort = new ArrayList<Float>(quicksort.quickSort(ordenarI, 0, ordenarI.size()-1));
                System.out.println("Quicksort"+arrayQuicksort);
                taOutput.appendText("Quicksort\n"+arrayQuicksort);
                taOutput.appendText("\nTiempo en nanosegundos: "+quicksort.tTime+ " e iteraciones: "+quicksort.iteraciones);
                System.out.println("Tiempo en nanosegundos: "+quicksort.tTime+ " e iteraciones: "+quicksort.iteraciones);                
                ArrayList<Float> arraySeleccion = new ArrayList<Float>(seleccion.selectionSort(ordenarI));
                System.out.println("Seleccion"+arraySeleccion);
                System.out.println("Tiempo en nanosegundos: "+seleccion.tTime+ " e iteraciones: "+seleccion.iteraciones);
                taOutput.appendText("\nSeleccion\n"+arraySeleccion);
                taOutput.appendText("\nTiempo en nanosegundos: "+seleccion.tTime+ " e iteraciones: "+seleccion.iteraciones);                
//                ArrayList<Integer> arrayBurbuja = new ArrayList<Integer>(burbuja.burbuja(ordenarI));
//                System.out.println("Burbuja"+arrayBurbuja);
//                System.out.println("Tiempo en nanosegundos: "+burbuja.tiempo+" e iteraciones: "+burbuja.iteraciones);
                 taOutput.appendText("\nBusqueda secuencial posicion"+(busqueda.busquedaSecuencial(arrayQuicksort,Float.valueOf(tfDato.getText()))+1)+" con un tiempo de: "+busqueda.tTime+ " nanosegundos y "+busqueda.iteraciones+" iteraciones");
                 txtDisplay.setText("");
                 for (int i=0; i < enteros.size(); i++){
                    txtDisplay.appendText("\n"+(i+1)+".-"+arrayQuicksort.get(i));
            } 
        }
        if(comparar.equals("C")){
            //ORDENAR CARACTERES
                ArrayList<Character> ordenarI = new ArrayList<Character>(caracteres);                
//                ArrayList<Integer> arrayInsercion = new ArrayList<Integer>(insercion.ordenar(ordenarI));
//                System.out.println("insercion"+ arrayInsercion);
//                System.out.println("Tiempo en nanosegundos: "+insercion.tiempo+ " e iteraciones: "+insercion.iteraciones);                
                ArrayList<Character> arrayQuicksort = new ArrayList<Character>(quicksort.quickSort(caracteres, 0, caracteres.size()-1));
                System.out.println("Quicksort"+arrayQuicksort);
                System.out.println("Tiempo en nanosegundos: "+quicksort.tTime+ " e iteraciones: "+quicksort.iteraciones);   
                taOutput.appendText("Quicksort\n"+arrayQuicksort);
                taOutput.appendText("\nTiempo en nanosegundos: "+quicksort.tTime+ " e iteraciones: "+quicksort.iteraciones);
                ArrayList<Character> arraySeleccion = new ArrayList<Character>(seleccion.selectionSort(caracteres));
                System.out.println("Seleccion"+arraySeleccion);
                System.out.println("Tiempo en nanosegundos: "+seleccion.tTime+ " e iteraciones: "+seleccion.iteraciones);  
                taOutput.appendText("\nSeleccion\n"+arraySeleccion);
                taOutput.appendText("\nTiempo en nanosegundos: "+seleccion.tTime+ " e iteraciones: "+seleccion.iteraciones);  
//                ArrayList<Integer> arrayBurbuja = new ArrayList<Integer>(burbuja.burbuja(ordenarI));
//                System.out.println("Burbuja"+arrayBurbuja);
//                System.out.println("Tiempo en nanosegundos: "+burbuja.tiempo+" e iteraciones: "+burbuja.iteraciones);

                  String dato=tfDato.getText();
                  char cadena[];
                  cadena=dato.toCharArray();
                  taOutput.appendText("\nBusqueda secuencial posicion"+(busqueda.busquedaSecuencial(arrayQuicksort,cadena[0])+1)+" con un tiempo de: "+busqueda.tTime+ " nanosegundos y "+busqueda.iteraciones+" iteraciones");
                  txtDisplay.setText("");
                  for(int j=0; j < ordenarI.size(); j++){
                      
                    txtDisplay.appendText("\n"+(j+1)+".-"+arrayQuicksort.get(j));
                } 
                  
                  
        }

    }    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
