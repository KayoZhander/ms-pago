package com.mishes.pago.repository;

import com.mishes.pago.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pago, Long> {
}
