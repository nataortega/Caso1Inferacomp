package p1;

public class Despachador extends Thread{
    private Bodega bodega;
    private int numProductores;
    private int productosPorProductor;
    private int numRepartidores;
    private int productosEntregados = 0;

    public Despachador(Bodega bodega, int numProductores, int productosPorProductor, int numRepartidores) {
        this.bodega = bodega;
        this.numProductores = numProductores;
        this.productosPorProductor = productosPorProductor;
        this.numRepartidores = numRepartidores;
    }

    public synchronized Producto tomarProducto() throws InterruptedException {
        if (productosEntregados >= numProductores * productosPorProductor) {
            return null; // Todos los productos han sido entregados
        }
        Producto producto = bodega.tomarProducto();
        productosEntregados++;
        return producto;
    }
}
