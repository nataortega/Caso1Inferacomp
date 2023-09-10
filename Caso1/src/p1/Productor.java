package p1;

public class Productor extends Thread {
    private Bodega bodega;
    private int numProductos;

    public Productor(Bodega bodega, int numProductos) {
        this.bodega = bodega;
        this.numProductos = numProductos;
    }

    @Override
    public void run() {
        for (int i = 0; i < numProductos; i++) {
            Producto producto = new Producto();
            try {
                bodega.ponerProducto(producto);
                sleep(100); // Simular tiempo de producción
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
