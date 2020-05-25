package br.com.desafio.dao;

import br.com.desafio.domain.Marca;
import br.com.desafio.domain.Patrimonio;

import java.util.List;

public interface MarcaDao {

    void save(Marca marca);

    void update(Marca marca);

    void delete(Long id);

    Marca findById(Long id);

    List<Marca> findAll();

    List<Patrimonio> findByMarcaId(Long marcaid);


}