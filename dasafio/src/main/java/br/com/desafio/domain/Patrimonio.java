package br.com.desafio.domain;

import javax.persistence.*;

@Entity
@Table(name = "patrimonios")
public class Patrimonio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = true)
    private String descricao;

    @Column(nullable = true)
    private Long num_tombo;

    @Column(name = "marcaid",nullable = false)
    private Long marcaid;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getDescricao() {

        return descricao;
    }

    public void setDescricao(String descricao) {

        this.descricao = descricao;
    }

    public Long getNum_tombo() {

        return num_tombo;
    }

    public void setNum_tombo(Long num_tombo) {

        this.num_tombo = num_tombo;
    }

    public Long getMarcaid() {

        return marcaid;
    }

    public void setMarcaid(Long marcaid) {

        this.marcaid = marcaid;
    }

    @Override
    public int hashCode(){
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString(){
        return "patrimonio{" +
                "id=" + id +
                "}";
    }

}
