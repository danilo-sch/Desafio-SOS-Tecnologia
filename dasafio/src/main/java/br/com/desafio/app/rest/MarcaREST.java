package br.com.desafio.app.rest;
import br.com.desafio.app.model.Marca;
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


public class MarcaREST {
    private Client client;
    private WebResource webResource;

    public MarcaREST() {
        ClientConfig clientConfig = new DefaultClientConfig(GensonProvider.class);
        client = Client.create(clientConfig);
        client.addFilter(new LoggingFilter(System.out));
        webResource = client.resource("http://localhost:9090/desafio/");
    }

    public List<Marca> listar() {
        return webResource.path("marcas")
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .type(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .get(new GenericType<List<Marca>>() {});
    }

    public Marca obter(Integer id) {
        return webResource
                .path("marcas")
                .path(id.toString())
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .type(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .get(new GenericType<Marca>() {});
    }

    public void atualizar(Marca marca) {
        webResource.path("marcas")
                .path(marca.getId().toString())
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .type(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .put(ClientResponse.class, marca);
    }

    public void inserir(Marca marca) {
        webResource.path("marcas")
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .type(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .post(ClientResponse.class, marca);
    }

    public void remover(Integer id) {
        webResource.path("marcas")
                .path(id.toString())
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .type(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .delete();
    }
    public List<Patrimonio> listarP(Integer id) {
        return webResource.path("marcas").path(id.toString()).path("patrimonios")
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .type(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .get(new GenericType<List<Patrimonio>>(){});
    }

}