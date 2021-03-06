/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericmethods;

import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class quickSortMethod<T> {
    long tStart,tEnd,tTime;
    int iteraciones=0;
    private ArrayList<T> array;    
    public <T extends Comparable<T>> ArrayList<T> getArray() {
        return (ArrayList<T>) this.array;
    }
 
    public <T extends Comparable<T>> ArrayList<T> quickSort(ArrayList<T> array, int left, int right) {
        tStart = System.nanoTime(); //TIEMPO DE INICIO DE EJECUCION
        int inicio = divide(array, left, right); //RECOLECTAMOS EL VALOR ACTUAL       
        if (left < inicio - 1)//COMPARAMOS UNA POSICION ATRAS
            quickSort(array, left, inicio - 1);
        //COMPARAMOS EL VALOR DERECHO
        if (inicio < right)
            quickSort(array, inicio, right);
        //CALCULAMOS EL TIEMPO
        tEnd = System.nanoTime();
        tTime = tEnd-tStart;
        //DEVOLVEMOS EL ARREGLO ORDENADO
        return array;
    }
    
    public <T extends Comparable<T>> int divide(ArrayList<T> array, int left, int right) {
        //ASIGNAMOS LOS VALORES RECIBIDOS
        int l = left, r = right;
        T aux; T pivote = array.get(left);     
        //SE COMPARA LOS PIVOTES
        while (l <= r) {
            while (array.get(l).compareTo(pivote) < 0)
                //SE RECORRE LA POSICION
                l++;
            
            while (array.get(r).compareTo(pivote) > 0)
                r--;
            
            if (l <= r) {
                //ITERRACIONES
                iteraciones++;
                //SE CAMBIAN LOS VALORES
                aux = array.get(l);
                array.set(l, array.get(r));
                array.set(r, aux);
                //SE ACTUALIZAN LOS CONTADORES
                l++;
                r--;
            }         
        };     
        //RETORNAMOS EL PIVOTE L
        return l;        
    }    
}
