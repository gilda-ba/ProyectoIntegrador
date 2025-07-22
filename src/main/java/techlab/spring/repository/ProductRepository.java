package techlab.spring.repository;

import org.springframework.stereotype.Repository;
import techlab.spring.entity.Producto;

import java.util.ArrayList;
@Repository

public class ProductRepository {
    private ArrayList<Producto> productos;

    public ProductRepository(){
        productos = new ArrayList<>();
        agregarProdEjemplo();
    }

    public ArrayList<Producto> getTodosProductos(){
        return this.productos;
    }

    public String agregarProducto(Producto producto) {
        this.productos.add(producto);
        return "Producto agregado con id: " + producto.getId();
    }

    public void agregarProdEjemplo(){
        this.productos.add(new Producto("Kuromi peluche", 1000, 10));
        this.productos.add(new Producto("Naruto llavero", 7000, 15));
        this.productos.add(new Producto("Sasuke mochila", 4000, 5));
    }

    public ArrayList<Producto> buscarProducto(String busquedaProducto) {
        ArrayList<Producto> resultadoEncontrado = new ArrayList<>();
        for (Producto producto : this.productos) {
            if(producto.mismoNombre(busquedaProducto)) {
                resultadoEncontrado.add(producto);
            }
        }
        return resultadoEncontrado;
    }

    public Producto buscarId(long id){
        Producto productEncontrado = null;

        for (Producto producto : this.productos) {
            if (producto.mismoId(id)) {
                productEncontrado = producto;
            }
        }
        return productEncontrado;
    }

    public Producto eliminarProducto(Producto producto){
        Producto productoEliminado = buscarId(producto.getId());

            if (productoEliminado != null) {
                this.productos.remove(producto);
                System.out.println("Producto eliminado con id: " + producto.getId());
            }

        return productoEliminado;
    }
}
