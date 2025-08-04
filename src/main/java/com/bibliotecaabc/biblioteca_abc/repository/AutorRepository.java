package com.bibliotecaabc.biblioteca_abc.repository;

import com.bibliotecaabc.biblioteca_abc.model.Autor;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AutorRepository {

    @Getter
    private List<Autor> autores = new ArrayList<>();

    public Autor getAutor(Integer id) {
        for (Autor autor : autores) {
            if (autor.getId().equals(id)) {
                return autor;
            }
        }
        return null;
    }

    private final AtomicInteger atomicInteger = new AtomicInteger(1);

    public Autor save(Autor autor) {
        atomicInteger.incrementAndGet(); // Autoincremento

        autor.setId(atomicInteger.get());
        autores.add(autor);

        return autor;
    }

    public void deleteAutor(Integer id) {
        for (Autor autor : autores) {
            if (autor.getId().equals(id)) {
                autores.remove(autor);
                break;
            }
        }
    }

}
