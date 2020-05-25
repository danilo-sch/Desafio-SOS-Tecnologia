package br.com.desafio.app.managedbean;

import br.com.desafio.app.model.Patrimonio;
import br.com.desafio.app.rest.PatrimonioREST;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class PatrimonioBean {
    private Integer id;
    private Patrimonio patrimonio;
    private List<Patrimonio> patrimonios;
    private PatrimonioREST pr = new PatrimonioREST();

    public String editar(){
        pr.atualizar(this.patrimonio);
        this.patrimonios = pr.listar();
        return "index";
    }
    public String criar(){
        pr.inserir(this.patrimonio);
        this.patrimonios = pr.listar();
        return "index";
    }

    public String remover(Integer id){
        pr.remover(id);
        this.patrimonios = pr.listar();
        return "index";
    }

    public void initDetalhes(){
        if(this.id != null) {
            this.patrimonio = pr.obter(id);
        }else {
            this.patrimonio = new Patrimonio();
        }
    }

    public List<Patrimonio> getPatrimonios() {
        return patrimonios;
    }

    public Patrimonio getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(Patrimonio patrimonio) {
        this.patrimonio = patrimonio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @PostConstruct
    public void init(){
        patrimonios = pr.listar();
    }

    public String exibir(Patrimonio patrimonio){
        return "detalhes";
    }

}
