/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericmethods;

import java.util.ArrayList;

/**
 *
 * @author Arreola
 */
public class binarySearch {
    
    //Variables de la clase
    long tStart,tTime;
    int iteraciones=0;
    
    //metodo que recibe un arraylist y el número que se va a buscar
    public int buscar( ArrayList<Integer> array, int busqueda) { //Buscar enteros
        
        tStart = System.nanoTime(); //tiempo de inicio
        int indiceInicial = 0; //se asigna un valor de 0 al indice inicial y medio
        int indiceMedio = 0;
        int indiceFinal = array.size() - 1; //para el indice final se asigna el tamaño del array
                
        while (indiceInicial <= indiceFinal) { //ciclo para mantenernos dentro del array
            iteraciones++;//se incrementa el numero de iteraciones
            indiceMedio = (indiceInicial + indiceFinal) / 2; //indice medio toma la posicion de la mitad del array
            System.out.println("indice medio: "+indiceMedio);
            
            if ( array.get(indiceMedio).equals(busqueda)){ //ciclo para verificar si el valor que tiene indiceMedio es el valor que buscamos
                tTime = System.nanoTime() - tStart; //se calcula el tiempo final
                System.out.println("Tiempo"+tTime);  
                return indiceMedio; //se retorna la posicion del numero
                
            }else if ( array.get(indiceMedio) < busqueda ) { //si el indice medio es menor que la busqueda...
                indiceInicial = indiceMedio + 1; //se recorre el indice inicial a la posicion del indice medio + 1
                System.out.println("indice inicial: "+indiceInicial);
                
            }else{ //si el indice medio es  mayor que la busqueda
                indiceFinal = indiceMedio - 1; //el valor de indice final toma la posicion de indice medio -1
                System.out.println("indice final: "+indiceFinal);
                tTime = System.nanoTime() - tStart; //se calcula el tiempo final
            }
        }
        System.out.println("Tiempo"+tTime);        
        return -1;//si no se encuentra la busqueda retornamos -1
    }
    
    public int buscar( ArrayList<Float> array,  float busqueda) { //buscar flotantes
        tStart = System.nanoTime(); //tiempo de inicio
        int indiceInicial = 0;
        int indiceMedio = 0;
        int indiceFinal = array.size() - 1;
        
        while (indiceInicial <= indiceFinal) {
            iteraciones++;
            indiceMedio = (indiceInicial + indiceFinal) / 2;

            if ( array.get(indiceMedio).equals(busqueda)){
                tTime = System.nanoTime() - tStart;
                return indiceMedio;
                
            }else if ( array.get(indiceMedio) < busqueda ) {
                indiceInicial = indiceMedio+1;
                
                
            }else{
                indiceFinal = indiceMedio-1;
                tTime = System.nanoTime() - tStart;
            }
        }
        return -1;
    }
    
    public int buscar( ArrayList<Character> array, char busqueda) { //buscar caracteres
        tStart = System.nanoTime(); //tiempo de inicio
        int indiceInicial = 0;
        int indiceMedio;
        int indiceFinal = array.size() - 1;
        
        
        while (indiceInicial <= indiceFinal) {
            iteraciones++;
            System.out.println("indice inicial: "+indiceInicial);
            indiceMedio = (indiceInicial + indiceFinal) / 2;
            
            if ( array.get(indiceMedio).equals(busqueda)){
                tTime = System.nanoTime();
                System.out.println("Tiempo"+tTime);  
                System.out.println("indice medio: "+indiceMedio);
                return indiceMedio;
                
            }else if ( array.get(indiceMedio).compareTo(busqueda) < 0 ) {
                indiceInicial = indiceMedio + 1;
            } else {
                indiceFinal = indiceMedio - 1;
                tTime = System.nanoTime() - tStart;
                
            }
            
            System.out.println("indice final: "+indiceFinal);
        }
        return -1;
    }

   

    
}
