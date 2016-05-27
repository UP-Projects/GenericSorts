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
    long tStart,tEnd,tTime;
    int iteraciones=0;public ArrayList<T> arrayBurbuja;
    
    public <T extends Comparable<T>> ArrayList<T> getArray() {
        return (ArrayList<T>) this.arrayBurbuja;
    }

    public  <T extends Comparable<T>> ArrayList<T> burbuja(ArrayList<T> arrayBurbuja){ //metodo Burbuja el cual recibe un arreglo con los elementos
        int i, j;        
        T aux;
        tStart = System.nanoTime();

        for(i=0;i<arrayBurbuja.size()-1;i++){ 
            for(j=0;j<arrayBurbuja.size()-i-1;j++){
                iteraciones++;
                if(arrayBurbuja.get(j).compareTo(arrayBurbuja.get(j +1)) > 0 ){ //Se toma a la posicion de j como el primer elemento a comparar con j+1
                    aux = arrayBurbuja.get(j+1);
                    arrayBurbuja.set(j+1, arrayBurbuja.get(j));
                    arrayBurbuja.set(j, aux);
                }
            }
        }       
        
        tTime = System.nanoTime() - tStart;
        return arrayBurbuja;
    }
}
