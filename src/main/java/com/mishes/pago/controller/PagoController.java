package com.mishes.pago.controller;

import com.mishes.pago.dto.ListaPagosClienteDTO;
import com.mishes.pago.dto.PagoRequestDTO;
import com.mishes.pago.dto.PagoResponseDTO;
import com.mishes.pago.service.PagoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pagos")
@RequiredArgsConstructor
public class PagoController {

    private final PagoService pagoService;

    @GetMapping
    public List<PagoResponseDTO> obtenerTodas() {
        return pagoService.obtenerTodas();
    }

    @GetMapping
    public List<PagoResponseDTO> obtenerPorClienteId(@RequestParam Long idCliente) {
        return pagoService.obtenerPorClienteId(idCliente);
    }

    @GetMapping
    public List<PagoResponseDTO> obtenerPorPedidoId(@RequestParam Long idPedido) {
        return pagoService.obtenerPorPedidoId(idPedido);
    }

    @PostMapping
    public ResponseEntity<PagoResponseDTO> guardar(@Valid @RequestBody PagoRequestDTO pago) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(pagoService.guardar(pago));
    }

    @PutMapping("{id}")
    public ResponseEntity<PagoResponseDTO> actualizarPorId(@PathVariable Long id, @Valid @RequestBody PagoRequestDTO pago) {
        return pagoService.actualizarPorId(id, pago)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
        pagoService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

    public ListaPagosClienteDTO listarPagosDeCliente(@RequestParam Long id) {
        return pagoService.listarPagosDeCliente(id);
    }

}
