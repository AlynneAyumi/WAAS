package com.bibliotecaabc.biblioteca_abc.service;

import com.bibliotecaabc.biblioteca_abc.model.Editora;
import com.bibliotecaabc.biblioteca_abc.repository.EditoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EditoraService {

    private final EditoraRepository editoraRepository;

    public List<Editora> findAll() {
        return editoraRepository.getEditoras();
    }

    public Editora findByID(Integer id) {
        return editoraRepository.getEditora(id);
    }

    public Editora save(Editora editora) {
        return editoraRepository.save(editora);
    }

    public void deleteEditora(Integer id) {
        editoraRepository.deleteEditora(id);
    }
}
