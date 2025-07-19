package techlab.spring.service;

import org.springframework.stereotype.Service;
import techlab.spring.DTO.ProductResponseDTO;
import techlab.spring.entity.Producto;
import techlab.spring.exceptions.ProductNoFoundException;
import techlab.spring.repository.ProductRepository;

import java.util.ArrayList;
@Service
public class ProductService {

    private ProductRepository repository;

    public ProductService(ProductRepository repo) {
        this.repository = repo;
    }

    public ArrayList<Producto> listarProductos() {
       return this.repository.getTodosProductos();
    }

    public ProductResponseDTO agregarProducto(Producto producto) {
        String mensaje = this.repository.agregarProducto(producto);

        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setMensaje(mensaje);
        return responseDTO;
    }

    public Producto buscarProductoPorId(long id) {
        Producto product = this.repository.buscarId(id);

        if (product == null) {
            throw new ProductNoFoundException("no encontrado el producto con id: " + id);
        }else  {
            return product;
        }
    }

    public ArrayList<Producto> buscarProductoPorNombre(String buscarProducto) {
        ArrayList<Producto> productosEncontrados = this.repository.buscarProducto(buscarProducto);

        if(productosEncontrados.isEmpty()) throw new ProductNoFoundException(buscarProducto);

        return productosEncontrados;
    }
}
