package com.samuel.barbearia.controller;

import com.samuel.barbearia.domain.Pessoa;
import com.samuel.barbearia.requests.PessoaPostRequestBody;
import com.samuel.barbearia.requests.PessoaPutRequestBody;
import com.samuel.barbearia.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("pessoas")
@RequiredArgsConstructor
@Log4j2
@CrossOrigin(origins = "*")
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping(path = "/admin/post")
    public ResponseEntity<Pessoa> save (@RequestBody PessoaPostRequestBody PessoaPostRequestBody){
        return new ResponseEntity<>(
                pessoaService.save(PessoaPostRequestBody), HttpStatus.CREATED);
    }

    @PutMapping(path = "/admin/put")
    public ResponseEntity<Void> update (@RequestBody PessoaPutRequestBody PessoaPutRequestBody){
        pessoaService.replace(PessoaPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/admin/delete/{id}")
    public ResponseEntity<Void> delete (@PathVariable  long id){
        pessoaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/admin/get")
    public ResponseEntity<List<PessoaPutRequestBody>> findAll (){
        return new ResponseEntity<>(pessoaService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/admin/get/page")
    public ResponseEntity<Page<Pessoa>> findAll (@ParameterObject Pageable pageble){
        return new ResponseEntity<>(pessoaService.findAll(pageble), HttpStatus.OK);
    }

    @GetMapping(path = "/admin/get/find")
    public ResponseEntity<List<Pessoa>> findAllByDescricao (@RequestParam String email){
        return new ResponseEntity<>(pessoaService.findAllByEmail(email), HttpStatus.OK);
    }

    @GetMapping(path = "/admin/get/{id}")
    public ResponseEntity<Pessoa> findById (@PathVariable  long id){
        return new ResponseEntity<>(pessoaService.findById(id), HttpStatus.OK);
    }

}
