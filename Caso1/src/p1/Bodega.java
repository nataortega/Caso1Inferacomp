package p1;

import java.util.ArrayList;
import java.util.List;

public class Bodega {

    private int TAM;
        private List<Producto> productos = new ArrayList<>();

        public Bodega(int TAM) {
            this.TAM = TAM;
        }

        public synchronized void ponerProducto(Producto producto) throws InterruptedException {
            while (productos.size() >= TAM) {
                wait();
            }
            productos.add(producto);
            System.out.println("Productor ha depositado un producto en la bodega.");
            notifyAll();
        }

        public synchronized Producto tomarProducto() throws InterruptedException {
            while (productos.isEmpty()) {
                wait();
            }
            Producto producto = productos.remove(0);
            System.out.println("Despachador ha tomado un producto de la bodega.");
            notifyAll();
            return producto;
        }
}
