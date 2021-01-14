package com.samuel.barbearia.client;

import com.samuel.barbearia.domain.Servico;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {

        // GET

        // Entidade completa
        ResponseEntity<Servico> entity =  new RestTemplate().getForEntity("http://localhost:8080/servicos/1",Servico.class);
        log.info(entity);

        // Objeto
        Servico object =  new RestTemplate().getForObject("http://localhost:8080/servicos/1",Servico.class);
        log.info(object );

        // Objeto com params
        Servico object2 =  new RestTemplate().getForObject("http://localhost:8080/servicos/{id}",Servico.class,2);
        log.info(object2 );

        // Array
        Servico[] objects =  new RestTemplate().getForObject("http://localhost:8080/servicos",Servico[].class);
        log.info(Arrays.toString(objects));

        // Lista
        ResponseEntity <List<Servico>> listEntity =  new RestTemplate().exchange(
                "http://localhost:8080/servicos",
                 HttpMethod.GET, null,
                 new ParameterizedTypeReference<List<Servico>>() {});

        log.info(listEntity.getBody());


        // POST

        Servico servico = Servico.builder().descricao("Corte").duracao(20).valor(10).build();
       // Servico objetoSalvo = new RestTemplate().postForObject("http://localhost:8080/servicos",servico,Servico.class);
       // log.info(objetoSalvo);

        ResponseEntity <Servico> servicoSalvo =  new RestTemplate().exchange(
                "http://localhost:8080/servicos",
                HttpMethod.POST, new HttpEntity<>(servico),
                Servico.class);
        log.info(servicoSalvo.getBody());

        // PUT
        servicoSalvo.getBody().setDescricao("Corte Atualizado 2");
        ResponseEntity <Void> servicoUpdate =  new RestTemplate().exchange(
                "http://localhost:8080/servicos",
                HttpMethod.PUT, new HttpEntity<>(servicoSalvo.getBody()),
                Void.class);
        log.info(servicoUpdate);


        // DELETE
        ResponseEntity <Void> servicoDelete =  new RestTemplate().exchange(
                "http://localhost:8080/servicos/{id}",
                HttpMethod.DELETE, null,
                Void.class,1);
        log.info(servicoDelete);

    }
}
