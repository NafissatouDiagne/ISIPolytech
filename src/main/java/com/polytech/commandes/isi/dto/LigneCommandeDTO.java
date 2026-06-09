package com.polytech.commandes.isi.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class LigneCommandeDTO {
    private Long produitId;

    private Integer quantite;
}
