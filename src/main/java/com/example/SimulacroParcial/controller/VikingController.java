package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.domain.Viking;
import com.example.SimulacroParcial.repository.VikingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/vikings")
public class VikingController {
    
    private static final String VIKING_NOT_FOUND_id = "/ No existe el vikingo con el id: %s";

    @Autowired
    private VikingRepository vikingRepository;


    @GetMapping("")
    public List<Viking> getVikings(){
        return vikingRepository.findAll();
    }

    @PostMapping("")
    public void addViking(@RequestBody Viking p){
        vikingRepository.save(p);
    }

    @GetMapping("/{id}")
    public Viking getViking(@PathVariable("id") Integer id){
        return vikingRepository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void deleteViking(@PathVariable("id") Integer id){
        Viking viking = vikingRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST,String.format(VIKING_NOT_FOUND_id,id)));
        vikingRepository.delete(viking);
    }
}
