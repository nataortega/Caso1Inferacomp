package p1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    /** 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de productores (N): ");
        int N = scanner.nextInt();

        System.out.print("Ingrese el número de repartidores (M): ");
        int M = scanner.nextInt();

        System.out.print("Ingrese la capacidad de la bodega (TAM): ");
        int TAM = scanner.nextInt();
        
        System.out.print("Ingrese la cantidad de productos a producir (totalProductos): ");
        int totalProductos = scanner.nextInt(); // Número total de productos

        Bodega bodega = new Bodega(TAM);
        Productor[] productores = new Productor[N];
        Repartidor[] repartidores = new Repartidor[M];
        Despachador despachador = new Despachador(bodega, repartidores);

        // Inicializar productores
        for (int i = 0; i < N; i++) {
            productores[i] = new Productor(bodega, totalProductos);
            productores[i].start();
        }

        // Inicializar repartidores
        for (int i = 0; i < M; i++) {
            repartidores[i] = new Repartidor(despachador);
            repartidores[i].start();
        }

        // Inicializar despachador
        despachador.start();

        // Esperar a que todos los productores terminen
        for (Productor productor : productores) {
            try {
                productor.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Esperar a que todos los repartidores terminen
        for (Repartidor repartidor : repartidores) {
            try {
                repartidor.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Esperar a que el despachador termine
        try {
            despachador.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Simulación finalizada");

        scanner.close();
    }    */    
        
    public static void main(String[] args) {
        int numProductores = 5;
        int numRepartidores = 3;
        int TAM = 10;
        int productosPorProductor = 5;

        Bodega bodega = new Bodega(TAM);
        Despachador despachador = new Despachador(bodega, numProductores, productosPorProductor, numRepartidores);

        List<Thread> threads = new ArrayList<>();

        // Crear productores
        for (int i = 0; i < numProductores; i++) {
            Thread productor = new Productor(bodega, productosPorProductor);
            threads.add(productor);
        }

        // Crear repartidores
        for (int i = 0; i < numRepartidores; i++) {
            Thread repartidor = new Repartidor(despachador);
            threads.add(repartidor);
        }

        // Iniciar todos los threads
        for (Thread thread : threads) {
            thread.start();
        }

        // Esperar a que todos los threads terminen
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Programa finalizado.");
    }
    
}