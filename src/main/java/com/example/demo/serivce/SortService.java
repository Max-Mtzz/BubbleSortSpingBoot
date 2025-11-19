package com.example.demo.serivce;

import org.springframework.stereotype.Service;

//Etiqueta para deifinir la clase como un servicio para poder inyectarse en otras clases
@Service
public class SortService {

     public int[] sort(int[] arr){
        int n = arr.length;
        boolean swapped=false;
        //Condicionamos con un for para que no se desborde que recorrra el arreglo
        for (int i = 0; i < n-1; i++) {
            swapped=false;
            //Con un for recorremos el arreglo y con el otro ordenamos todos
            //Esta vez que sea menor a i ya que ahora i tendra un valor despues de haberse recorrido n veces
            for (int j = 0; j < n-1-i; j++) {
                //Evalua si el valor actual es menor al que sigue
                if(arr[j] > arr[j+1]){
                    //Se realiza el intercambio, pasamos el valor original a una variable temporal
                    int temp=arr[j];
                    //La posición actual equivale a la siguiente
                    arr[j]=arr[j+1];
                    //La posición siguiente vale la posición original guardada en la variable temporal
                    arr[j+1]=temp;
                    swapped=true;
                }

            }
            if(!swapped){
                break;
            }
        }
        //Nos devuelve al arreglo para que no imprima en consola y lo devuelva como servicio
        return arr;
    }
}
