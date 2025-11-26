package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ErrorResponse;
import com.example.demo.dto.RequestCadena;
import com.example.demo.serivce.SortService;

//Sabe que esta clase sera controlador con esta etiqueta para distribuir la lógica.
@RestController
//Configuramos la direccion de la api con esta etiqueta
@RequestMapping("/api/sort")
public class BubbleController {
    @Autowired
    SortService service;

    @PostMapping("/bubble")//Endpoint
    //Usamos response entity para devolver un código 200 OK (que garantiza que entre pero no que se ejecute)
    public ResponseEntity<?> bubbleSort(@RequestBody RequestCadena request){

        //Hacemos un manejo de errores donde si sucede algo da error general sin exponer información del servidor
        try{
             //Validaremos que la petición sea correcta
        if (request== null || request.getCadena().isBlank()) {
            //instancia del error
            ErrorResponse error = new ErrorResponse();
            //Especificamos el error
            error.setError("La petición es incorrecta");
            //Indicamos el error de cadena vacia
            error.setDetail("Necesitamos que llenes los datos de la cadena");

            //Si la petición esta mal no tira error 500 si no un Bad Request
            return ResponseEntity.badRequest().body(error);
        }

        //Obtenemos el arreglo de numeros
        String[] partes = request.getCadena().split(",");
        //Lo convertimos a un arreglo de enteros
        int[] numeros = new int[partes.length];
        //Recorremos el arreglo de la cadena de numeros y le asignamos los valores al arreglo de numeros enteros
        for (int i = 0; i < partes.length; i++) {
            try{
                numeros[i]=Integer.parseInt(partes[i]);
            }catch(IllegalArgumentException e){
                ErrorResponse error = new ErrorResponse();
                //Indicamos el error
                error.setError("Dato incorrecto, tienen que ser numeros: "+numeros[i]);
                //Indicamos el error especifico
                error.setDetail(e.getMessage());
                return ResponseEntity.badRequest().body(error);
            }
        }
        
        return ResponseEntity.ok(service.sort(numeros));

        }catch(Exception e){
            ErrorResponse error = new ErrorResponse();
            //Enviamos mensaje de error general
            error.setError("Error General");
            //Mostramos el error
            error.setDetail(e.getMessage());
            return ResponseEntity.internalServerError().body(error);
        }
    }
}