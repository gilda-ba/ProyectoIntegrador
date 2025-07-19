package techlab.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import techlab.spring.DTO.ProductResponseDTO;
import techlab.spring.entity.Producto;
import techlab.spring.entity.Pedido;
import techlab.spring.service.ProductService;

import java.util.ArrayList;

@RestController
@RequestMapping("/producto")
public class ProductController {

    private ProductService service;

    public  ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<ProductResponseDTO> crearProducto(@RequestBody Producto producto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.agregarProducto(producto));
    }

    @GetMapping("/list")
    public ArrayList<Producto> listarProductos() {
       return this.service.listarProductos();
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

    @PutMapping("/{id}")
    public Producto editarPrecioProducto(@PathVariable Long id,@RequestParam double nuevoPrecio){
        Producto producto = this.buscarProductoPorId(id);
        if(producto != null){
            producto.setPrecio(nuevoPrecio);
        }
        return producto;
    }
}
