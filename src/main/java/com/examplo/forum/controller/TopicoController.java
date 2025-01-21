package com.examplo.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.exemplo.forum.model.Topico;
import com.exemplo.forum.repository.TopicoRepository;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository repository;

    @GetMapping
    public List<Topico> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Topico salvar(@RequestBody Topico topico) {
        return repository.save(topico);
    }

    @PutMapping("/{id}")
    public Topico atualizar(@PathVariable Long id, @RequestBody Topico topico) {
        Topico existente = repository.findById(id).orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
        existente.setTitulo(topico.getTitulo());
        existente.setMensagem(topico.getMensagem());
        return repository.save(existente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}