package com.bibliotecaabc.biblioteca_abc.controller;

import com.bibliotecaabc.biblioteca_abc.model.Biblioteca;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bibliotecaabc.biblioteca_abc.service.BibliotecaService;

import java.util.List;

@RestController
@RequestMapping("/biblioteca")
public class BibliotecaController {

    private final BibliotecaService bibliotecaService;

    public BibliotecaController(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Biblioteca>> findAll() {
        try {
            var result = bibliotecaService.findAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Biblioteca> save(@RequestBody Biblioteca biblioteca) {
        try {
            var result = bibliotecaService.save(biblioteca);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Biblioteca> findById(@PathVariable Integer id) {
        try {
            var result = bibliotecaService.findById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            bibliotecaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Biblioteca> update(@PathVariable Integer id, @RequestBody Biblioteca bibliotecaUpdate) {
        try {
            var result = bibliotecaService.update(id, bibliotecaUpdate);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
