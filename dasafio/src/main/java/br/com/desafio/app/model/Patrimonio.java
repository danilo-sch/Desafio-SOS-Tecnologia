package br.com.desafio.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Patrimonio {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("descricao")
    private String descricao;
    @JsonProperty("num_tombo")
    private Integer num_tombo;
    @JsonProperty("marcaid")
    private Integer marcaid;

    @JsonIgnore
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonIgnore
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @JsonIgnore
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {

        this.descricao = descricao;
    }

    @JsonIgnore
    public Integer getNum_tombo() {
        return num_tombo;
    }

    public void setNum_tombo(Integer num_tombo) {

        this.num_tombo = num_tombo;

    }

    @JsonIgnore
    public Integer getMarcaid() {
        return marcaid;
    }

    public void setMarcaid(Integer marcaid) {
        this.marcaid = marcaid;
    }
}
