package com.polytech.commandes.isi.controller;


import com.polytech.commandes.isi.dto.ClientDTO;
import com.polytech.commandes.isi.dto.CommandeDTO;
import com.polytech.commandes.isi.service.Commandeservice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
@RequiredArgsConstructor
public class CommandeController {
    private final Commandeservice commandeservice;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommandeDTO create(@RequestBody CommandeDTO commandedto)
    {
        return commandeservice.create(commandedto);
    }
    @GetMapping
    public List<CommandeDTO> getAll() {
        return commandeservice.getAll();
    }

    @GetMapping("/{id}")
    public CommandeDTO getById(@PathVariable Long id) {
        return commandeservice.getById(id);
    }

    @PutMapping("/{id}")
    public CommandeDTO update(@PathVariable Long id,
                            @RequestBody CommandeDTO commdto) {

        return commandeservice.update(id, commdto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {

        commandeservice.delete(id);
    }

}
