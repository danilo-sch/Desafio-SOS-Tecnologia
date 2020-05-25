package br.com.desafio.service;

import br.com.desafio.domain.Marca;
import br.com.desafio.domain.Patrimonio;

import java.util.List;

public interface MarcaService {

    void save(Marca marca);

    void update(Long id, Marca marca);

    void delete(Long id);

    Marca findById(Long id);

    List<Marca> findAll();

    List<Patrimonio> findByMarcaId(Long marcaid);

}

