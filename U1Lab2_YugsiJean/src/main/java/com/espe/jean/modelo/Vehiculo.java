package com.espe.jean.modelo;

public abstract class Vehiculo {
    protected String placa;
    protected String modelo;
    protected int anio;
    protected double precioPorDia;
    protected boolean disponible;

    public Vehiculo(String placa, String modelo, int anio, double precioPorDia) {
        this.placa = placa;
        this.modelo = modelo;
        this.anio = anio;
        this.precioPorDia = precioPorDia;
        this.disponible = true;
    }

    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public int getAnio() { return anio; }
    public double getPrecioPorDia() { return precioPorDia; }
    public boolean isDisponible() { return disponible; }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return modelo + " | " + anio + " | " + getTipo() + " | $" + precioPorDia + " | " + placa +
                " | " + (disponible ? "Disponible" : "Ocupado");
    }
}