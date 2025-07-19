package techlab.spring.entity;


import java.util.ArrayList;

public class Pedido {

    private int id;
    private int contadorId = 1;
    private ArrayList<Producto> productos;

    public Pedido() {
        this.id = contadorId;
        contadorId++;
        this.productos = new ArrayList<>();
    }

    public ArrayList<Producto> getProducto() {
        return this.productos;
    }

    public void agregarProductoAPedido(Producto producto) {
        if(producto != null) this.productos.add(producto);
    }

    public double calcularCostoTotal() {
        double total = 0;

        for (Producto lp : productos) {
            total += lp.getPrecio() * lp.getCantComprar();
        }
        return total;
    }

    public void disminuirStock(int cantidad) {

        for (Producto producto : this.productos) {
            producto.disminuirStock(cantidad);
        }
    }

    public void mostrarDatos() {
        System.out.println("+".repeat(25));
        System.out.println("Listando Pedido");
        System.out.println("Id de Pedido: " + this.id);
        System.out.println("Productos: " + getProducto().toString());
        calcularCostoTotal();
        System.out.println("+".repeat(25));
    }
}

