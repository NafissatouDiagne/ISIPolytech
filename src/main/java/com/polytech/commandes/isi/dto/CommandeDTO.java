package com.polytech.commandes.isi.dto;

import com.polytech.commandes.isi.entity.StatutCommande;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CommandeDTO {
    private Long id;

    private Long clientId;

    private LocalDateTime dateCommande;

    private StatutCommande status;

    private List<LigneCommandeDTO> lignes;
}
