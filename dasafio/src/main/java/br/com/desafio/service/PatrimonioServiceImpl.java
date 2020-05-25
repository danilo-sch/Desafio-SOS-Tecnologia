package br.com.desafio.service;

import br.com.desafio.dao.PatrimonioDao;
import br.com.desafio.domain.Patrimonio;
import br.com.desafio.exception.IdNaoValidoServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PatrimonioServiceImpl implements PatrimonioService{

    @Autowired
    private PatrimonioDao dao;

    @Override
    public void save(Patrimonio patrimonio) {
        dao.save(patrimonio);
    }

    @Override
    public void update(Long id, Patrimonio patrimonio) {
        patrimonio.setId(idValido(id));
        patrimonio.setId(id);
        dao.update(patrimonio);
    }

    @Override
    public void delete(Long id) {
        dao.delete(idValido(id));
    }

    @Override @Transactional (readOnly = true)
    public Patrimonio findById(Long id) {
        return dao.findById(idValido(id));
    }



    @Override @Transactional (readOnly = true)
    public List<Patrimonio> findAll() {
        return dao.findAll();

    }

    private Long idValido(Long id){
        if(id <= 0){
            throw new IdNaoValidoServiceException("Valor do id deve ser maior que zero!");
        }
        return id;
    }

}
