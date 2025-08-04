package com.bibliotecaabc.biblioteca_abc.model;

<<<<<<< HEAD
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Editora {

    private Integer id;
=======
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Editora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

>>>>>>> 6ca426f5581e16ac792fb7f80072a5ead5895585
    private String nome;
    private String endereco;
    private String telefone;
}
