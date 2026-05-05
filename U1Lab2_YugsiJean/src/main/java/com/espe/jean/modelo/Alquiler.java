package com.espe.jean.modelo;

public class Alquiler {
    private Vehiculo vehiculo;
    private String cedula;
    private int dias;
    private double total;

    public Alquiler(Vehiculo vehiculo, String cedula, int dias) {
        this.vehiculo = vehiculo;
        this.cedula = cedula;
        this.dias = dias;
        this.total = vehiculo.getPrecioPorDia() * dias;
    }

    public double getTotal() { return total; }

    @Override
    public String toString() {
        return "Cliente: " + cedula +
                " | Vehiculo: " + vehiculo.getModelo() +
                " | Dias: " + dias +
                " | Total: $" + total;
    }
}