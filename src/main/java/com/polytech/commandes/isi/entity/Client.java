package com.polytech.commandes.isi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "client")
    private List<Commande> commandes;

  /*  @OneToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;*/
}
