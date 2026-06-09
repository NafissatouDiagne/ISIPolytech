package com.polytech.commandes.isi.controller;
import com.polytech.commandes.isi.dto.ProduitDTO;
import com.polytech.commandes.isi.service.ProduitServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
@RequiredArgsConstructor

public class ProduitController {
    private final ProduitServices produitServices;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProduitDTO create(@RequestBody ProduitDTO dto) {
        return produitServices.create(dto);
    }

    @GetMapping
    public List<ProduitDTO> getAll() {
        return produitServices.getAll();
    }

    @GetMapping("/{id}")
    public ProduitDTO getById(@PathVariable Long id) {
        return produitServices.getById(id);
    }

    @PutMapping("/{id}")
    public ProduitDTO update(@PathVariable Long id,
                             @RequestBody ProduitDTO dto) {

        return produitServices.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {

        produitServices.delete(id);
    }


}
