package br.com.wale.walegourmet.service;

import br.com.wale.walegourmet.model.Ingredientes;
import br.com.wale.walegourmet.repository.IngredientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientesService {
    @Autowired
    private IngredientesRepository repository;

    public List<Ingredientes> findAll() {
        return repository.findAll();
    }

    public Ingredientes save(Ingredientes receita) {
        return repository.save(receita);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public Optional<Ingredientes> findOne(int id) {
        return repository.findById(id);
    }
}
