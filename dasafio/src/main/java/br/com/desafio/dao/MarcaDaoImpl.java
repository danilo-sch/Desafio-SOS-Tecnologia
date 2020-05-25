package br.com.desafio.dao;

import br.com.desafio.domain.Marca;
import br.com.desafio.domain.Patrimonio;
import br.com.desafio.exception.NaoExisteDaoException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MarcaDaoImpl implements MarcaDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Marca marca) {

        entityManager.persist(marca);
    }

    @Override
    public void update(Marca marca) {

        entityManager.merge(marca);
    }

    @Override
    public void delete(Long id) {
        try{
            entityManager.remove(entityManager.getReference(Marca.class, id));
        }catch (EntityNotFoundException ex){
            throw new NaoExisteDaoException("Marca não encontrada!");
        }

    }

    @Override
    public Marca findById(Long id) {
        Marca marca = entityManager.find(Marca.class, id);
        if(marca == null){
            throw new NaoExisteDaoException("Marca não encontrada!");
        }
        return marca;

    }

    @Override
    public List<Marca> findAll() {
        return entityManager.createQuery("select m from Marca m",Marca.class).getResultList();

    }

    @Override
    public List<Patrimonio> findByMarcaId(Long marcaid){
        System.out.println("teste3");
        //Patrimonio patrimonio = entityManager.find(Patrimonio.class, marcaid);
        List<Patrimonio> teste = entityManager
                .createQuery("select p from Patrimonio p where p.marcaid = :marcaid", Patrimonio.class)
                .setParameter("marcaid", marcaid)
                .getResultList();
        if(teste.isEmpty()){
            throw new NaoExisteDaoException("Marca não encontrada!");
        }
        return teste;

    }


}
