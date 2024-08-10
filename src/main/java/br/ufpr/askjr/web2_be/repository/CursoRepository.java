package br.ufpr.askjr.web2_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import br.ufpr.askjr.web2_be.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
    public Optional<Curso> findByNome(String nome);

    public List<Curso> findByNomeContainingIgnoreCase(String name);
}
