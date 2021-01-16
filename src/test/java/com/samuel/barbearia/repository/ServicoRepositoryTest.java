package com.samuel.barbearia.repository;

import com.samuel.barbearia.domain.Servico;
import com.samuel.barbearia.util.ServicoCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@DisplayName("Teste para o ServicoRepository")
class ServicoRepositoryTest {

    @Autowired
    private ServicoRepository servicoRepository;

    @Test
    @DisplayName("Save persiste Servico when successful")
    void save_PersisteServico_WhenSuccessFul(){

        Servico servico = ServicoCreator.createServicoSaved();
        Servico servicoSave =  this.servicoRepository.save(servico);

        Assertions.assertThat(servicoSave).isNotNull();

        Assertions.assertThat(servicoSave.getId()).isNotNull();

        Assertions.assertThat(servicoSave.getDescricao()).isEqualTo(servico.getDescricao());

        Assertions.assertThat(servicoSave.getValor()).isEqualTo(servico.getValor());

        Assertions.assertThat(servicoSave.getDuracao()).isEqualTo(servico.getDuracao());

    }


    @Test
    @DisplayName("Save updates Servico when successful")
    void save_UpdatesServico_WhenSuccessFul(){

        Servico servicoSave =  this.servicoRepository.save(ServicoCreator.createServicoSaved());

        servicoSave.setDescricao("Corte simples 2");
        Servico servicoUpdate = this.servicoRepository.save(servicoSave);

        Assertions.assertThat(servicoSave).isNotNull();

        Assertions.assertThat(servicoSave.getId()).isNotNull();

        Assertions.assertThat(servicoUpdate.getDescricao()).isEqualTo("Corte simples 2");

        Assertions.assertThat(servicoSave.getValor()).isEqualTo(servicoUpdate.getValor());

        Assertions.assertThat(servicoSave.getDuracao()).isEqualTo(servicoUpdate.getDuracao());

    }


    @Test
    @DisplayName("Delete removes Servico when successful")
    void delete_RemovesServico_WhenSuccessFul(){

        Servico servicoSave =  this.servicoRepository.save(ServicoCreator.createServicoSaved());

        this.servicoRepository.delete(servicoSave);

        Optional<Servico> servico = this.servicoRepository.findById(servicoSave.getId());

        Assertions.assertThat(servico).isEmpty();

    }


    @Test
    @DisplayName("Find By name returns list of  Servico when successful")
    void findByName_ReturnListOfServico_WhenSuccessFul(){

        Servico servicoSave =  this.servicoRepository.save(ServicoCreator.createServicoSaved());

        List<Servico> servicos = servicoRepository.findAllByDescricao(servicoSave.getDescricao());

        Assertions.assertThat(servicos).isNotEmpty();

        Assertions.assertThat(servicos).contains(servicoSave);

    }

}