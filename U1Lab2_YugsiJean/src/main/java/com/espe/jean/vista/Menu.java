package com.espe.jean.vista;

import com.espe.jean.controlador.SistemaAlquiler;
import com.espe.jean.modelo.Auto;
import com.espe.jean.modelo.Moto;

import java.util.Scanner;

public class Menu {

    private Scanner sc = new Scanner(System.in);
    private SistemaAlquiler sistema = new SistemaAlquiler();

    public void iniciar() {
        int op;

        do {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("║   SISTEMA DE CLIENTES       ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║ 1. Alquilar Vehiculos       ║");
            System.out.println("║ 2. Lista de disponibles     ║");
            System.out.println("║ 3. Ver alquileres           ║");
            System.out.println("║ 4. Agregar vehiculo         ║");
            System.out.println("║ 0. Salir                    ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.print("Opcion: ");

            op = sc.nextInt(); sc.nextLine();

            switch (op) {

                case 1 -> alquilar();

                case 2 -> sistema.listarDisponibles();

                case 3 -> sistema.listarAlquileres();

                case 4 -> agregarVehiculo();
            }

        } while (op != 0);
    }

    private void alquilar() {
        System.out.print("Placa: ");
        String placa = sc.nextLine();

        System.out.print("Cedula (10 digitos): ");
        String cedula = sc.nextLine();

        if (!cedula.matches("\\d{10}")) {
            System.out.println("Error: cedula invalida.");
            return;
        }

        System.out.print("Dias: ");
        int dias = sc.nextInt(); sc.nextLine();

        if (dias <= 0) {
            System.out.println("Error: los dias deben ser mayores a 0.");
            return;
        }
        System.out.print("Dias: ");
        dias = sc.nextInt(); sc.nextLine();

        sistema.alquilar(placa, cedula, dias);
    }

    private void agregarVehiculo() {

        System.out.print("Tipo (1 Auto / 2 Moto): ");
        int tipo = sc.nextInt(); sc.nextLine();

        System.out.print("Modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Año: ");
        int anio = sc.nextInt(); sc.nextLine();

        System.out.print("Precio: ");
        double precio = sc.nextDouble(); sc.nextLine();

        System.out.print("Placa: ");
        String placa = sc.nextLine();


        if (modelo.isEmpty() || placa.isEmpty()) {
            System.out.println("Datos inválidos.");
            return;
        }

        if (tipo == 1) {
            sistema.agregarVehiculo(new Auto(placa, modelo, anio, precio));
        } else {
            sistema.agregarVehiculo(new Moto(placa, modelo, anio, precio));
        }
    }
}