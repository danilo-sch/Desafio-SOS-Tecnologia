package br.com.desafio.domain;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

@Table(name = "marcas",
        indexes = { @Index(
                columnList= "nome",
                unique= true)
        })
@Entity
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome",nullable = false)
    private String nome;

    public Long getId() {

        return id;
    }

    public void setId(Long marcaid) {

        this.id = marcaid;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    @Override
    public int hashCode(){

        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString(){
        return "marca{" +
                "id=" + id +
                "}";
    }

}