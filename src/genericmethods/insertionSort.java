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
public class insertionSort {
    long tStart,tEnd,tTime;
    int iteraciones=0;
    
    public <T extends Comparable<T>> ArrayList<T> insertionSort(ArrayList<T> array){
        tStart = System.nanoTime();
        T aux;
        for(int i=1; i<array.size(); i++){        
            aux = array.get(i);
            int j = i-1;
            //for(int j=i-1; j>=0 && array.get(j).compareTo(aux) > 0; j--){
            while ((array.get(j).compareTo(aux) > 0) && (j >= 0)){
            iteraciones++;
            array.set(j+1, array.get(j));
            array.set(j, aux);
        }
    }
    tTime = System.nanoTime() - tStart;
    return array;
  }
    
}
