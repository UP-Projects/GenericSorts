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
public class bubbleSort<T> {
    
    //variables de la clase
    long tStart,tEnd,tTime;
    int iteraciones=0;public ArrayList<T> arrayBurbuja;
    
    //getter que retorna el array 
    public <T extends Comparable<T>> ArrayList<T> getArray() { 
        return (ArrayList<T>) this.arrayBurbuja;
    }

    //meotodo generico que recibe como parametro un array
    public  <T extends Comparable<T>> ArrayList<T> burbuja(ArrayList<T> arrayBurbuja){ //metodo Burbuja el cual recibe un arreglo con los elementos
        int i, j;        
        T aux;
        tStart = System.nanoTime(); //se toma el tiempo inicial en el que inicia el proceso

        for(i=0;i<arrayBurbuja.size()-1;i++){ //ciclo para recorrer todos los elementos del arreglo
            for(j=0; j < arrayBurbuja.size()-i-1; j++){
                iteraciones++; //se incrementa en 1 las iteraciones
                
                //si la posicon j es mayor que j+1...
                if(arrayBurbuja.get(j).compareTo(arrayBurbuja.get(j +1)) > 0 ){ //j será el primer elemento a comparar con j+1
                    aux = arrayBurbuja.get(j+1); //aux toma el valor que vamos a intercambiar
                    arrayBurbuja.set(j+1, arrayBurbuja.get(j)); //el valor que tiene j se pone en la posicion j+1
                    arrayBurbuja.set(j, aux); //el valor que tiene guaradamos en aux se pone en la posicion j
                }
            }
        }       
        
        tTime = System.nanoTime() - tStart; //se saca el tiempo final del proceso
        return arrayBurbuja;
    }
}
