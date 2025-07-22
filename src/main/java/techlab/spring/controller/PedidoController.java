package techlab.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import techlab.spring.entity.Pedido;
import techlab.spring.exceptions.ProductNoFoundException;
import techlab.spring.exceptions.StockInsuficienteException;
import techlab.spring.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("/")
    public ResponseEntity<Pedido> crearPedido(@PathVariable Long idProducto, @PathVariable int cantidad) {

        try {

            return ResponseEntity.status(HttpStatus.CREATED).body(this.pedidoService.crearPedido(idProducto, cantidad));
        } catch (ProductNoFoundException e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (StockInsuficienteException e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


}
