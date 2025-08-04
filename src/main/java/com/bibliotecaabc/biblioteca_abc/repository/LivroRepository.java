package com.bibliotecaabc.biblioteca_abc.repository;

import com.bibliotecaabc.biblioteca_abc.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
