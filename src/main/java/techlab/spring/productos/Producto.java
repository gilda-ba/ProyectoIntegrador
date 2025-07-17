package techlab.spring.productos;

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
}
