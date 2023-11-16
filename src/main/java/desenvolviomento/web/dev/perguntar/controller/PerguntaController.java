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
import desenvolviomento.web.dev.perguntar.model.entity.Usuario;
import desenvolviomento.web.dev.perguntar.service.PerguntaService;
import desenvolviomento.web.dev.perguntar.service.UsuarioService;

@RestController
@RequestMapping(path="/pergunta")
public class PerguntaController {
    @Autowired
    private PerguntaService perguntaService;
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Pergunta> buscarTodos() {
        return perguntaService.buscarTodos();
    }
    
    @GetMapping("/{id}")
    public Pergunta buscarPorId(@PathVariable Long id) {
        return perguntaService.buscarPorId(id);
    }
    
    // TODO perguntar pro professor se seria melhor usar um DTO
    @PostMapping("/{idUsuario}")
    public Pergunta salvar(@RequestBody Pergunta pergunta, @PathVariable Long idUsuario) {
    	Usuario usuario = usuarioService.buscaTodosPorId(idUsuario);
    	pergunta.setUsuario(usuario);
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
