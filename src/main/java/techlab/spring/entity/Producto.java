package techlab.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Producto {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private double precio;
    private int stock;
    private int cantAComprar;

    public Producto() {}

    public Producto(String name, double price, int stock) {
        setNombre(name);
        setPrecio(price);
        setStock(stock);
        this.cantAComprar = 0;
    }


    public void mostrarInfo(){
        System.out.println("Datos:");
        System.out.println("ID: " + this.id);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Precio: " + this.precio);
        System.out.println("Stock: " + this.stock);
    }

    public boolean mismoNombre(String buscqueda){
        String nombreMinuscula = this.nombre.toLowerCase();
        return nombreMinuscula.contains(buscqueda.toLowerCase());
    }

    public boolean mismoId(long id){
        return this.id == id;
    }

    public void disminuirStock(int cantidad) {
        this.stock -= cantidad;
    }

}
