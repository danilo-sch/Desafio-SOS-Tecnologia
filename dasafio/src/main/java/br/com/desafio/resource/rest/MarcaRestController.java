package br.com.desafio.resource.rest;

import br.com.desafio.domain.Marca;
import br.com.desafio.domain.Patrimonio;
import br.com.desafio.service.MarcaService;
import br.com.desafio.service.PatrimonioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.ws.rs.Produces;
import java.net.URI;
import java.util.List;
@RestController
@RequestMapping(value = "/marcas",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MarcaRestController {

    @Autowired
    private MarcaService service;
    private PatrimonioService service2;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable("id") Long id){
        service.delete(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Marca> listar(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Marca getMarca(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Produces(MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Marca editar(@PathVariable("id") Long id, @RequestBody Marca marca){
        service.update(id,marca);
        return marca;
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Marca marca){
        service.save(marca);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(marca.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}/patrimonios")
    @ResponseStatus(HttpStatus.OK)
    public List<Patrimonio> listarMarcaId(@PathVariable("id") Long marcaid){
        System.out.println("teste1");
        return service.findByMarcaId(marcaid);
    }


}

