package techlab.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import techlab.spring.entity.Producto;

import java.util.ArrayList;

public interface ProductoRepositorio extends JpaRepository<Producto,Long> {
    ArrayList<Producto> findByNombreIgnoreCaseContaining(String nombre);
}
