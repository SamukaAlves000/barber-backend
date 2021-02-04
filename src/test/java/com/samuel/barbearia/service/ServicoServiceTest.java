package com.samuel.barbearia.service;

import com.samuel.barbearia.domain.Servico;
import com.samuel.barbearia.mapper.ServicoPostRequestBodyMapper;
import com.samuel.barbearia.mapper.ServicoPutRequestBodyMapper;
import com.samuel.barbearia.repository.ServicoRepository;
import com.samuel.barbearia.requests.ServicoPostRequestBody;
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
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
class ServicoServiceTest {

    @InjectMocks
    private ServicoService servicoService;
    @Mock
    private ServicoRepository servicoRepositoryMock;

    @BeforeEach
    void setUp(){

        BDDMockito.when(this.servicoRepositoryMock.findAll())
                .thenReturn(List.of(ServicoCreator.createServicoValid()));

        BDDMockito.when(this.servicoRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(ServicoCreator.createServicoValid()));

        BDDMockito.when(this.servicoRepositoryMock.findAllByDescricao(ArgumentMatchers.anyString()))
                .thenReturn(List.of(ServicoCreator.createServicoValid()));

        BDDMockito.when(this.servicoRepositoryMock.save(ArgumentMatchers.any(Servico.class)))
                .thenReturn(ServicoCreator.createServicoValid());

        BDDMockito.doNothing().when(servicoRepositoryMock).delete(ArgumentMatchers.any(Servico.class));
    }



    @Test
    @DisplayName("ListAll returns list of servicos when sucessful")
    void listAll_Returns_ListOfServicos_When_Successful(){

        String expectDescricao = ServicoCreator.createServicoValid().getDescricao();
        List<Servico> servicoList = servicoService.findAll();

        Assertions.assertThat(servicoList).isNotNull();

        Assertions.assertThat(servicoList).isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(servicoList.get(0).getDescricao()).isEqualTo(expectDescricao);
    }

    @Test
    @DisplayName("findById returns servico when sucessful")
    void findById_Returns_Servico_When_Successful(){

//        String expectDescricao = ServicoCreator.createServicoValid().getDescricao();
//        Servico servico = servicoService.findById(1L);
//
//        Assertions.assertThat(servico).isNotNull();
//
//        Assertions.assertThat(servico.getDescricao()).isEqualTo(expectDescricao);
    }

    @Test
    @DisplayName("ListAllByDescricao returns list of servicos when sucessful")
    void listAllByDescricao_Returns_ListOfServicos_When_Successful(){

        List<Servico> servicoList = servicoService.findAllByDescricao("Corte Simples");

        Assertions.assertThat(servicoList).isNotNull();

        Assertions.assertThat(servicoList).isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(servicoList.get(0).getDescricao()).isEqualTo("Corte Simples");
    }


    @Test
    @DisplayName("save returns servico when sucessful")
    void save_Returns_Servico_When_Successful() {

//        Servico servico = ServicoCreator.createServicoValid();
//        ServicoPostRequestBody servicoPostRequestBody = ServicoPostRequestBodyMapper.toServicoPostRequestBody(servico);
//        Servico servicoSaved = servicoService.save(servicoPostRequestBody);
//        Assertions.assertThat(servicoSaved).isNotNull().isEqualTo(servico);

    }


    @Test
    @DisplayName("replace updates returns servico when sucessful")
    void save_Updates_Servico_When_Successful() {

//        Servico servico = ServicoCreator.createServicoValid();
//        Assertions.assertThatCode(()-> servicoService.replace(ServicoPutRequestBodyMapper.toServicoPutRequestBody(servico)))
//                .doesNotThrowAnyException();


    }

    @Test
    @DisplayName("delete removes returns servico when sucessful")
    void delete_Removes_Servico_When_Successful() {

        Servico servico = ServicoCreator.createServicoValid();
        Assertions.assertThatCode(()-> servicoService.delete(1L))
                .doesNotThrowAnyException();
    }

}
