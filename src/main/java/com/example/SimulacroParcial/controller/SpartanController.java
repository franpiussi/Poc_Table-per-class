package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.domain.Spartan;
import com.example.SimulacroParcial.repository.SpartanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/spartans")
public class SpartanController {

    private static final String SPARTAN_NOT_FOUND_id = "/ No existe el espartano con el id: %s";

    @Autowired
    private SpartanRepository spartanRepository;


    @GetMapping("")
    public List<Spartan> getSpartans(){
        return spartanRepository.findAll();
    }

    @PostMapping("")
    public void addSpartan(@RequestBody Spartan p){
        spartanRepository.save(p);
    }

    @GetMapping("/{id}")
    public Spartan getSpartan(@PathVariable("id") Integer id){
        return spartanRepository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void deleteSpartan(@PathVariable("id") Integer id){
        Spartan Spartan = spartanRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST,String.format(SPARTAN_NOT_FOUND_id,id)));
        spartanRepository.delete(Spartan);
    }
}
