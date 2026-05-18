package com.mishes.pago.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "pago")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPag;

    @Column(nullable = false)
    private Long idPed;

    @Column(nullable = false)
    private Long idCli;

    @Column(nullable = false)
    private LocalDateTime fechaPago;

    @Column(nullable = false, precision = 10, secondPrecision = 2)
    private Double montoTotal;

    @OneToMany(mappedBy = "id_metodo_pago")
    @Column(nullable = false)
    private Short idMetodoPago;

}
