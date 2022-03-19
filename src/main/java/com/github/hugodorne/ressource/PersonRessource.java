package com.github.hugodorne.ressource;

import com.github.hugodorne.model.PersonEntity;
import com.github.hugodorne.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/personne")
public class PersonRessource {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public List<PersonEntity> list() {
        return personRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public PersonEntity get(@PathVariable int id) {
        return personRepository.getById(id);
    }

}
