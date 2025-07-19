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
    private Long ID;

    private String nombre;
    private double precio;
    private int stock;
    private int cantComprar;

    public Producto() {
        crearId();
    }

    public Producto(String name, double price, int stock) {
        setNombre(name);
        setPrecio(price);
        setStock(stock);
        this.crearId();
        this.cantComprar = 1;
    }

    // Getters y setters
    public int getId() {
        return ID;
    }

    public void crearId(){
        this.ID = SIGUIENTE_ID;
        SIGUIENTE_ID++;
    }

    public void mostrarInfo(){
        System.out.println("Datos:");
        System.out.println("ID: " + this.ID);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Precio: " + this.precio);
        System.out.println("Stock: " + this.stock);
    }

    public boolean mismoNombre(String buscqueda){
        String nombreMinuscula = this.nombre.toLowerCase();
        return nombreMinuscula.contains(buscqueda.toLowerCase());
    }
    public boolean mismoId(long id){
        return this.ID == id;
    }

    public void disminuirStock(int cantidad) {
        this.stock -= cantidad;
    }

}
