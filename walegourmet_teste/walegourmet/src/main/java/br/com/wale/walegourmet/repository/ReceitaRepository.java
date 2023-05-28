package br.com.wale.walegourmet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wale.walegourmet.model.Receita;

    @Repository
    public interface ReceitaRepository extends JpaRepository<Receita, Long> {
        public List<Receita> findByCriador(String name);
    }

//VERIFICAR SE TEM QUE POR "ID OU PODE SER PARA PROCURAR PELO CRIADOR MESMO"