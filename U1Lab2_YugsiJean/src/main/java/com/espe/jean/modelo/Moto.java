package com.espe.jean.modelo;

public class Moto extends Vehiculo {

    public Moto(String placa, String modelo, int anio, double precioPorDia) {
        super(placa, modelo, anio, precioPorDia);
    }

    @Override
    public String getTipo() {
        return "MOTO";
    }
}