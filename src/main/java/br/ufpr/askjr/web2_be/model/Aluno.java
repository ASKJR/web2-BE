package br.ufpr.askjr.web2_be.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

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
