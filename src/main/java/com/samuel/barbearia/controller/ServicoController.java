package com.samuel.barbearia.controller;

import com.samuel.barbearia.requests.servico.ServicoRequest;
import com.samuel.barbearia.service.ServicoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("servicos")
@RequiredArgsConstructor
@Log4j2
@CrossOrigin(origins = "*")
public class ServicoController {

    private final ServicoService servicoService;

    @PostMapping(path = "/admin")
    public ResponseEntity<ServicoRequest> save (@RequestBody ServicoRequest servicoRequest){
        return new ResponseEntity<>(servicoService.save(servicoRequest), HttpStatus.CREATED);
    }

    @GetMapping(path = "/admin")
    public ResponseEntity<List<ServicoRequest>> findAll (){
        return new ResponseEntity<>(servicoService.findAllServicoRequest(), HttpStatus.OK);
    }

    @GetMapping(path = "/admin/{id}")
    public ResponseEntity<ServicoRequest> findById (@PathVariable  long id){
        return new ResponseEntity<>(servicoService.findByIdServicoRequest(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/admin/{id}")
    public ResponseEntity<Void> delete (@PathVariable  long id){
        servicoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/admin")
    public ResponseEntity<Void> update (@RequestBody ServicoRequest servicoRequest){
        servicoService.save(servicoRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
