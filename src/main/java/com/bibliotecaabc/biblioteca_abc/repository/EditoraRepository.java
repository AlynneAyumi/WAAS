package com.bibliotecaabc.biblioteca_abc.repository;

import com.bibliotecaabc.biblioteca_abc.model.Editora;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EditoraRepository {

    @Getter
    private List<Editora> editoras = new ArrayList<>();

    public Editora getEditora(Integer id) {
        for (Editora editora : editoras) {
            if (editora.getId().equals(id)) {
                return editora;
            }
        }
        return null;
    }

    private final AtomicInteger atomicInteger = new AtomicInteger(1);

    public Editora save(Editora editora) {
        atomicInteger.incrementAndGet(); // Autoincremento

        editora.setId(atomicInteger.get());
        editoras.add(editora);

        return editora;
    }

    public void deleteEditora(Integer id) {
        for (Editora editora : editoras) {
            if (editora.getId().equals(id)) {
                editoras.remove(editora);
                break;
            }
        }
    }
}
