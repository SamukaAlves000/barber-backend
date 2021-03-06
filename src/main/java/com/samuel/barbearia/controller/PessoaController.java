package com.samuel.barbearia.controller;

import com.samuel.barbearia.domain.Pessoa;
import com.samuel.barbearia.requests.pessoa.PessoaRequest;
import com.samuel.barbearia.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pessoas")
@RequiredArgsConstructor
@Log4j2
@CrossOrigin(origins = "*")
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping(path = "/admin")
    public ResponseEntity<PessoaRequest> save (@RequestBody PessoaRequest pessoaRequest){
        return new ResponseEntity<>(
                pessoaService.save(pessoaRequest), HttpStatus.CREATED);
    }

    @PutMapping(path = "/admin")
    public ResponseEntity<Void> update (@RequestBody PessoaRequest pessoaRequest){
        pessoaService.replace(pessoaRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/admin/{id}")
    public ResponseEntity<Void> delete (@PathVariable  long id){
        pessoaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/admin")
    public ResponseEntity<List<PessoaRequest>> findAll (){
        return new ResponseEntity<>(pessoaService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/admin/{id}")
    public ResponseEntity<PessoaRequest> findById (@PathVariable  long id){
        return new ResponseEntity<>(pessoaService.findById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/admin/page")
    public ResponseEntity<Page<Pessoa>> findAll (@ParameterObject Pageable pageble){
        return new ResponseEntity<>(pessoaService.findAll(pageble), HttpStatus.OK);
    }

    @GetMapping(path = "/admin/find")
    public ResponseEntity<List<Pessoa>> findAllByDescricao (@RequestParam String email){
        return new ResponseEntity<>(pessoaService.findAllByEmail(email), HttpStatus.OK);
    }


}
