package techlab.spring.service;

import org.springframework.stereotype.Service;
import techlab.spring.entity.LineaPedido;
import techlab.spring.entity.Pedido;
import techlab.spring.entity.Producto;
import techlab.spring.exceptions.ProductNoFoundException;
import techlab.spring.exceptions.StockInsuficienteException;

@Service
public class PedidoService {
    private ProductService productService;
    private long idPedido = 1;

    PedidoService(ProductService productService) {
        this.productService = productService;
    }

    public Pedido crearPedido(Long prodId, int cantidad) {
        Producto producto = productService.buscarProductoPorId(prodId);
        if(producto.getStock() < cantidad){
            throw new StockInsuficienteException("Stock insuficiente");
        }
        Pedido pedidoNuevo = new Pedido(idPedido++);
        LineaPedido linea = new LineaPedido(producto, cantidad);
        pedidoNuevo.agregarLineaPedido(linea);
        pedidoNuevo.calcularCostoTotal();
        productService.disminuirStock(prodId, cantidad);

        return pedidoNuevo;
    }
}
