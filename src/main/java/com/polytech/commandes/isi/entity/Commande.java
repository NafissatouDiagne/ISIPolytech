package com.polytech.commandes.isi.entity;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "commandes")
@Getter
@Setter
@Builder

public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateCommande;

    @Enumerated(EnumType.STRING)
    private StatutCommande status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "commande",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<LigneCommande> lignes;
}
