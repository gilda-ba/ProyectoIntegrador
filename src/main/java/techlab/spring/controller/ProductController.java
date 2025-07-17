package techlab.spring.controller;

import org.springframework.web.bind.annotation.*;
import techlab.spring.entity.Producto;
import techlab.spring.entity.Pedido;

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

    @GetMapping("/list")
    public void listarProductos(ArrayList<Producto> productos) {
        if (productos.isEmpty()){
        System.out.println("No existe el producto");
        }else {
            for (Producto producto : productos) {
                producto.mostrarInfo();
            }
        }
    }

    @GetMapping("/find/{productId}")
    public Producto buscarProductoPorId(@PathVariable Long productId){
        Producto product = null;
        for (Producto producto : productos) {
            if(producto.mismoId(productId)){
                product = producto;
            }
        }

        return product;
    }

    public String agregarProducto(Producto producto){
        this.productos.add(producto);
        return "Se agregó correctamente el producto: " + producto.getId();
    }

    @DeleteMapping("/{productId}")
    public Producto eliminarProducto(@PathVariable Long productId){
        Producto producto = this.buscarProductoPorId(productId);
        if(producto != null){
            this.productos.remove(producto);
        }
        return producto;
    }

    public void agregarProdEjemplo(){
        this.productos.add(new Producto("monitor", 1000, 10));
        this.productos.add(new Producto("celular", 7000, 15));
        this.productos.add(new Producto("camara", 4000, 5));
    }

    @PutMapping("/{id}")
    public Producto editarPrecioProducto(@PathVariable Long id,@RequestParam double nuevoPrecio){
        Producto producto = this.buscarProductoPorId(id);
        if(producto != null){
            producto.setPrecio(nuevoPrecio);
        }
        return producto;
    }
}
