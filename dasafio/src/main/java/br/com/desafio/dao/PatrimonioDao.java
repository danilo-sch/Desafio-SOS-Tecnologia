package br.com.desafio.dao;

import br.com.desafio.domain.Patrimonio;

import java.util.List;

public interface PatrimonioDao {

    void save(Patrimonio patrimonio);

    void update(Patrimonio patrimonio);

    void delete(Long id);

    Patrimonio findById(Long id);


    List<Patrimonio> findAll();
}
