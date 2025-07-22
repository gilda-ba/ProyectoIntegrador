package techlab.spring.service;

import org.springframework.stereotype.Service;
import techlab.spring.DTO.ProductResponseDTO;
import techlab.spring.entity.Producto;
import techlab.spring.exceptions.ProductNoFoundException;
import techlab.spring.exceptions.StockInsuficienteException;
import techlab.spring.repository.ProductRepository;
import techlab.spring.repository.ProductoRepositorio;

import java.util.ArrayList;
@Service
public class ProductService {

    private ProductRepository repository;
    private ProductoRepositorio repositoryJpa;

    public ProductService(ProductRepository repo, ProductoRepositorio repositorio) {
        this.repository = repo;
        this.repositoryJpa = repositorio;
    }

    public ArrayList<Producto> listarProductos() {
       return this.repository.getTodosProductos();
    }

    public ProductResponseDTO agregarProducto(Producto producto) {
        this.repositoryJpa.save(producto);

        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setMensaje("Producto creado con exito. ID: " + producto.getId());

        return responseDTO;
    }

    public Producto buscarProductoPorId(Long id) {
//        Producto product = this.repository.buscarId(id);
//        if (product == null) {
//            throw new ProductNoFoundException("no encontrado el producto con id: " + id);
//        }else  {
//            return product;
//        }

        Producto productoEncontrado = this.repositoryJpa.findById(id).orElseThrow(()-> new  ProductNoFoundException(id.toString())) ;
        return productoEncontrado;
    }

    public ArrayList<Producto> buscarProductoPorNombre(String buscarProducto) {
        ArrayList<Producto> productosEncontrados = this.repositoryJpa.findByNombreIgnoreCaseContaining(buscarProducto);

        if(productosEncontrados.isEmpty()) throw new ProductNoFoundException(buscarProducto);

        return productosEncontrados;
    }

    public Producto editarProducto(Long id, Double precioNuevo) {
//        Producto producto = this.buscarProductoPorId(id);
//        if(producto != null){
//            producto.setPrecio(precioNuevo);
//            this.repositoryJpa.save(producto);
//        }
//        return producto;

        Producto encontrado = this.repositoryJpa.findById(id).orElseThrow(()-> new  ProductNoFoundException("No se pudo modificar")) ;
        encontrado.setPrecio(precioNuevo);
        this.repositoryJpa.save(encontrado);
        return encontrado;
    }

    public Producto borrarProducto(Long id) {
//        Producto productoABorrar = this.buscarProductoPorId(id);
//        if(productoABorrar != null) this.repositoryJpa.delete(productoABorrar);
//        return productoABorrar;

        Producto productoABorrar = this.repositoryJpa.findById(id).orElseThrow(()-> new  ProductNoFoundException("No se pudo borrar")) ;
        this.repositoryJpa.delete(productoABorrar);
        return productoABorrar;
    }

    public void disminuirStock(Long idProducto, int cantidad) {
        Producto producto = this.buscarProductoPorId(idProducto);
        if(producto.getStock() >= cantidad){
            producto.setStock(producto.getStock() - cantidad);
            this.repositoryJpa.save(producto);
        }else{
            throw new StockInsuficienteException("Stock insuficiente");
        }
    }
}
