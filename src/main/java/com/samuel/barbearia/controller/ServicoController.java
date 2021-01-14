package com.samuel.barbearia.controller;

import com.samuel.barbearia.domain.Servico;
import com.samuel.barbearia.requests.ServicoPostRequestBody;
import com.samuel.barbearia.requests.ServicoPutRequestBody;
import com.samuel.barbearia.service.ServicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("servicos")
@RequiredArgsConstructor
public class ServicoController {

    private final ServicoService servicoService;

    @GetMapping
    private ResponseEntity<List<Servico>> findAll (){
        return new ResponseEntity<>(servicoService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/find")
    private ResponseEntity<List<Servico>> findAllByDescricao (@RequestParam String descricao){
        return new ResponseEntity<>(servicoService.findAllByDescricao(descricao), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    private ResponseEntity<Servico> findAl (@PathVariable  long id){
        return new ResponseEntity<>(servicoService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Servico> save (@RequestBody ServicoPostRequestBody servicoPostRequestBody){
        return new ResponseEntity<>(servicoService.save(servicoPostRequestBody), HttpStatus.CREATED);
    }

    @PutMapping
    private ResponseEntity<Servico> update (@RequestBody ServicoPutRequestBody servicoPutRequestBody){
        return new ResponseEntity<>(servicoService.replace(servicoPutRequestBody), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    private ResponseEntity<Void> delete (@PathVariable  long id){
        servicoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
