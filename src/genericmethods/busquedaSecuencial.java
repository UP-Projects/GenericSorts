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
        //INICIA EL CONTEO DEL TIEMPO
        tStart = System.nanoTime(); 
        int posicion = -1;
        //SE RECORRE TODO EL ARREGLA
        for(int i = 0; i < arreglo.size(); i++){
            
            iteraciones++;
            int aux = arreglo.get(i);
            if(aux == dato){//SE COMPARA TODO EL ARREGLO
                posicion = i;//POSICION DEL ELEMENTO
                break;
                //STOP CICLO
            } 
        } 
        tEnd = System.nanoTime();
        tTime = tEnd-tStart;
        return posicion; 
    } 
    public int busquedaSecuencial(ArrayList<Float> arreglo,float dato){
        tStart = System.nanoTime(); //INICIA EL CONTEO DEL TIEMPO
        int posicion = -1;
        for(int i = 0; i < arreglo.size(); i++){
            //S RECORRE EL ARREGLO
            iteraciones++;
            
            float aux = arreglo.get(i);
            //SE COMPARA CADA ELEMENTO
            if(aux == dato){
//                SE GUARDA LA POSICION
                posicion = i;
                break;//TERMINA EL CICLO
            } 
        } 
        tEnd = System.nanoTime();
        tTime = tEnd-tStart;
        return posicion; 
    }
    public int busquedaSecuencial(ArrayList<Character> arreglo,char dato){
        //INICIA EL CONTEO
        tStart = System.nanoTime(); 
        int posicion = -1;
        //SE RECORRE EL ARREGLO
        for(int i = 0; i < arreglo.size(); i++){
            iteraciones++;
            char aux = arreglo.get(i);
            //SE COMPARAN LOS DATOS
            if(aux == dato){
                //SE GUARDA EL POSICION
                posicion = i;
                break;
                //TERMINA EL CICLO
            } 
        } 
        //SE GUARDAN LOS TIEMPOS
        tEnd = System.nanoTime();
        tTime = tEnd-tStart;
        //DEVOLVEMOS LA POSICION
        return posicion; 
    }
}
