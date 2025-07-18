package techlab.spring.service;

import org.springframework.stereotype.Service;
import techlab.spring.entity.Producto;
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
}
