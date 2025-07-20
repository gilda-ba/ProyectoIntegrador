package techlab.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import techlab.spring.DTO.ProductResponseDTO;
import techlab.spring.entity.Producto;
import techlab.spring.exceptions.ProductNoFoundException;
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

    @GetMapping("/{productId}")
    public Producto buscarProductoPorId(@PathVariable Long productId){
        return this.service.buscarProductoPorId(productId);
    }

    @GetMapping("/find")
    public ResponseEntity<ArrayList<Producto>> buscarProductos(@RequestParam String busqueda){

        try {

            return ResponseEntity.status(HttpStatus.OK).body(this.service.buscarProductoPorNombre(busqueda));
        }catch (ProductNoFoundException e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public Producto editarPrecio(@PathVariable Long id, @RequestParam Double precioNuevo){
        return this.service.editarProducto(id, precioNuevo);
    }

    @DeleteMapping("/{productId}")
    public Producto eliminarProducto(@PathVariable Long productId){
        return this.service.borrarProducto(productId);
    }

}
