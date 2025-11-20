package com.example.demo.serivce;

import org.springframework.stereotype.Service;

@Service
public class SelectionService {
    public int[] sort(int[]arr){
        int n=arr.length;
        int minidex;
        for(int i=0; i<n-1; i++){ //recorremos todo esto evitando un desbordamiento
            minidex=i;//suponemos que el primero es el menor
            for(int j=i+1; j<n; j++){
                if(arr[j]<arr[minidex]){
                    minidex=j;//seleccionamos el indice del elemento menor
                }
            }
            int temp=arr[minidex];//guardamos el valor del minimo
            arr[minidex]=arr[i];//intercambio mandamos el valor del actual a la posicion del
            arr[i]=temp;//en la posicion actual guardamos el temporal
        }
        return arr;
    }
}
