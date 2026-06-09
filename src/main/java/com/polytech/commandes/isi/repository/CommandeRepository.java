package com.polytech.commandes.isi.repository;

import com.polytech.commandes.isi.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
}
