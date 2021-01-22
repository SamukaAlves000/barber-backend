package com.samuel.barbearia.controller;

import com.samuel.barbearia.domain.Servico;
import com.samuel.barbearia.requests.ServicoPostRequestBody;
import com.samuel.barbearia.requests.ServicoPutRequestBody;
import com.samuel.barbearia.service.ServicoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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

    @PostMapping(path = "/admin/post")
    public ResponseEntity<Servico> save (@RequestBody @Valid ServicoPostRequestBody servicoPostRequestBody){
        return new ResponseEntity<>(servicoService.save(servicoPostRequestBody), HttpStatus.CREATED);
    }

    @PutMapping(path = "/admin/put")
    public ResponseEntity<Void> update (@RequestBody ServicoPutRequestBody servicoPutRequestBody){
        servicoService.replace(servicoPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/admin/delete/{id}")
    public ResponseEntity<Void> delete (@PathVariable  long id){
        servicoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/admin/get")
    public ResponseEntity<List<Servico>> findAll (){
        return new ResponseEntity<>(servicoService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/admin/get/page")
    public ResponseEntity<Page<Servico>> findAll (@ParameterObject Pageable pageble){
        return new ResponseEntity<>(servicoService.findAll(pageble), HttpStatus.OK);
    }

    @GetMapping(path = "/admin/get/find")
    public ResponseEntity<List<Servico>> findAllByDescricao (@RequestParam String descricao){
        return new ResponseEntity<>(servicoService.findAllByDescricao(descricao), HttpStatus.OK);
    }

    @GetMapping(path = "/admin/get/{id}")
    public ResponseEntity<Servico> findById (@PathVariable  long id){
        return new ResponseEntity<>(servicoService.findById(id), HttpStatus.OK);
    }

//    @GetMapping(path = "/admin/get/auth/{id}")
//    public ResponseEntity<Servico> findByIdAuthPrincipal (@PathVariable  long id, @AuthenticationPrincipal UserDetails userDetails){
//        log.info(userDetails);
//        return new ResponseEntity<>(servicoService.findById(id), HttpStatus.OK);
//    }

}
