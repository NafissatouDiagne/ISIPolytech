package com.polytech.commandes.isi.service;

import com.polytech.commandes.isi.dto.ClientDTO;
import com.polytech.commandes.isi.dto.ProduitDTO;
import com.polytech.commandes.isi.entity.Client;
import com.polytech.commandes.isi.entity.Produit;
import com.polytech.commandes.isi.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServicesImplement implements ClientService{
    private final ClientRepository clientRepository;

    @Override
    public ClientDTO create (ClientDTO clientDTO){
        Client client = Client.builder()
                .nom(clientDTO.getNom())
                .email(clientDTO.getEmail())
                .build();

        client = clientRepository.save(client);
        return valueDTO(client);
    }

    @Override
    public List<ClientDTO> getAll() {
        return clientRepository.findAll()
                .stream()
                .map(this::valueDTO)
                .toList();
    }
    @Override
    public ClientDTO getById(Long id) {

        Client client = clientRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Client introuvable"));

        return valueDTO(client);
    }

    @Override
    public ClientDTO update(Long id, ClientDTO dto) {

        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        client.setNom(dto.getNom());
        client.setEmail(dto.getEmail());


        client = clientRepository.save(client);

        return valueDTO(client);
    }
    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    private ClientDTO valueDTO(Client client) {

        return ClientDTO.builder()
                .id(client.getId())
                .nom(client.getNom())
                .email(client.getEmail())
                .build();
    }
}
