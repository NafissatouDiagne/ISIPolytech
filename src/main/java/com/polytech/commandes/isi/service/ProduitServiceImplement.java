package com.polytech.commandes.isi.service;

import com.polytech.commandes.isi.dto.ProduitDTO;
import com.polytech.commandes.isi.entity.Produit;
import com.polytech.commandes.isi.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProduitServiceImplement implements ProduitServices {

    private final ProduitRepository produitRepository;

    @Override
    public ProduitDTO create(ProduitDTO proddto) {

        Produit produit = Produit.builder()
                .nom(proddto.getNom())
                .prix(proddto.getPrix())
                .stock(proddto.getStock())
                .build();

        produit = produitRepository.save(produit);

        return valueDTO(produit);
    }



    @Override
    public List<ProduitDTO> getAll() {
        return produitRepository.findAll()
                .stream()
                .map(this::valueDTO)
                .toList();
    }

    @Override
    public ProduitDTO getById(Long id) {

        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit introuvable"));

        return valueDTO(produit);
    }

    @Override
    public ProduitDTO update(Long id, ProduitDTO dto) {

        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit introuvable"));

        produit.setNom(dto.getNom());
        produit.setPrix(dto.getPrix());
        produit.setStock(dto.getStock());

        produit = produitRepository.save(produit);

        return valueDTO(produit);
    }

    @Override
    public void delete(Long id) {
        produitRepository.deleteById(id);
    }

    private ProduitDTO valueDTO(Produit produit) {

        return ProduitDTO.builder()
                .id(produit.getId())
                .nom(produit.getNom())
                .prix(produit.getPrix())
                .stock(produit.getStock())
                .build();
    }
}