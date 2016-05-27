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
    
    long tStart,tEnd,tTime;
    int iteraciones=0;
    
    public int buscar( ArrayList<Integer> array, int busqueda) { //Buscar enteros
        tStart = System.nanoTime(); //tiempo de inicio
        int indiceInicial = 0;
        int indiceMedio = 0;
        int indiceFinal = array.size() - 1;
                
        while (indiceInicial <= indiceFinal) {
            iteraciones++;
            indiceMedio = (indiceInicial + indiceFinal) / 2;
            System.out.println("indice medio: "+indiceMedio);
            if ( array.get(indiceMedio).equals(busqueda)){
                tTime = System.nanoTime() - tStart;
                System.out.println("Tiempo"+tTime);  
                return indiceMedio;
            }else if ( array.get(indiceMedio) < busqueda ) {
                indiceInicial = indiceMedio + 1;
                System.out.println("indice inicial: "+indiceInicial);
            }else{
                indiceFinal = indiceMedio - 1;
                System.out.println("indice final: "+indiceFinal);
                tTime = System.nanoTime() - tStart;
            }
        }
        System.out.println("Tiempo"+tTime);        
        return -1;
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
