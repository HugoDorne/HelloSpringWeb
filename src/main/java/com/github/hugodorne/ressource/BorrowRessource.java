package com.github.hugodorne.ressource;

import com.github.hugodorne.model.BorrowEntity;
import com.github.hugodorne.repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/emprunt")
public class BorrowRessource {

    @Autowired
    private BorrowRepository empruntRepository;

    @GetMapping
    public List<BorrowEntity> list() {
        return empruntRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public BorrowEntity get(@PathVariable int id) {
        return empruntRepository.getById(id);
    }

}
