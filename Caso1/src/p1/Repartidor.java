package p1;

import java.util.Random;

public class Repartidor extends Thread{
    private Despachador despachador;

    public Repartidor(Despachador despachador) {
        this.despachador = despachador;
    }

    @Override
    public void run() {
        while (true) {
            Producto producto;
            
            try {
                producto = despachador.tomarProducto();
                if (producto == null) {
                break;
            }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            //Producto producto = despachador.tomarProducto();
            
            System.out.println("Repartidor ha tomado un producto para entregar.");
            int tiempoEntrega = new Random().nextInt(8) + 3; // Entre 3 y 10 segundos
            try {
                sleep(tiempoEntrega * 1000); // Simular tiempo de entrega
                System.out.println("Repartidor ha entregado un producto.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
