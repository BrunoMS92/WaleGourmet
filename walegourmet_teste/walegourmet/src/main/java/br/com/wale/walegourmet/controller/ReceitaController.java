package br.com.wale.walegourmet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wale.walegourmet.model.Receita;
import br.com.wale.walegourmet.service.ReceitaService;

@RestController
@RequestMapping("api/Receita")

    
public class ReceitaController {
    @Autowired
    private ReceitaService service;
    
    @GetMapping
    public List<Receita> findAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Receita receita) {
        try {
            return new ResponseEntity<>(service.save(receita), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro desconhecido, tente mais tarde!",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

@PutMapping
public ResponseEntity<Object> edit(@RequestBody Receita receita) {
    try {
        return new ResponseEntity<>(service.save(receita), HttpStatus.CREATED);
    } catch (Exception e) {
        return new ResponseEntity<>("Ocorreu um erro na sua ação, tente novamente mais tarde!",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

@DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        var receita = service.findOne(id);
        if (receita.isPresent()) {
            service.delete(id);

            receita = service.findOne(id);
            if (receita.isEmpty()) {
                return new ResponseEntity<>("Receita removida com sucesso!", HttpStatus.OK);
            }
            return new ResponseEntity<>("Não foi possível remover a receita!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Não foi possível concluir sua busca!", HttpStatus.NOT_FOUND);
    }
}




