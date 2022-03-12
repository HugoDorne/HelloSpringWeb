package com.github.hugodorne.ressource;

import com.github.hugodorne.model.EmpruntEntity;
import com.github.hugodorne.repository.EmpruntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/emprunt")
public class EmpruntRessource {

    @Autowired
    private EmpruntRepository empruntRepository;

    @GetMapping
    public List<EmpruntEntity> list() {
        return empruntRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public EmpruntEntity get(@PathVariable int id) {
        return empruntRepository.getById(id);
    }

}
