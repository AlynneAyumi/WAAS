package com.bibliotecaabc.biblioteca_abc.service;

import com.bibliotecaabc.biblioteca_abc.model.Livro;
import com.bibliotecaabc.biblioteca_abc.repository.LivroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Livro findById(Integer id) {
        return livroRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    public Livro update(Integer id, Livro livro){
        Livro update = findById(id);

        if(livro.getInns() != null && !livro.getInns().isBlank()){
            update.setInns(livro.getInns());
        }
        if (livro.getTitulo() != null && !livro.getTitulo().isBlank()) {
            update.setTitulo(livro.getTitulo());
        }
        if (livro.getSinopse() != null && !livro.getSinopse().isBlank()) {
            update.setSinopse(livro.getSinopse());
        }
        if (livro.getAno() != null) {
            update.setAno(livro.getAno());
        }
        if (livro.getNumPaginas() != null) {
            update.setNumPaginas(livro.getNumPaginas());
        }

        return livroRepository.save(update);
    }

    public void delete(Integer id) {
        Livro delete = findById(id);
        livroRepository.delete(delete);
    }
}
