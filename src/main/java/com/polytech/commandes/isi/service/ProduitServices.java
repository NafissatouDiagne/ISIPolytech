package com.polytech.commandes.isi.service;

import com.polytech.commandes.isi.dto.ProduitDTO;

import java.util.List;

public interface ProduitServices {
    List<ProduitDTO> getAll();
    ProduitDTO create(ProduitDTO proddto);


    ProduitDTO getById(Long id);
    ProduitDTO update(Long id, ProduitDTO produitDTO);

    void delete(Long id);


}
