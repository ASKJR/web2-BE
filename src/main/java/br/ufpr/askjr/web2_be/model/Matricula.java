package br.ufpr.askjr.web2_be.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "matricula")
@NoArgsConstructor
@AllArgsConstructor
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Setter
    @Getter
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "aluno_id")
    @Setter
    @Getter
    private Aluno aluno;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curso_id")
    @Setter
    @Getter
    private Curso curso;

    @Column(name = "data_matricula")
    @Setter
    @Getter
    private LocalDate dataMatricula;

    @Column(name = "nota")
    @Setter
    @Getter
    private Double nota;

}