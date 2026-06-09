package com.polytech.commandes.isi.repository;

import com.polytech.commandes.isi.entity.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande,Long> {
}
