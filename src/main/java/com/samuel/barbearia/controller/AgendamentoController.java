package com.samuel.barbearia.controller;

import com.samuel.barbearia.requests.agendamento.AgendamentoRequest;
import com.samuel.barbearia.service.AgendamentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/admin")
    public ResponseEntity<AgendamentoRequest> save (@RequestBody AgendamentoRequest agendamentoRequest){
        return new ResponseEntity<>(
                agendamentoService.save(agendamentoRequest), HttpStatus.CREATED);
    }
}
