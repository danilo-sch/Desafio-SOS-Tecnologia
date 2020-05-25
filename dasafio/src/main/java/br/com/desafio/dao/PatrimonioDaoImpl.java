package br.com.desafio.dao;

import br.com.desafio.domain.Patrimonio;
import br.com.desafio.exception.NaoExisteDaoException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PatrimonioDaoImpl implements PatrimonioDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Patrimonio patrimonio) {

        entityManager.persist(patrimonio);
    }

    @Override
    public void update(Patrimonio patrimonio) {

        entityManager.merge(patrimonio);
    }

    @Override
    public void delete(Long id) {
        try{
            entityManager.remove(entityManager.getReference(Patrimonio.class, id));
        }catch (EntityNotFoundException ex){
            throw new NaoExisteDaoException("Patrimonio não encontrado!");
        }

    }

    @Override
    public Patrimonio findById(Long id) {
        Patrimonio patrimonio = entityManager.find(Patrimonio.class, id);
        if(patrimonio == null){
            throw new NaoExisteDaoException("Patrimonio não encontrado!");
        }
        return patrimonio;
    }

    @Override
    public List<Patrimonio> findAll() {
        return entityManager
                .createQuery("select p from Patrimonio p", Patrimonio.class)
                .getResultList();

    }


}