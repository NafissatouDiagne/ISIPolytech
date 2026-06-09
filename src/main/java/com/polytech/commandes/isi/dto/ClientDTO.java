package com.polytech.commandes.isi.dto;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ClientDTO {
    private Long id;
    private String nom;
    private String email;
}
