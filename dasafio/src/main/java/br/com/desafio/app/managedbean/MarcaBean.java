package br.com.desafio.app.managedbean;

import br.com.desafio.app.model.Marca;
import br.com.desafio.app.rest.MarcaREST;
import br.com.desafio.app.model.Patrimonio;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class MarcaBean {
    private Integer id;
    private Marca marca;
    private List<Marca> marcas;
    private List<Patrimonio> patrimonios;
    private MarcaREST mr = new MarcaREST();

    public String editar(){
        mr.atualizar(this.marca);
        this.marcas = mr.listar();
        return "index";
    }
    public String criar(){
        mr.inserir(this.marca);
        this.marcas = mr.listar();
        return "index";
    }

    public String remover(Integer id){
        mr.remover(id);
        this.marcas = mr.listar();
        return "index";
    }

    public void initDetalhes(){
        if(this.id != null) {
            this.marca = mr.obter(id);
            patrimonios = mr.listarP(id);
        }else {
            this.marca = new Marca();
        }
    }

    public List<Marca> getMarcas() {
        return marcas;
    }

    public List<Patrimonio> getPatrimonios() {
        return patrimonios;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @PostConstruct
    public void init(){
        marcas = mr.listar();
    }

    public String exibir(Marca marca){
        return "detalhesMarca";
    }

}