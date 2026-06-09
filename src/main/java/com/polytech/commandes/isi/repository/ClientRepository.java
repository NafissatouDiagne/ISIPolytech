package com.polytech.commandes.isi.repository;

import com.polytech.commandes.isi.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
