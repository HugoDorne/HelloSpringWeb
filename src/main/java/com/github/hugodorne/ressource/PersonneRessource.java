package com.github.hugodorne.ressource;

import com.github.hugodorne.model.PersonneEntity;
import com.github.hugodorne.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/personne")
public class PersonneRessource {

    @Autowired
    private PersonneRepository personneRepository;

    @GetMapping
    public List<PersonneEntity> list() {
        return personneRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public PersonneEntity get(@PathVariable int id) {
        return personneRepository.getById(id);
    }

}
