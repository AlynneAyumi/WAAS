package com.bibliotecaabc.biblioteca_abc.model;

<<<<<<< HEAD
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Autor {

    private Integer id;
    private String  nome;
    private String  cpf;
=======
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String cpf;
>>>>>>> 6ca426f5581e16ac792fb7f80072a5ead5895585
    private Integer idade;
}
