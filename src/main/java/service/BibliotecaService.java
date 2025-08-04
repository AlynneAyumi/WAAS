package service;

import jakarta.persistence.EntityNotFoundException;
import model.Biblioteca;
import org.springframework.stereotype.Service;
import repository.BibliotecaRepository;

import java.util.List;

@Service
public class BibliotecaService {

    private final BibliotecaRepository bibliotecaRepository;

    public BibliotecaService(BibliotecaRepository bibliotecaRepository) {
        this.bibliotecaRepository = bibliotecaRepository;
    }

    public Biblioteca save(Biblioteca biblioteca) {
        return bibliotecaRepository.save(biblioteca);
    }

    public List<Biblioteca> findAll() {
        return bibliotecaRepository.findAll();
    }

    public Biblioteca findById(Integer id) {
        return bibliotecaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    public Biblioteca update(Integer id, Biblioteca biblioteca){
        Biblioteca update = findById(id);

        if(biblioteca.getNome() != null && !biblioteca.getNome().isBlank()){
            update.setNome(biblioteca.getNome());
        }
        if (biblioteca.getTelefone() != null && !biblioteca.getTelefone().isBlank()) {
            update.setTelefone(biblioteca.getTelefone());
        }

        return bibliotecaRepository.save(update);
    }

    public void delete(Integer id) {
        Biblioteca delete = findById(id);
        bibliotecaRepository.delete(delete);
    }
}
