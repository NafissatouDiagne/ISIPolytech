package com.polytech.commandes.isi.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@Entity
@Table(name = "produits")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String nom;

    @Column(nullable = false)
    private BigDecimal prix;

    @Builder.Default
    private Integer stock=0;


}
