package com.polytech.commandes.isi.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProduitDTO {
    private Long id;
    private String nom;
    private BigDecimal prix;
    private Integer stock;
}
