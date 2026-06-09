package com.polytech.commandes.isi.repository;

import com.polytech.commandes.isi.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
}
