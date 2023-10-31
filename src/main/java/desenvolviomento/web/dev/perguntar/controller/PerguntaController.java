package desenvolviomento.web.dev.perguntar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desenvolviomento.web.dev.perguntar.model.entity.Pergunta;
import desenvolviomento.web.dev.perguntar.service.PerguntaService;

@RestController
@RequestMapping("/pergunta")
public class PerguntaController {
    @Autowired
    private PerguntaService perguntaService;

    @GetMapping
    public List<Pergunta> buscarTodos() {
        return perguntaService.buscarTodos();
    }
    
    @GetMapping("/{id}")
    public Pergunta buscarPorId(@PathVariable Long id) {
        return perguntaService.buscarPorId(id);
    }
    
    @PostMapping
    public Pergunta salvar(@RequestBody Pergunta pergunta) {
        return perguntaService.salvar(pergunta);
    }

    @PutMapping
    public Pergunta atualizar(@RequestBody Pergunta pergunta) {
        return perguntaService.atualizar(pergunta);
    }

    @DeleteMapping
    public void deletar(@RequestBody Pergunta pergunta) {
        perguntaService.deletar(pergunta);
    }
}
