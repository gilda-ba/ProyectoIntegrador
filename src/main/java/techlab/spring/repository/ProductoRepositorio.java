package techlab.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import techlab.spring.entity.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto,Long> { }
