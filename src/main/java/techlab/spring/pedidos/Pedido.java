package techlab.spring.pedidos;

import java.util.ArrayList;

public class Pedido {

    private int id;
    private ArrayList<LineaPedido> lineasPedido;
    private double total;

    public Pedido(int id) {
        this.id = id;
        this.lineasPedido = new ArrayList<>();
        this.total = 0;
    }

    // Operador relacional: verifica si la lista está vacía
    public boolean tieneItems() {
        return !lineasPedido.isEmpty();
    }

    // Operador aritmético para calcular el total
    public void calcularTotal() {
        double totalCalculado = 0;
        for (LineaPedido linea : lineasPedido) {
            totalCalculado += linea.getSubtotal();
        }
        this.total = totalCalculado;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<LineaPedido> getLineasPedido() {
        return lineasPedido;
    }

    public void setLineasPedido(ArrayList<LineaPedido> lineasPedido) {
        this.lineasPedido = lineasPedido;
    }

    public double getTotal() {
        return total;
    }
}
