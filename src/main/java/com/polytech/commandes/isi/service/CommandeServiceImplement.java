package com.polytech.commandes.isi.service;

import com.polytech.commandes.isi.dto.CommandeDTO;
import com.polytech.commandes.isi.dto.LigneCommandeDTO;
import com.polytech.commandes.isi.entity.*;
import com.polytech.commandes.isi.repository.ClientRepository;
import com.polytech.commandes.isi.repository.CommandeRepository;
import com.polytech.commandes.isi.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommandeServiceImplement implements Commandeservice {

    private final CommandeRepository commandeRepository;
    private final ClientRepository clientRepository;
    private final ProduitRepository produitRepository;

    @Override
    public CommandeDTO create(CommandeDTO dto) {

        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        Commande commande = new Commande();
        commande.setDateCommande(LocalDateTime.now());
        commande.setStatus(StatutCommande.CREATED);
        commande.setClient(client);

        List<LigneCommande> lignes = new ArrayList<>();

        for (LigneCommandeDTO ligneDTO : dto.getLignes()) {

            Produit produit = produitRepository.findById(ligneDTO.getProduitId())
                    .orElseThrow(() -> new RuntimeException("Produit introuvable"));

            LigneCommande ligne = new LigneCommande();

            ligne.setProduit(produit);
            ligne.setQuantite(ligneDTO.getQuantite());

            // on sauvegarde le prix au moment de la commande
            ligne.setPrixUnitaire(produit.getPrix());

            ligne.setCommande(commande);

            lignes.add(ligne);
        }

        commande.setLignes(lignes);

        commande = commandeRepository.save(commande);

        return validateDTO(commande);
    }
    @Override
    public List<CommandeDTO> getAll() {

        return commandeRepository.findAll()
                .stream()
                .map(this::validateDTO)
                .toList();
    }

    @Override
    public CommandeDTO getById(Long id) {

        Commande commande = commandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande introuvable"));

        return validateDTO(commande);
    }

    @Override
    public CommandeDTO update(Long id, CommandeDTO commdto) {
        return null;
    }

    @Override
    public void delete(Long id) {

        commandeRepository.deleteById(id);
    }
    private CommandeDTO validateDTO(Commande commande) {

        List<LigneCommandeDTO> lignes = commande.getLignes()
                .stream()
                .map(l -> LigneCommandeDTO.builder()
                        .produitId(l.getProduit().getId())
                        .quantite(l.getQuantite())
                        .build())
                .toList();

        return CommandeDTO.builder()
                .id(commande.getId())
                .clientId(commande.getClient().getId())
                .dateCommande(commande.getDateCommande())
                .status(commande.getStatus())
                .lignes(lignes)
                .build();
    }

}