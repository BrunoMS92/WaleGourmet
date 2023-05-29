package br.com.wale.walegourmet.controller;

import br.com.wale.walegourmet.model.Ingredientes;
import br.com.wale.walegourmet.service.IngredientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Ingredientes")
public class IngredientesController {
    private final IngredientesService ingredientesService;

    @Autowired
    public IngredientesController(IngredientesService ingredientesService) {
        this.ingredientesService = ingredientesService;
    }

    @GetMapping
    public ResponseEntity<List<Ingredientes>> getAllIngredientes() {
        List<Ingredientes> ingredientesList = ingredientesService.findAll();
        return ResponseEntity.ok(ingredientesList);
    }

    @PostMapping
    public ResponseEntity<Ingredientes> createIngrediente(@RequestBody Ingredientes ingrediente) {
        Ingredientes createdIngrediente = ingredientesService.save(ingrediente);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdIngrediente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngrediente(@PathVariable int id) {
        ingredientesService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredientes> getIngredienteById(@PathVariable int id) {
        Ingredientes ingrediente = ingredientesService.findOne(id).orElse(null);
        if (ingrediente != null) {
            return ResponseEntity.ok(ingrediente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
