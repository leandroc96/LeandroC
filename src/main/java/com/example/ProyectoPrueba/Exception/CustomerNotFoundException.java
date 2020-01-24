package com.example.ProyectoPrueba.Exception;

public class CustomerNotFoundException extends Exception{
    private int customerId;
            public CustomerNotFoundException(int customerId){
                super(String.format("Comprador no encontrado con esos parametros"));

            }

}
