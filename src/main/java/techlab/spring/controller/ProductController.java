package techlab.spring.controller;

import org.springframework.web.bind.annotation.*;
import techlab.spring.productos.Producto;

import java.util.ArrayList;

@RestController
@RequestMapping("/producto")
public class ProductController {

    private ArrayList<Producto> productos;

    public  ProductController() {
        this.productos = new ArrayList<>();
        agregarProdEjemplo();
    }

    @PostMapping("/")
    public String crearProducto(@RequestBody Producto producto) {
        return agregarProducto(producto);
    }

    @GetMapping("/list")//Seguir completando
    public ArrayList<Producto> listarProductos(){
        return this.productos;
    }

    @GetMapping("/find/{productId}")
    public String buscarProductoPorId(@PathVariable String productId){
        try {
            int id = Integer.parseInt(productId);
            return "buscando producto: " + id;
        }catch (NumberFormatException e){
            return "buscando nombre: "  + productId;
        }
    }

    public String agregarProducto(Producto producto){
        this.productos.add(producto);
        return "Se agregó correctamente el producto: " + producto.getId();
    }

    public void eliminarProducto(String productId){

    }

    public void agregarProdEjemplo(){
        this.productos.add(new Producto("monitor", 1000, 10));
        this.productos.add(new Producto("celular", 7000, 15));
        this.productos.add(new Producto("camara", 4000, 5));
    }
}
