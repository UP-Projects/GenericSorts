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
public class busquedaSecuencial {
    long tStart,tEnd,tTime;
    int iteraciones=0;
  
    public int busquedaSecuencial(ArrayList<Integer> arreglo,int dato){
        tStart = System.nanoTime(); //de ejecución
        int posicion = -1;
        for(int i = 0; i < arreglo.size(); i++){
            //recorremos todo el arreglo 
            iteraciones++;
            int aux = arreglo.get(i);
            if(aux == dato){//comparamos el elemento en el arreglo con el buscado 
                posicion = i;//Si es verdadero guardamos la posicion 
                break;//Para el ciclo 
            } 
        } 
        tEnd = System.nanoTime();
        tTime = tEnd-tStart;
        return posicion; 
    } 
    public int busquedaSecuencial(ArrayList<Float> arreglo,float dato){
        tStart = System.nanoTime(); //de ejecución
        int posicion = -1;
        for(int i = 0; i < arreglo.size(); i++){
            //recorremos todo el arreglo 
            iteraciones++;
            //Dani lo tiene igual y le agarrar así 
            float aux = arreglo.get(i);
            if(aux == dato){//comparamos el elemento en el arreglo con el buscado 
                posicion = i;//Si es verdadero guardamos la posicion 
                break;//Para el ciclo 
            } 
        } 
        tEnd = System.nanoTime();
        tTime = tEnd-tStart;
        return posicion; 
    }
    public int busquedaSecuencial(ArrayList<Character> arreglo,char dato){
        tStart = System.nanoTime(); //de ejecución
        int posicion = -1;
        for(int i = 0; i < arreglo.size(); i++){
            //recorremos todo el arreglo 
            iteraciones++;
            //Dani lo tiene igual y le agarrar así 
            char aux = arreglo.get(i);
            if(aux == dato){//comparamos el elemento en el arreglo con el buscado 
                posicion = i;//Si es verdadero guardamos la posicion 
                break;//Para el ciclo 
            } 
        } 
        tEnd = System.nanoTime();
        tTime = tEnd-tStart;
        return posicion; 
    }
}
