package com.github.hugodorne.ressource;

import com.github.hugodorne.model.LivreEntity;
import com.github.hugodorne.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/livre")
public class LivreRessource {

    @Autowired
    private LivreRepository livreRepository;

    @GetMapping
    public List<LivreEntity> list() {
        return livreRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public LivreEntity get(@PathVariable int id) {
        return livreRepository.getById(id);
    }

}
