package br.ufpr.askjr.web2_be.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "curso")
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
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

    @Column(name = "link")
    @Setter
    @Getter
    private String link;
}
