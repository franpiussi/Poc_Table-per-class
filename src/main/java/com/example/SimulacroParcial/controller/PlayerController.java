package com.example.SimulacroParcial.controller;


import com.example.SimulacroParcial.domain.Player;
import com.example.SimulacroParcial.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private static final String PLAYER_NOT_FOUND_id = "/ No existe el equipo con el id: %s";

    @Autowired
    private PlayerRepository playerRepository;


    @GetMapping("")
    public List<Player>  getPlayers(){
        return playerRepository.findAll();
    }

    @PostMapping("")
    public void addPlayer(@RequestBody Player p){
        playerRepository.save(p);
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable("id") Integer id){
        return playerRepository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable("id") Integer id){
        Player player = playerRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST,String.format(PLAYER_NOT_FOUND_id,id)));
        playerRepository.delete(player);
    }
}
