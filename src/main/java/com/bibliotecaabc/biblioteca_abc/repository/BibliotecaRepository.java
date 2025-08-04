package com.bibliotecaabc.biblioteca_abc.repository;

import com.bibliotecaabc.biblioteca_abc.model.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecaRepository extends JpaRepository<Biblioteca, Integer> {
}
