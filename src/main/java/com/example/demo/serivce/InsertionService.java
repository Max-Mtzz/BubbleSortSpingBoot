package com.example.demo.serivce;

import org.springframework.stereotype.Service;

@Service
public class InsertionService {
    public int[] sort(int[] arr){

        int n = arr.length;
        for (int i = 0; i < n; i++) {//Comenzamos desde el segundo elemento
            int key = arr[i]; //Elemento que vamos a insertar en la parte ordenada

            int j = i-1; //Para poder recorrer hacia atras
            while (j>=0 && arr[j]>key) {/*Recorrer la parte ordenada e insertar key en su posición*/
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;//Insercion del elemento key dentro de la posicion dada de la parte ordenada
        }
        return arr;
    }
}
