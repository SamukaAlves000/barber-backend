package com.samuel.barbearia.controller;

import com.samuel.barbearia.requests.agendamento.AgendamentoRequest;
import com.samuel.barbearia.requests.funcionario.FuncionarioRequest;
import com.samuel.barbearia.service.AgendamentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("agendamentos")
@RequiredArgsConstructor
@Log4j2
@CrossOrigin(origins = "*")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @GetMapping(path = "/admin")
    public ResponseEntity<List<AgendamentoRequest>> findAll (){
        return new ResponseEntity<>(agendamentoService.findAll(), HttpStatus.OK);
    }
    @GetMapping(path = "/admin/status")
    public ResponseEntity<List<AgendamentoRequest>> findAllStatus (@RequestParam String status){
        return new ResponseEntity<>(agendamentoService.findAllStatus(status), HttpStatus.OK);
    }

    @PostMapping(path = "/admin")
    public ResponseEntity<AgendamentoRequest> save (@RequestBody AgendamentoRequest agendamentoRequest){
        return new ResponseEntity<>(
                agendamentoService.save(agendamentoRequest), HttpStatus.CREATED);
    }

    @PutMapping(path = "/admin")
    public ResponseEntity<AgendamentoRequest> update (@RequestBody AgendamentoRequest agendamentoRequest){
        this.agendamentoService.save(agendamentoRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/admin/agendados")
    public ResponseEntity<List<LocalDateTime>> findHorarios (@RequestParam String data){
        return new ResponseEntity<>(agendamentoService.findHorarios(data), HttpStatus.OK);
    }

    @GetMapping(path = "/admin/{id}")
    public ResponseEntity<AgendamentoRequest> findById (@PathVariable  long id){
        return new ResponseEntity<>(agendamentoService.findById(id), HttpStatus.OK);
    }
}
