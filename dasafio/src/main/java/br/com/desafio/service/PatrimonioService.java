package br.com.desafio.service;

import br.com.desafio.domain.Patrimonio;

import java.util.List;


public interface PatrimonioService {

    void save(Patrimonio patrimonio);

    void update(Long id, Patrimonio patrimonio);

    void delete(Long id);

    Patrimonio findById(Long id);

    List<Patrimonio> findAll();

}

