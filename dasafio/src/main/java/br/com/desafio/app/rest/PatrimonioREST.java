package br.com.desafio.app.rest;

import br.com.desafio.app.model.Patrimonio;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;
import org.springframework.http.MediaType;

import java.util.List;


public class PatrimonioREST {
    private Client client;
    private WebResource webResource;

    public PatrimonioREST(){
        ClientConfig clientConfig = new DefaultClientConfig(GensonProvider.class);
        client = Client.create(clientConfig);
        client.addFilter(new LoggingFilter(System.out));
        webResource = client.resource("http://localhost:9090/desafio/");
    }

   public List<Patrimonio> listar(){
        return webResource.path("patrimonios")
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .type(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .get(new GenericType<List<Patrimonio>>(){});
    }

    public Patrimonio obter(Integer id){
        return webResource
                .path("patrimonios")
                .path(id.toString())
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .type(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .get(new GenericType<Patrimonio>(){});
    }

    public void atualizar(Patrimonio patrimonio){
        webResource.path("patrimonios")
                .path(patrimonio.getId().toString())
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .type(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .put(ClientResponse.class, patrimonio);
    }

    public void inserir(Patrimonio patrimonio){
        patrimonio.setNum_tombo((int)(Math.random() * (1000000 - 0 + 1) + 1));
        webResource.path("patrimonios")
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .type(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .post(ClientResponse.class, patrimonio);
    }

    public void remover(Integer id){
        webResource.path("patrimonios")
                .path(id.toString())
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .type(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .delete();
    }

}