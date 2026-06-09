package com.polytech.commandes.isi.entity;

import jakarta.persistence.OneToOne;

public class Utilisateur {
    @OneToOne(mappedBy = "utilisateur")
    private Client client;
}
