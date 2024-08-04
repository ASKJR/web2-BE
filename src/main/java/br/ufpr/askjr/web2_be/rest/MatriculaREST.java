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

import br.ufpr.askjr.web2_be.model.Matricula;
import br.ufpr.askjr.web2_be.repository.MatriculaRepository;

@CrossOrigin
@RestController
public class MatriculaREST {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @GetMapping("/matriculas")
    public ResponseEntity<List<Matricula>> obterTodosMatriculas() {
        return ResponseEntity.ok(matriculaRepository.findAll());
    }

    @GetMapping("/matriculas/{id}")
    public ResponseEntity<Matricula> obterMatriculaPorId(@PathVariable("id") int id) {
        Optional<Matricula> matriculaFound = matriculaRepository.findById(Integer.valueOf(id));
        if (matriculaFound.isPresent()) {
            return ResponseEntity.ok(matriculaFound.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/matriculas")
    public ResponseEntity<Matricula> inserir(@RequestBody Matricula matricula) {

        matricula.setId(-1);
        matriculaRepository.save(matricula);
        return ResponseEntity.status(HttpStatus.CREATED).body(matricula);

    }

    @PutMapping("/matriculas/{id}")
    public ResponseEntity<Matricula> alterar(@PathVariable("id") int id, @RequestBody Matricula matricula) {
        Optional<Matricula> matriculaFound = matriculaRepository.findById(Integer.valueOf(id));
        if (matriculaFound.isPresent()) {
            matricula.setId(id);
            matriculaRepository.save(matricula);
            return ResponseEntity.ok(matricula);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/matriculas/{id}")
    public ResponseEntity<Matricula> remover(@PathVariable("id") int id) {
        Optional<Matricula> matriculaFound = matriculaRepository.findById(Integer.valueOf(id));
        if (matriculaFound.isPresent()) {
            matriculaRepository.delete(matriculaFound.get());
            return ResponseEntity.ok(matriculaFound.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
