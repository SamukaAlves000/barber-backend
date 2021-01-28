package com.samuel.barbearia.controller;

import com.samuel.barbearia.domain.Servico;
import com.samuel.barbearia.mapper.ServicoPostRequestBodyMapper;
import com.samuel.barbearia.mapper.ServicoPutRequestBodyMapper;
import com.samuel.barbearia.requests.ServicoPostRequestBody;
import com.samuel.barbearia.requests.ServicoPutRequestBody;
import com.samuel.barbearia.service.ServicoService;
import com.samuel.barbearia.util.ServicoCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
class ServicoControllerTest {

    @InjectMocks
    private ServicoController servicoController;
    @Mock
    private ServicoService servicoServiceMock;

    @BeforeEach
    void setUp(){

        PageImpl<Servico> servicoPage = new PageImpl<>(List.of(ServicoCreator.createServicoValid()));

        BDDMockito.when(this.servicoServiceMock.findAll(ArgumentMatchers.any()))
                .thenReturn(servicoPage);

        BDDMockito.when(this.servicoServiceMock.findAll())
                .thenReturn(List.of(ServicoCreator.createServicoValid()));

        BDDMockito.when(this.servicoServiceMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(ServicoCreator.createServicoValid());

        BDDMockito.when(this.servicoServiceMock.findAllByDescricao(ArgumentMatchers.anyString()))
                .thenReturn(List.of(ServicoCreator.createServicoValid()));

        BDDMockito.when(this.servicoServiceMock.save(ArgumentMatchers.any(ServicoPostRequestBody.class)))
                .thenReturn(ServicoCreator.createServicoValid());


        BDDMockito.doNothing().when(servicoServiceMock).replace(ArgumentMatchers.any(ServicoPutRequestBody.class));

        BDDMockito.doNothing().when(servicoServiceMock).delete(ArgumentMatchers.anyLong());
    }

    @Test
    @DisplayName("List returns list of servicos page object when sucess")
    void list_Returns_ListOfServicosInsidePageObject_When_Successful(){

            String expectDescricao = ServicoCreator.createServicoValid().getDescricao();
            Page<Servico> servicoPage = servicoController.findAll(null).getBody();

        Assertions.assertThat(servicoPage).isNotNull();

        Assertions.assertThat(servicoPage.toList()).isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(servicoPage.toList().get(0).getDescricao()).isEqualTo(expectDescricao);
    }


    @Test
    @DisplayName("ListAll returns list of servicos when sucessful")
    void listAll_Returns_ListOfServicos_When_Successful(){

        String expectDescricao = ServicoCreator.createServicoValid().getDescricao();
        List<Servico> servicoList = servicoController.findAll().getBody();

        Assertions.assertThat(servicoList).isNotNull();

        Assertions.assertThat(servicoList).isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(servicoList.get(0).getDescricao()).isEqualTo(expectDescricao);
    }

    @Test
    @DisplayName("findById returns servico when sucessful")
    void findById_Returns_Servico_When_Successful(){

        String expectDescricao = ServicoCreator.createServicoValid().getDescricao();
        Servico servico = servicoController.findById(1L).getBody();

        Assertions.assertThat(servico).isNotNull();

        Assertions.assertThat(servico.getDescricao()).isEqualTo(expectDescricao);
    }

    @Test
    @DisplayName("ListAllByDescricao returns list of servicos when sucessful")
    void listAllByDescricao_Returns_ListOfServicos_When_Successful(){

        List<Servico> servicoList = servicoController.findAllByDescricao("Corte Simples").getBody();

        Assertions.assertThat(servicoList).isNotNull();

        Assertions.assertThat(servicoList).isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(servicoList.get(0).getDescricao()).isEqualTo("Corte Simples");
    }


    @Test
    @DisplayName("save returns servico when sucessful")
    void save_Returns_Servico_When_Successful() {

        Servico servico = ServicoCreator.createServicoValid();
        ServicoPostRequestBody servicoPostRequestBody = ServicoPostRequestBodyMapper.toServicoPostRequestBody(servico);
        Servico servicoSaved = servicoController.save(servicoPostRequestBody).getBody();
        Assertions.assertThat(servicoSaved).isNotNull().isEqualTo(servico);

    }


    @Test
    @DisplayName("replace updates returns servico when sucessful")
    void save_Updates_Servico_When_Successful() {

        Servico servico = ServicoCreator.createServicoValid();
        Assertions.assertThatCode(()-> servicoController.update(ServicoPutRequestBodyMapper.toServicoPutRequestBody(servico)))
                .doesNotThrowAnyException();

        ResponseEntity<Void> entity =  servicoController.update(ServicoPutRequestBodyMapper.toServicoPutRequestBody(servico));

        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    @DisplayName("delete removes returns servico when sucessful")
    void delete_Removes_Servico_When_Successful() {

        Servico servico = ServicoCreator.createServicoValid();
        Assertions.assertThatCode(()-> servicoController.delete(1L))
                .doesNotThrowAnyException();

        ResponseEntity<Void> entity =  servicoController.delete(1L);

        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

}
