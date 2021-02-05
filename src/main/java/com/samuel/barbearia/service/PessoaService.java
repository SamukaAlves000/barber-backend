package com.samuel.barbearia.service;

import com.samuel.barbearia.domain.Funcionario;
import com.samuel.barbearia.domain.Pessoa;
import com.samuel.barbearia.exception.BadRequestException;
import com.samuel.barbearia.mapper.pessoa.PessoaMapper;
import com.samuel.barbearia.repository.FuncionarioRepository;
import com.samuel.barbearia.repository.PessoaRepository;
import com.samuel.barbearia.requests.PessoaPostRequestBody;
import com.samuel.barbearia.requests.PessoaPutRequestBody;
import com.samuel.barbearia.requests.pessoa.PessoaRequest;
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

    public List<PessoaRequest> findAll (){
        List<PessoaRequest> list = pessoaRepository.findAll()
                .stream()
                .map(pessoa -> PessoaMapper.toPessoaRequest(pessoa))
                .collect(Collectors.toList());
        return list;
    }

    public Page<Pessoa> findAll (Pageable pageable){
        return pessoaRepository.findAll(pageable);
    }

    public PessoaRequest findById (Long id){
        return PessoaMapper.toPessoaRequest(pessoaRepository.findById(id).orElseThrow(() -> new BadRequestException("Pessoa not found")));
    }

    public PessoaRequest save (PessoaRequest pessoaRequest){
        Pessoa pessoa = pessoaRepository.save(PessoaMapper.toPessoa(pessoaRequest));
        return PessoaMapper.toPessoaRequest(pessoa);
    }

    public void delete (Long id){
        pessoaRepository.delete(PessoaMapper.toPessoa(this.findById(id)));
    }

    public void replace (PessoaRequest pessoaRequest){
        pessoaRepository.save(PessoaMapper.toPessoa(pessoaRequest));
    }

    public List<Pessoa> findAllByEmail(String email) {
        return pessoaRepository.findAllByEmail(email);
    }
}
