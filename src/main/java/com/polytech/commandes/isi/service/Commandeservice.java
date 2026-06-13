package com.polytech.commandes.isi.service;

import com.polytech.commandes.isi.dto.CommandeDTO;

import java.util.List;

public interface Commandeservice {

    CommandeDTO create(CommandeDTO dto);

    List<CommandeDTO> getAll();

    CommandeDTO getById(Long id);

    CommandeDTO update(Long id, CommandeDTO commdto);
    void delete(Long id);
}