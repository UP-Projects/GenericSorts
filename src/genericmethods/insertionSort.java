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
        ArrayList<T> datosInsertion;
        datosInsertion = new ArrayList<T>(array);
        T temp;
        System.out.println("Datos insertion: "+datosInsertion);
        for(int i=1; i<datosInsertion.size(); i++){        
            temp = datosInsertion.get(i);
            int j = i-1;
                       
            //for(int j = i-1; j>=0 && datosInsertion.get(j).compareTo(temp) > 0; j--){
            while ( (j >= 0) &&(datosInsertion.get(j).compareTo(temp) > 0) ){
                iteraciones++;
                datosInsertion.set(j+1, datosInsertion.get(j));
                datosInsertion.set(j, temp);
                j--;
            }
        }
        System.out.println("-------------iteraciones: "+iteraciones);
        System.out.println("::Datos insertion al salir: "+datosInsertion);
        tTime = System.nanoTime() - tStart;
        return array;
    }
    
}
