package com.bibliotecaabc.biblioteca_abc.controller;

import com.bibliotecaabc.biblioteca_abc.model.Editora;
import com.bibliotecaabc.biblioteca_abc.service.EditoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editora")
@RequiredArgsConstructor
public class EditoraController {

    @Autowired
    private final EditoraService editoraService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Editora>> findAll() {
        try {
            var result = editoraService.findAll();

            return new ResponseEntity<>(result, HttpStatus.OK); // 200
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // 400
        }
    }

    @GetMapping("/findByID/{id}")
    public ResponseEntity<Editora> findById(@PathVariable Integer id) {
        try {
            var result = editoraService.findByID(id);

            return new ResponseEntity<>(result, HttpStatus.OK); // 200
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // 400
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Editora> save(@RequestBody Editora editora) {

        try {
            var result = editoraService.save(editora);

            return new ResponseEntity<>(result, HttpStatus.CREATED); // 201
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // 400
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        try {
            editoraService.deleteEditora(id);

            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT); // 204

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // 400
        }
    }
}
