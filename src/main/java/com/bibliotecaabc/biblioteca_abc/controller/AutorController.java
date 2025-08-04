package com.bibliotecaabc.biblioteca_abc.controller;

import com.bibliotecaabc.biblioteca_abc.model.Autor;
import com.bibliotecaabc.biblioteca_abc.service.AutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/autor")
@RequiredArgsConstructor
public class AutorController {

    @Autowired
    private final AutorService autorService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Autor>> findAll() {
        try {
            var result = autorService.findAll();

            return new ResponseEntity<>(result, HttpStatus.OK); // 200
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // 400
        }
    }

    @GetMapping("/findByID/{id}")
    public ResponseEntity<Autor> findById(@PathVariable Integer id) {
        try {
            var result = autorService.findByID(id);

            return new ResponseEntity<>(result, HttpStatus.OK); // 200
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // 400
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Autor> save(@RequestBody Autor autor) {

        try {
            var result = autorService.save(autor);

            return new ResponseEntity<>(result, HttpStatus.CREATED); // 201
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // 400
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        try {
            autorService.deleteAutor(id);

            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT); // 204

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // 400
        }
    }


}
