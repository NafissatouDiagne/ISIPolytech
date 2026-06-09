package com.polytech.commandes.isi.service;

import com.polytech.commandes.isi.dto.ClientDTO;

import java.util.List;

public interface ClientService {
   ClientDTO create(ClientDTO clientdto);
   List<ClientDTO> getAll();
   ClientDTO getById(Long id);
   ClientDTO update(Long id,ClientDTO clientDTO);

   void delete(Long id);
}
