package com.github.hugodorne.ressource;

import com.github.hugodorne.model.UtilisateursEntity;
import com.github.hugodorne.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/utilisateur")
public class UtilisateurRessource {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @GetMapping
    public List<UtilisateursEntity> list() {
        return utilisateurRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public UtilisateursEntity get(@PathVariable int id) {
        return utilisateurRepository.getById(id);
    }

}
