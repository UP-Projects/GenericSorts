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
public class seleccionMethod {
    long tStart,tEnd,tTime;
    int iteraciones=0;
    
    public <T extends Comparable<T>> ArrayList<T> selectionSort(ArrayList<T> list){
            tStart = System.nanoTime(); //de ejecución
		ArrayList<T> datosOrdenados;
		datosOrdenados = new ArrayList<T>(list);
		for (int i =0; i<datosOrdenados.size()-1; i++) {
			T menor = datosOrdenados.get(i);
			int pos = i;
			for (int j = i+1; j < datosOrdenados.size(); j++){
                            iteraciones++;
				if(datosOrdenados.get(j).compareTo(menor) < 0) {
					menor = datosOrdenados.get(j);
					pos = j;
				}
			}
			datosOrdenados.set(pos,datosOrdenados.get(i));
			datosOrdenados.set(i,menor);
		}
                tEnd = System.nanoTime();
                tTime = tEnd-tStart;
		return datosOrdenados;
}
