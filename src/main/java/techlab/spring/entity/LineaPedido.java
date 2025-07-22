package techlab.spring.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LineaPedido {

    private Producto producto;
    private int cantAComprar;

    public LineaPedido(Producto producto, int cantAComprar) {
        this.producto = producto;
        this.cantAComprar = cantAComprar;
    }

    public double calcularTotal(){
        return this.producto.getPrecio() * this.cantAComprar;
    }
}
