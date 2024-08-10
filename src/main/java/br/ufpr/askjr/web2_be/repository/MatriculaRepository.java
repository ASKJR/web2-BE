package br.ufpr.askjr.web2_be.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ufpr.askjr.web2_be.model.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {
    public List<Matricula> findByAlunoNomeContainingIgnoreCase(String nome);
}
