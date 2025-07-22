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
        try{

        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.agregarProducto(producto));
        }catch (ProductNoFoundException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ProductResponseDTO());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<ArrayList<Producto>> listarProductos() {
       ArrayList<Producto> productos =  this.service.listarProductos();
       return ResponseEntity.status(HttpStatus.OK).body(productos);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Producto> buscarProductoPorId(@PathVariable Long productId){

        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.service.buscarProductoPorId(productId));
        }catch (ProductNoFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
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
    public ResponseEntity<Producto> editarPrecio(@PathVariable Long id, @RequestParam Double precioNuevo){
    try {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.editarProducto(id, precioNuevo ));
    }catch (ProductNoFoundException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> eliminarProducto(@PathVariable Long productId){
        try {
            this.service.borrarProducto(productId);
            ProductResponseDTO productoResponseDTO = new ProductResponseDTO();
            productoResponseDTO.setMensaje("Producto eliminado");
            return  ResponseEntity.status(HttpStatus.OK).body(productoResponseDTO);
        }catch (ProductNoFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
