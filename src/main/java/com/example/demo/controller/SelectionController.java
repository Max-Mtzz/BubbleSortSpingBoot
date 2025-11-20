package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RequestCadena;
import com.example.demo.serivce.SelectionService;

//Sabe que esta clase sera controlador con esta etiqueta para distribuir la lógica
@RestController
//Configuramos la direccion de la api con esta etiqueta
@RequestMapping("/api/sort")
public class SelectionController {
    @Autowired
    SelectionService selection;

    @PostMapping("/selection")
    public int[] selectionSort(@RequestBody RequestCadena request) {
        
        //Obtenemos el arreglo de numeros
        String[] partes = request.getCadena().split(",");
        //Lo convertimos a un arreglo de enteros
        int[] numeros = new int[partes.length];
        //Recorremos el arreglo de la cadena de numeros y le asignamos los valores al arreglo de numeros enteros
        for (int i = 0; i < partes.length; i++) {
            try{
                numeros[i]=Integer.parseInt(partes[i]);
            }catch(Exception e){
                numeros[i]=0;
            }
        }
        
        return selection.sort(numeros);
    }
}
