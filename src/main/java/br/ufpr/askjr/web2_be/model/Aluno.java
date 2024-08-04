package br.ufpr.askjr.web2_be.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "aluno")
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Setter
    @Getter
    private int id;

    @Column(name = "nome")
    @Setter
    @Getter
    private String nome;

    @Column(name = "cpf")
    @Setter
    @Getter
    private String cpf;

    @Column(name = "email")
    @Setter
    @Getter
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento")
    @Setter
    @Getter
    private LocalDate nascimento;

}
