package br.ufpr.askjr.web2_be.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.ufpr.askjr.web2_be.model.Aluno;
import br.ufpr.askjr.web2_be.repository.AlunoRepository;

@CrossOrigin
@RestController
public class AlunoREST {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/alunos")
    public ResponseEntity<List<Aluno>> obterTodosCursos() {
        return ResponseEntity.ok(alunoRepository.findAll());
    }

    @GetMapping("/alunos/{id}")
    public ResponseEntity<Aluno> obterCursoPorId(@PathVariable("id") int id) {
        Optional<Aluno> alunoFound = alunoRepository.findById(Integer.valueOf(id));
        if (alunoFound.isPresent()) {
            return ResponseEntity.ok(alunoFound.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/alunos")
    public ResponseEntity<Aluno> inserir(@RequestBody Aluno aluno) {
        Optional<Aluno> u = alunoRepository.findByNome(aluno.getNome());
        if (u.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(u.get());
        } else {
            aluno.setId(-1);
            alunoRepository.save(aluno);
            return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
        }
    }

    @PutMapping("/alunos/{id}")
    public ResponseEntity<Aluno> alterar(@PathVariable("id") int id, @RequestBody Aluno aluno) {
        Optional<Aluno> alunoFound = alunoRepository.findById(Integer.valueOf(id));
        if (alunoFound.isPresent()) {
            aluno.setId(id);
            alunoRepository.save(aluno);
            return ResponseEntity.ok(aluno);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/alunos/{id}")
    public ResponseEntity<Aluno> remover(@PathVariable("id") int id) {
        Optional<Aluno> alunoFound = alunoRepository.findById(Integer.valueOf(id));
        if (alunoFound.isPresent()) {
            alunoRepository.delete(alunoFound.get());
            return ResponseEntity.ok(alunoFound.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
