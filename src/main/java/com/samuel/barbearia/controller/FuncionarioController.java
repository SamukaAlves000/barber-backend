package com.samuel.barbearia.controller;

import com.samuel.barbearia.requests.funcionario.FuncionarioRequest;
import com.samuel.barbearia.requests.pessoa.PessoaRequest;
import com.samuel.barbearia.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("funcionarios")
@RequiredArgsConstructor
@Log4j2
@CrossOrigin(origins = "*")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @GetMapping(path = "/admin")
    public ResponseEntity<List<FuncionarioRequest>> findAll (){
        return new ResponseEntity<>(funcionarioService.findAll(), HttpStatus.OK);
    }
}
