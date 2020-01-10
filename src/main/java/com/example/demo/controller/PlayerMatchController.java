package com.example.demo.controller;

import com.example.demo.dto.CharacterDTO;
import com.example.demo.dto.PlayerDTO;
import com.example.demo.dto.PlayerMatchDTO;
import com.example.demo.service.PlayerMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playermatch")
public class PlayerMatchController {
    private PlayerMatchService playerMatchService;

    @Autowired
    public PlayerMatchController(PlayerMatchService playerMatchService) {
        this.playerMatchService = playerMatchService;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> create(@RequestBody PlayerMatchDTO playerMatchDTO) {
        playerMatchService.save(playerMatchDTO);
        return new ResponseEntity<>("Create Complete", HttpStatus.OK);
    }

//    @GetMapping(value = "/get/{name:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<PlayerMatchDTO> get(@PathVariable String name) {
//        PlayerMatchDTO characterDTO = playerMatchService.findByName(name);
//        return new ResponseEntity<>(characterDTO, HttpStatus.OK);
//    }

//    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<CharacterDTO>> list() {
//        List<CharacterDTO> playerDTOList = characterService.findAll();
//        return new ResponseEntity<>(playerDTOList, HttpStatus.OK);
//    }

    @GetMapping(value = "/delete/{id:.+}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        playerMatchService.deleteById(Integer.parseInt(id));
        return new ResponseEntity<>("Delete complete", HttpStatus.OK);
    }

    @GetMapping(value = "/hightscore/")
    public ResponseEntity<String> update() {
        playerMatchService.update();
        return new ResponseEntity<>("Update highest score complete", HttpStatus.OK);
    }

    @GetMapping(value = "/data/")
    public ResponseEntity<String> data() {
        String data = playerMatchService.data();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
