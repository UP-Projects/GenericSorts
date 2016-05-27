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
    String position;
    int finalPosition, finalPbs;
            
    @FXML    private Label label;
    
        @FXML   public void openFile(){
        txtDisplay.setText("");
        comparar="";
        Stage stage1 = new Stage();
        FileChooser fc = new FileChooser();
        fc.setTitle("Abir archivo");
        //String ruta = "C:\\Users\\Kevin\\Documents\\NetBeansProjects\\GenericMethods";
        String ruta = "C:\\Users\\Arreola\\Google Drive\\Drive\\Politécnica\\C6\\Estructuras de Datos Avanzadas\\Repositorios Remotos\\GenericSorts";
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
            txtDisplay.setText("Posicion | Valor");
            for (int i=0; i < datos.size(); i++){
                    //System.out.println(i);
                    //System.out.println("Arreglo en la posicion["+i+"]: " + datos.get(i));
                    txtDisplay.appendText("\n["+(i+1)+"] : \t"+datos.get(i));
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
        taOutput.setText("");
        insertionSort insertion = new insertionSort();
        quickSortMethod quicksort = new quickSortMethod();
        seleccionMethod seleccion = new seleccionMethod();
        busquedaSecuencial busqueda= new busquedaSecuencial();
        binarySearch binSearch = new binarySearch();
        bubbleSort bubble = new bubbleSort();
       
       
        if(comparar.equals("i")){ //Ordenacion de enteros
            ArrayList<Integer> ordenarI = new ArrayList<Integer>(enteros);
            ArrayList<Integer> orderI = new ArrayList<Integer>(enteros);
            ArrayList<Integer> burbujaI = new ArrayList<Integer>(enteros);
            
            //QuickSort
            ArrayList<Integer> arrayQuicksort = new ArrayList<Integer>(quicksort.quickSort(ordenarI, 0, ordenarI.size()-1));
            taOutput.appendText("\n = = = = = = = = = = = = = = = =\n Quicksort:\n"+arrayQuicksort);
            taOutput.appendText("\nTiempo en nanosegundos: "+quicksort.tTime+ "\n Numero de iteraciones: "+quicksort.iteraciones+"\n");
            
            
            //SelectionSort
            ArrayList<Integer> arraySeleccion = new ArrayList<Integer>(seleccion.selectionSort(ordenarI));
            taOutput.appendText("\n  = = = = = = = = = = = = = = = =\n Selección:\n"+arraySeleccion);
            taOutput.appendText("\nTiempo en nanosegundos: "+seleccion.tTime+ "\n Numero de iteraciones: "+seleccion.iteraciones+"\n");
            
            
            //Insertion Sort
            ArrayList<Integer> arrayInsertion = new ArrayList<Integer>(insertion.insertionSort(orderI));
            taOutput.appendText("\n  = = = = = = = = = = = = = = = =\n Inserción:\n"+arrayInsertion);
            taOutput.appendText("\nTiempo en nanosegundos: "+insertion.tTime+ "\n Numero de iteraciones: "+insertion.iteraciones+"\n");
            
            //BubbleSort
            ArrayList<Integer> arrayBurbuja = new ArrayList<Integer>(bubble.burbuja(burbujaI));
            taOutput.appendText("\n  = = = = = = = = = = = = = = = =\n Burbuja:\n"+arrayInsertion);
            taOutput.appendText("\nTiempo en nanosegundos: "+bubble.tTime+ "\n Numero de iteraciones: "+bubble.iteraciones+"\n");
            
            finalPosition = busqueda.busquedaSecuencial(arrayQuicksort,Integer.parseInt(tfDato.getText()))+1;
            finalPbs = binSearch.buscar(arrayQuicksort, Integer.parseInt(tfDato.getText()))+1;
            if((finalPosition > 0) && (finalPbs > 0)){
                position = Integer.toString(finalPosition);
            }else{
                position = "No se encontro la busqueda";
            }
            
            //Busqueda Secuencial
            System.out.println("Busqueda secuencial "+busqueda.busquedaSecuencial(arrayQuicksort,Integer.parseInt(tfDato.getText()))+" con un tiempo de: "+busqueda.tTime+ " nanosegundos y "+busqueda.iteraciones+" iteraciones");
            taOutput.appendText("\n  = = = = = = = = = = = = = = = =\n Busqueda secuencial:\n "
                    + "Posicion: "+ position +"\n "
                    + "Tiempo: "+busqueda.tTime+ " nanosegundos \n"
                    + "Iteraciones: "+busqueda.iteraciones+" iteraciones\n");
            
            //Busqueda Binaria
            System.out.println("Busqueda binaria "+binSearch.buscar(arrayQuicksort,Integer.parseInt(tfDato.getText()))+""
                    + " con un tiempo de: "+binSearch.tTime+ " nanosegundos y "+binSearch.iteraciones+" iteraciones");
            taOutput.appendText("\n  = = = = = = = = = = = = = = = =\n Busqueda Binaria:\n "
                    + "Posicion: "+ position +"\n "
                    + "Tiempo: "+binSearch.tTime+ " nanosegundos \n"
                    + "Iteraciones: "+ binSearch.iteraciones+" iteraciones\n");
            
            txtDisplay.setText("");
            for (int i=0; i < enteros.size(); i++){
                txtDisplay.appendText("\n["+(i+1)+"] : \t"+arrayQuicksort.get(i));
            } 
        }
        
        if(comparar.equals("f")){ //Ordenacion de flotantes
            ArrayList<Float> ordenarI = new ArrayList<Float>(flotantes);                
            ArrayList<Float> orderInsertion = new ArrayList<Float>(flotantes);
            ArrayList<Float> orderB = new ArrayList<Float>(flotantes);
            //ArrayList<Integer> arrayInsercion = new ArrayList<Integer>(insercion.ordenar(ordenarI));
            //System.out.println("insercion"+ arrayInsercion);
            //System.out.println("Tiempo en nanosegundos: "+insercion.tiempo+ " e iteraciones: "+insercion.iteraciones);  
            
            ArrayList<Float> arrayQuicksort = new ArrayList<Float>(quicksort.quickSort(ordenarI, 0, ordenarI.size()-1));
            System.out.println("Quicksort"+arrayQuicksort);
            taOutput.appendText("\n = = = = = = = = = = = = = = = =\n Quicksort:\n"+arrayQuicksort);
            taOutput.appendText("\nTiempo en nanosegundos: "+quicksort.tTime+ "\n Numero de iteraciones: "+quicksort.iteraciones+"\n");
            System.out.println("Tiempo en nanosegundos: "+quicksort.tTime+ " e iteraciones: "+quicksort.iteraciones);                
            
            ArrayList<Float> arraySeleccion = new ArrayList<Float>(seleccion.selectionSort(ordenarI));
            System.out.println("Seleccion"+arraySeleccion);
            System.out.println("Tiempo en nanosegundos: "+seleccion.tTime+ " e iteraciones: "+seleccion.iteraciones);
            taOutput.appendText("\n  = = = = = = = = = = = = = = = =\n Seleccion:\n"+arraySeleccion);
            taOutput.appendText("\nTiempo en nanosegundos: "+seleccion.tTime+ "\n Numero de iteraciones: "+seleccion.iteraciones+"\n");
            
            //Insertion Sort
            ArrayList<Float> arrayInsertion = new ArrayList<Float>(insertion.insertionSort(orderInsertion));
            taOutput.appendText("\n  = = = = = = = = = = = = = = = =\n Inserción:\n"+arrayInsertion);
            taOutput.appendText("\nTiempo en nanosegundos: "+insertion.tTime+ "\n Numero de iteraciones: "+insertion.iteraciones+"\n");
            
            //BubbleSort
            ArrayList<Float> arrayBurbuja = new ArrayList<Float>(bubble.burbuja(orderB));
            taOutput.appendText("\n  = = = = = = = = = = = = = = = =\n Burbuja:\n"+arrayInsertion);
            taOutput.appendText("\nTiempo en nanosegundos: "+bubble.tTime+ "\n Numero de iteraciones: "+bubble.iteraciones+"\n");
            
            //taOutput.appendText("\nBusqueda secuencial posicion"+(busqueda.busquedaSecuencial(arrayQuicksort,Float.valueOf(tfDato.getText()))+1)+" con un tiempo de: "+busqueda.tTime+ " nanosegundos y "+busqueda.iteraciones+" iteraciones");
            System.out.println("---Valor finalPosition: "+finalPosition);
            finalPosition = busqueda.busquedaSecuencial(arrayQuicksort,Float.parseFloat(tfDato.getText()))+1;
            finalPbs = binSearch.buscar(arrayQuicksort, Float.parseFloat(tfDato.getText()))+1;//binSearch.buscar(arrayQuicksort, Float.parseFloat(tfDato.getText()))+1;
            if((finalPosition > 0) || (finalPbs > 0)){
                position = Integer.toString(finalPosition);
            }else{
                position = "No se encontro la busqueda";
            }
            
            //busqueda secuencial
            taOutput.appendText("\n  = = = = = = = = = = = = = = = =\n Busqueda secuencial:\n "
                + "Posicion: "+position+"\n "
                + "Tiempo: "+busqueda.tTime+ " nanosegundos \n"
                + "Iteraciones: "+busqueda.iteraciones+" iteraciones\n");
            
            //Busqueda Binaria
            //System.out.println("Busqueda binaria "+binSearch.buscar(arrayQuicksort,Integer.parseInt(tfDato.getText()))+" con un tiempo de: "+binSearch.tTime+ " nanosegundos y "+binSearch.iteraciones+" iteraciones");
            taOutput.appendText("\n  = = = = = = = = = = = = = = = =\n Busqueda Binaria:\n "
                    + "Posicion: "+ position +"\n "
                    + "Tiempo: "+binSearch.tTime+ " nanosegundos \n"
                    + "Iteraciones: "+ binSearch.iteraciones+" iteraciones\n");
            
            txtDisplay.setText("");
            for (int k=0; k < ordenarI.size(); k++){
                txtDisplay.appendText("\n["+(k+1)+"] : \t"+arrayQuicksort.get(k));
            } 
        }
        
        if(comparar.equals("C")){ //Ordenacion caracteres
            ArrayList<Character> ordenarI = new ArrayList<Character>(caracteres);                
            ArrayList<Character> orderC = new ArrayList<Character>(caracteres);
            ArrayList<Character> orderB = new ArrayList<Character>(caracteres);
            //ArrayList<Integer> arrayInsercion = new ArrayList<Integer>(insercion.ordenar(ordenarI));
            //System.out.println("insercion"+ arrayInsercion);
            //System.out.println("Tiempo en nanosegundos: "+insercion.tiempo+ " e iteraciones: "+insercion.iteraciones);                
            
            ArrayList<Character> arrayQuicksort = new ArrayList<Character>(quicksort.quickSort(caracteres, 0, caracteres.size()-1));
            System.out.println("Quicksort"+arrayQuicksort);
            System.out.println("Tiempo en nanosegundos: "+quicksort.tTime+ " e iteraciones: "+quicksort.iteraciones);   
            taOutput.appendText("\n = = = = = = = = = = = = = = = =\n Quicksort:\n"+arrayQuicksort);
            taOutput.appendText("\nTiempo en nanosegundos: "+quicksort.tTime+ "\n Numero de iteraciones: "+quicksort.iteraciones+"\n");
            
            ArrayList<Character> arraySeleccion = new ArrayList<Character>(seleccion.selectionSort(caracteres));
            System.out.println("Seleccion"+arraySeleccion);
            System.out.println("Tiempo en nanosegundos: "+seleccion.tTime+ " e iteraciones: "+seleccion.iteraciones);  
            taOutput.appendText("\n  = = = = = = = = = = = = = = = =\n Seleccion:\n"+arraySeleccion);
            taOutput.appendText("\nTiempo en nanosegundos: "+seleccion.tTime+ "\n Numero de iteraciones: "+seleccion.iteraciones+"\n");
            
            //Insertion Sort
            ArrayList<Character> arrayInsertion = new ArrayList<Character>(insertion.insertionSort(orderC));
            taOutput.appendText("\n  = = = = = = = = = = = = = = = =\n Inserción:\n"+arrayInsertion);
            taOutput.appendText("\nTiempo en nanosegundos: "+insertion.tTime+ "\n Numero de iteraciones: "+insertion.iteraciones+"\n");
            
            //BubbleSort
            ArrayList<Character> arrayBurbuja = new ArrayList<Character>(bubble.burbuja(orderB));
            taOutput.appendText("\n  = = = = = = = = = = = = = = = =\n Burbuja:\n"+arrayInsertion);
            taOutput.appendText("\nTiempo en nanosegundos: "+bubble.tTime+ "\n Numero de iteraciones: "+bubble.iteraciones+"\n");
            
            String dato=tfDato.getText();
            char cadena[];
            cadena=dato.toCharArray();
            finalPosition = busqueda.busquedaSecuencial(arrayQuicksort,cadena[0])+1;
            finalPbs = binSearch.buscar(arrayQuicksort, cadena[0])+1;
            if((finalPosition > 0) || (finalPbs > 0)){
                position = Integer.toString(finalPosition);
            }else{
                position = "No se encontro la busqueda";
            }
            
            //Busqueda secuencial
            //taOutput.appendText("\nBusqueda secuencial posicion"+(busqueda.busquedaSecuencial(arrayQuicksort,cadena[0])+1)+" con un tiempo de: "+busqueda.tTime+ " nanosegundos y "+busqueda.iteraciones+" iteraciones");
             taOutput.appendText("\n  = = = = = = = = = = = = = = = =\n Busqueda secuencial:\n "
                    + "Posicion: "+finalPosition+"\n "
                    + "Tiempo: "+busqueda.tTime+ " nanosegundos \n"
                    + "Iteraciones: "+busqueda.iteraciones+" iteraciones\n");
             
             //Busqueda Binaria
            //System.out.println("Busqueda binaria "+binSearch.buscar(arrayQuicksort,Integer.parseInt(tfDato.getText()))+" con un tiempo de: "+binSearch.tTime+ " nanosegundos y "+binSearch.iteraciones+" iteraciones");
            taOutput.appendText("\n  = = = = = = = = = = = = = = = =\n Busqueda Binaria:\n "
                    + "Posicion: "+ position +"\n "
                    + "Tiempo: "+binSearch.tTime+ " nanosegundos \n"
                    + "Iteraciones: "+ binSearch.iteraciones+" iteraciones\n");
            
            
            txtDisplay.setText("");
            for(int j=0; j < ordenarI.size(); j++){    
                txtDisplay.appendText("\n["+(j+1)+"] : \t"+arrayQuicksort.get(j));
                //txtDisplay.appendText("\n"+(j+1)+".-"+arrayQuicksort.get(j));
            }     
        }
    }    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
