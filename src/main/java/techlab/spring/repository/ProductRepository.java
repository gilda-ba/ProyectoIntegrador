package techlab.spring.repository;

import org.springframework.stereotype.Repository;
import techlab.spring.entity.Producto;

import java.util.ArrayList;
@Repository
public class ProductRepository {
    private ArrayList<Producto> productos;

    public ProductRepository(){
        productos = new ArrayList<>();
    }

    public ArrayList<Producto> getTodosProductos(){
        return productos;
    }
}
