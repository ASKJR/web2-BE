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

import br.ufpr.askjr.web2_be.model.Curso;
import br.ufpr.askjr.web2_be.repository.CursoRepository;

@CrossOrigin
@RestController
public class CursoREST {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/cursos")
    public ResponseEntity<List<Curso>> obterTodosCursos() {
        return ResponseEntity.ok(cursoRepository.findAll());
    }

    @GetMapping("/cursos/{id}")
    public ResponseEntity<Curso> obterCursoPorId(@PathVariable("id") int id) {
        Optional<Curso> cursoFound = cursoRepository.findById(Integer.valueOf(id));
        if (cursoFound.isPresent()) {
            return ResponseEntity.ok(cursoFound.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/cursos")
    public ResponseEntity<Curso> inserir(@RequestBody Curso curso) {
        Optional<Curso> u = cursoRepository.findByNome(curso.getNome());
        if (u.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(u.get());
        } else {
            curso.setId(-1);
            cursoRepository.save(curso);
            return ResponseEntity.status(HttpStatus.CREATED).body(curso);
        }
    }

    @PutMapping("/cursos/{id}")
    public ResponseEntity<Curso> alterar(@PathVariable("id") int id, @RequestBody Curso curso) {
        Optional<Curso> cursoFound = cursoRepository.findById(Integer.valueOf(id));
        if (cursoFound.isPresent()) {
            curso.setId(id);
            cursoRepository.save(curso);
            return ResponseEntity.ok(curso);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/cursos/{id}")
    public ResponseEntity<Curso> remover(@PathVariable("id") int id) {
        Optional<Curso> cursoFound = cursoRepository.findById(Integer.valueOf(id));
        if (cursoFound.isPresent()) {
            cursoRepository.delete(cursoFound.get());
            return ResponseEntity.ok(cursoFound.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
