package com.samuel.barbearia.controller;

import com.samuel.barbearia.requests.funcionario.FuncionarioRequest;
import com.samuel.barbearia.requests.pessoa.PessoaRequest;
import com.samuel.barbearia.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("funcionarios")
@RequiredArgsConstructor
@Log4j2
@CrossOrigin(origins = "*")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @PostMapping(path = "/admin")
    public ResponseEntity<FuncionarioRequest> save (@RequestBody FuncionarioRequest funcionarioRequest){
        return new ResponseEntity<>(
                funcionarioService.save(funcionarioRequest), HttpStatus.CREATED);
    }

    @PutMapping(path = "/admin")
    public ResponseEntity<Void> update (@RequestBody FuncionarioRequest  funcionarioRequest){
        funcionarioService.replace(funcionarioRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/admin/{id}")
    public ResponseEntity<Void> delete (@PathVariable  long id){
        funcionarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/admin")
    public ResponseEntity<List<FuncionarioRequest>> findAll (){
        return new ResponseEntity<>(funcionarioService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/admin/{id}")
    public ResponseEntity<FuncionarioRequest> findById (@PathVariable  long id){
        return new ResponseEntity<>(funcionarioService.findById(id), HttpStatus.OK);
    }
}
