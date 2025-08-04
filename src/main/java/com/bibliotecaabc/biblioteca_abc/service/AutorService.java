package com.bibliotecaabc.biblioteca_abc.service;

import com.bibliotecaabc.biblioteca_abc.model.Autor;
import com.bibliotecaabc.biblioteca_abc.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AutorService {

    private final AutorRepository autorRepository;

    public List<Autor> findAll() {
        return autorRepository.getAutores();
    }

    public Autor findByID(Integer id) {
        return autorRepository.getAutor(id);
    }

    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }

    public void deleteAutor(Integer id) {
        autorRepository.deleteAutor(id);
    }



}
