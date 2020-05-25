package br.com.desafio.service;

import br.com.desafio.dao.MarcaDao;
import br.com.desafio.domain.Marca;
import br.com.desafio.domain.Patrimonio;
import br.com.desafio.exception.IdNaoValidoServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    private MarcaDao dao;

    @Override
    public void save(Marca marca) {
        dao.save(marca);
    }

    @Override
    public void update(Long id, Marca marca) {
        marca.setId(idValido(id));
        marca.setId(id);
        dao.update(marca);
    }

    @Override
    public void delete(Long id) {
        dao.delete(idValido(id));
    }

    @Override @Transactional(readOnly = true)
    public Marca findById(Long id) {
        return dao.findById(idValido(id));
    }

    @Override @Transactional (readOnly = true)
    public List<Marca> findAll() {
        return dao.findAll();

    }

    @Override //@Transactional (readOnly = true)
    public List<Patrimonio> findByMarcaId(Long marcaid) {
        System.out.println("teste2");
        return dao.findByMarcaId(marcaid);
    }

    private Long idValido(Long id){
        if(id <= 0){
            throw new IdNaoValidoServiceException("Valor do id deve ser maior que zero!");
        }
        return id;
    }
}

