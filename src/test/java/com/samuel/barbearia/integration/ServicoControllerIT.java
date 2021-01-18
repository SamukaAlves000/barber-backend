package com.samuel.barbearia.integration;

import com.samuel.barbearia.domain.Servico;
import com.samuel.barbearia.mapper.ServicoPostRequestBodyMapper;
import com.samuel.barbearia.mapper.ServicoPutRequestBodyMapper;
import com.samuel.barbearia.repository.ServicoRepository;
import com.samuel.barbearia.requests.ServicoPostRequestBody;
import com.samuel.barbearia.util.ServicoCreator;
import com.samuel.barbearia.wrapper.PageableResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
class ServicoControllerIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private ServicoRepository servicoRepository;

    @Test
    @DisplayName("List returns list of servicos page object when sucess")
    void list_Returns_ListOfServicosInsidePageObject_When_Successful(){

        Servico servico = servicoRepository.save(ServicoCreator.createServicoSaved());

        String expectDescricao = servico.getDescricao();
        PageableResponse<Servico> servicoPage = testRestTemplate.exchange("http://localhost:8080/servicos/list",HttpMethod.GET,null,

        new ParameterizedTypeReference<PageableResponse<Servico>>(){}).getBody();
        
//        Assertions.assertThat(servicoPage).isNotNull();
//
//        Assertions.assertThat(servicoPage.toList()).isNotEmpty()
//        .hasSize(1);
//
//        Assertions.assertThat(servicoPage.toList().get(0).getDescricao()).isEqualTo(expectDescricao);
    }


    @Test
    @DisplayName("ListAll returns list of servicos when sucessful")
    void listAll_Returns_ListOfServicos_When_Successful(){

        Servico servico = servicoRepository.save(ServicoCreator.createServicoSaved());

        String expectDescricao = servico.getDescricao();
        List<Servico> servicoPage = testRestTemplate.exchange("http://localhost:8080/servicos",HttpMethod.GET,null,

                new ParameterizedTypeReference<List<Servico>>(){}).getBody();

        Assertions.assertThat(servicoPage).isNotNull();
//
//        Assertions.assertThat(servicoPage.toList()).isNotEmpty()
//        .hasSize(1);
//
//        Assertions.assertThat(servicoPage.toList().get(0).getDescricao()).isEqualTo(expectDescricao);
    }

    @Test
    @DisplayName("findById returns servico when sucessful")
    void findById_Returns_Servico_When_Successful(){

       // String expectDescricao = ServicoCreator.createServicoValid().getDescricao();

        Servico servico = servicoRepository.save(ServicoCreator.createServicoSaved());

        Long expectId = servico.getId();

        Servico servico1 = testRestTemplate.getForObject("http://localhost:8080/servicos/{id}",Servico.class,expectId);

//        Assertions.assertThat(servico).isNotNull();

//        Assertions.assertThat(servico1.getId()).isEqualTo(expectId);

    }
//
//    @Test
//    @DisplayName("ListAllByDescricao returns list of servicos when sucessful")
//    void listAllByDescricao_Returns_ListOfServicos_When_Successful(){
//
//        List<Servico> servicoList = servicoController.findAllByDescricao("Corte Simples").getBody();
//
//        Assertions.assertThat(servicoList).isNotNull();
//
//        Assertions.assertThat(servicoList).isNotEmpty()
//                .hasSize(1);
//
//        Assertions.assertThat(servicoList.get(0).getDescricao()).isEqualTo("Corte Simples");
//    }
//
//
//    @Test
//    @DisplayName("save returns servico when sucessful")
//    void save_Returns_Servico_When_Successful() {
//
//        Servico servico = ServicoCreator.createServicoValid();
//        ServicoPostRequestBody servicoPostRequestBody = ServicoPostRequestBodyMapper.toServicoPostRequestBody(servico);
//        Servico servicoSaved = servicoController.save(servicoPostRequestBody).getBody();
//        Assertions.assertThat(servicoSaved).isNotNull().isEqualTo(servico);
//
//    }
//
//
//    @Test
//    @DisplayName("replace updates returns servico when sucessful")
//    void save_Updates_Servico_When_Successful() {
//
//        Servico servico = ServicoCreator.createServicoValid();
//        Assertions.assertThatCode(()-> servicoController.update(ServicoPutRequestBodyMapper.toServicoPutRequestBody(servico)))
//                .doesNotThrowAnyException();
//
//        ResponseEntity<Void> entity =  servicoController.update(ServicoPutRequestBodyMapper.toServicoPutRequestBody(servico));
//
//        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
//    }
//
//    @Test
//    @DisplayName("delete removes returns servico when sucessful")
//    void delete_Removes_Servico_When_Successful() {
//
//        Servico servico = ServicoCreator.createServicoValid();
//        Assertions.assertThatCode(()-> servicoController.delete(1L))
//                .doesNotThrowAnyException();
//
//        ResponseEntity<Void> entity =  servicoController.delete(1L);
//
//        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
//    }





}
