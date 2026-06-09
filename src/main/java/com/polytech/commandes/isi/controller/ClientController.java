package com.polytech.commandes.isi.controller;

import com.polytech.commandes.isi.dto.ClientDTO;
import com.polytech.commandes.isi.dto.ProduitDTO;
import com.polytech.commandes.isi.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor

public class ClientController {
    private final ClientService clientServices;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDTO create(@RequestBody ClientDTO cliendto) {
        return clientServices.create(cliendto);
    }

    @GetMapping
    public List<ClientDTO> getAll() {
        return clientServices.getAll();
    }

    @GetMapping("/{id}")
    public ClientDTO getById(@PathVariable Long id) {
        return clientServices.getById(id);
    }

    @PutMapping("/{id}")
    public ClientDTO update(@PathVariable Long id,
                             @RequestBody ClientDTO cliendto) {

        return clientServices.update(id, cliendto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {

        clientServices.delete(id);
    }


}
