package br.com.wale.walegourmet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wale.walegourmet.model.Ingredientes;

@Repository
public interface IngredientesRepository extends JpaRepository<Ingredientes, Integer> {
    public List<Ingredientes> findById(String id);
}