package br.ufpr.askjr.web2_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import br.ufpr.askjr.web2_be.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    public Optional<Aluno> findByNome(String nome);

    public List<Aluno> findByNomeContainingIgnoreCase(String name);
}
