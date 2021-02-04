package com.samuel.barbearia.controller;

import com.samuel.barbearia.domain.Servico;
import com.samuel.barbearia.requests.servico.ServicoRequest;
import com.samuel.barbearia.service.ServicoService;
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
@RequestMapping("servicos")
@RequiredArgsConstructor
@Log4j2
@CrossOrigin(origins = "*")
public class ServicoController {

    private final ServicoService servicoService;

    @PostMapping(path = "/admin")
    public ResponseEntity<ServicoRequest> save (@RequestBody @Valid ServicoRequest servicoRequest){
        return new ResponseEntity<>(servicoService.save(servicoRequest), HttpStatus.CREATED);
    }

    @PutMapping(path = "/admin")
    public ResponseEntity<Void> update (@RequestBody ServicoRequest servicoRequest){
        servicoService.replace(servicoRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/admin/{id}")
    public ResponseEntity<Void> delete (@PathVariable  long id){
        servicoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/admin")
    public ResponseEntity<List<ServicoRequest>> findAll (){
        return new ResponseEntity<>(servicoService.findAllServicoRequest(), HttpStatus.OK);
    }

    @GetMapping(path = "/admin/page")
    public ResponseEntity<Page<Servico>> findAll (@ParameterObject Pageable pageble){
        return new ResponseEntity<>(servicoService.findAll(pageble), HttpStatus.OK);
    }

    @GetMapping(path = "/admin/find")
    public ResponseEntity<List<Servico>> findAllByDescricao (@RequestParam String descricao){
        return new ResponseEntity<>(servicoService.findAllByDescricao(descricao), HttpStatus.OK);
    }

    @GetMapping(path = "/admin/{id}")
    public ResponseEntity<ServicoRequest> findById (@PathVariable  long id){
        return new ResponseEntity<>(servicoService.findById(id), HttpStatus.OK);
    }

}
