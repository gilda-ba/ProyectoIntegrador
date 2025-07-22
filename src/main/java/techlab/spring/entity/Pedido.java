package techlab.spring.entity;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@Getter
@Setter
public class Pedido {

    private Long id;
    private ArrayList<LineaPedido> lineaPedidos;

    public Pedido(Long id) {
        this.id = id;
        this.lineaPedidos = new ArrayList<>();
    }


    public void agregarLineaPedido(LineaPedido linea) {
        if(linea != null) this.lineaPedidos.add(linea);
    }

    public double calcularCostoTotal() {
        double total = 0;

        for (LineaPedido lp : this.lineaPedidos) {
            total += lp.calcularTotal();
        }
        return total;
    }

//    public void disminuirStock(int cantidad) {
//
//        for (Producto producto : this.productos) {
//            producto.disminuirStock(cantidad);
//        }
//    }

    public void mostrarDatos() {
        System.out.println("+".repeat(25));
        System.out.println("Listando Pedido");
        System.out.println("Id de Pedido: " + this.id);
        System.out.println("Productos en pedido: " + getLineaPedidos().toString());
        calcularCostoTotal();
        System.out.println("+".repeat(25));
    }
}

