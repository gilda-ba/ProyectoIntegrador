package techlab.spring.entity;

import java.util.function.DoubleToIntFunction;

public class Producto {
    private static int SIGUIENTE_ID = 1;
    private int ID;
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
        this.ID = SIGUIENTE_ID;
        SIGUIENTE_ID++;
        this.cantComprar = 1;
    }

    // Getters y setters
    public int getId() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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

    public int getCantComprar() {
        return cantComprar;
    }
}
