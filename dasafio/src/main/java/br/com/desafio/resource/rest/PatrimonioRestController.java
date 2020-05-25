package br.com.desafio.resource.rest;

import br.com.desafio.domain.Patrimonio;
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
@RequestMapping(value = "/patrimonios",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PatrimonioRestController {

    @Autowired
    private PatrimonioService service;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Produces(MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void excluir(@PathVariable("id") Long id){
        service.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Produces(MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Patrimonio editar(@PathVariable("id") Long id, @RequestBody Patrimonio patrimonio){
        service.update(id,patrimonio);
        return patrimonio;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Produces(MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Patrimonio getPatrimonio(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Patrimonio patrimonio){
        service.save(patrimonio);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(patrimonio.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Patrimonio> listar(){
        return service.findAll();
    }
}
