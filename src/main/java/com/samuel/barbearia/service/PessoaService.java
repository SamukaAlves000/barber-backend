package com.samuel.barbearia.service;

import com.samuel.barbearia.domain.Funcionario;
import com.samuel.barbearia.domain.Pessoa;
import com.samuel.barbearia.exception.BadRequestException;
import com.samuel.barbearia.mapper.PessoaMapper;
import com.samuel.barbearia.repository.FuncionarioRepository;
import com.samuel.barbearia.repository.PessoaRepository;
import com.samuel.barbearia.requests.PessoaPostRequestBody;
import com.samuel.barbearia.requests.PessoaPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final FuncionarioRepository funcionarioRepository;

    public List<PessoaPutRequestBody> findAll (){
        List<PessoaPutRequestBody> list = pessoaRepository.findAll()
                .stream()
                .map(pessoa -> PessoaMapper.toPessoaPutRequestBody(pessoa))
                .collect(Collectors.toList());
        return list;
    }

    public Page<Pessoa> findAll (Pageable pageable){
        return pessoaRepository.findAll(pageable);
    }

    public Pessoa findById (Long id){
        return pessoaRepository.findById(id).orElseThrow(() -> new BadRequestException("Anime not found"));
    }

    public Pessoa save (PessoaPostRequestBody p){

        Pessoa pessoa = new Pessoa().builder()
                .cidade(p.getCidade())
                .cpf(p.getCpf())
                .dataNasc(p.getDataNasc())
                .email(p.getEmail())
                .fone(p.getFone())
                .sexo(p.getSexo())
                .uf(p.getUf())
                .nome(p.getNome())
                .build();

       Pessoa pessoaSaved = pessoaRepository.save(pessoa);

        if(pessoaSaved.getId() != null) {
            Funcionario funcionario = new Funcionario()
                    .builder()
                    .salario(p.getFuncionario().getSalario())
                    .pessoa(pessoaSaved)
                    .build();
            pessoaSaved.setFuncionario(funcionario);
            funcionarioRepository.save(funcionario);

        }

        return pessoaSaved;
    }

    public void delete (Long id){
        pessoaRepository.delete(this.findById(id));
    }

    public void replace (PessoaPutRequestBody pessoaPutRequestBody){
        pessoaRepository.save(PessoaMapper.toPessoa(pessoaPutRequestBody));
    }

    public List<Pessoa> findAllByEmail(String email) {
        return pessoaRepository.findAllByEmail(email);
    }
}
