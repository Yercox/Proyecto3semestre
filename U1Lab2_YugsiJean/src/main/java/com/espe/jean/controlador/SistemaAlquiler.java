package com.espe.jean.controlador;

import com.espe.jean.modelo.Alquiler;
import com.espe.jean.modelo.Auto;
import com.espe.jean.modelo.Moto;
import com.espe.jean.modelo.Vehiculo;

import java.util.ArrayList;

public class SistemaAlquiler {

    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private ArrayList<Alquiler> alquileres = new ArrayList<>();

    public SistemaAlquiler() {
        // VEHICULOS POR DEFECTO
        vehiculos.add(new Auto("ABC123", "Toyota", 2020, 30));
        vehiculos.add(new Moto("XYZ789", "Yamaha", 2022, 15));
    }

    public void agregarVehiculo(Vehiculo v) {
        if (buscarVehiculo(v.getPlaca()) != null) {
            System.out.println("Error: placa ya existe.");
            return;
        }
        vehiculos.add(v);
        System.out.println("Vehículo agregado.");
    }

    public Vehiculo buscarVehiculo(String placa) {
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }

    public void listarDisponibles() {
        System.out.println("\nMODELO   AÑO   TIPO   PRECIO   PLACA");
        for (Vehiculo v : vehiculos) {
            if (v.isDisponible()) {
                System.out.println(v);
            }
        }
    }

    public void alquilar(String placa, String cedula, int dias) {
        Vehiculo v = buscarVehiculo(placa);

        if (v == null) {
            System.out.println("No encontrado.");
            return;
        }

        if (!v.isDisponible()) {
            System.out.println("No disponible.");
            return;
        }

        v.setDisponible(false);
        alquileres.add(new Alquiler(v, cedula, dias));

        System.out.println("Alquiler exitoso.");
    }

    public void listarAlquileres() {
        double total = 0;

        System.out.println("\n--- ALQUILERES ---");
        for (Alquiler a : alquileres) {
            System.out.println(a);
            total += a.getTotal();
        }

        System.out.println("GANANCIA TOTAL: $" + total);
    }
}