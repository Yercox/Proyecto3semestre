package com.espe.jean.modelo;

public class Auto extends Vehiculo {

    public Auto(String placa, String modelo, int anio, double precioPorDia) {
        super(placa, modelo, anio, precioPorDia);
    }

    @Override
    public String getTipo() {
        return "AUTO";
    }
}
