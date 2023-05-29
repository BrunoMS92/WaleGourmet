package br.com.wale.walegourmet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wale.walegourmet.model.Receita;
import br.com.wale.walegourmet.repository.ReceitaRepository;

@Service
public class ReceitaService {
    @Autowired
    private ReceitaRepository repository;

    public List<Receita> findAll() {
        return repository.findAll();
    }

    public Receita save(Receita receita) {
        return repository.save(receita);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Optional<Receita> findOne(Long id) {
        return repository.findById(id);
    }
}

