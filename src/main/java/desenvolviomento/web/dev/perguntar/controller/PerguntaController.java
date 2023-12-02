package desenvolviomento.web.dev.perguntar.controller;

import java.util.List;

import desenvolviomento.web.dev.perguntar.model.conversores.DtoParaEntity;
import org.modelmapper.ModelMapper;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desenvolviomento.web.dev.perguntar.exceptions.CampoInvalidoException;
import desenvolviomento.web.dev.perguntar.model.dto.PerguntaDTO;
import desenvolviomento.web.dev.perguntar.model.entity.Pergunta;
import desenvolviomento.web.dev.perguntar.service.PerguntaService;
import desenvolviomento.web.dev.perguntar.service.UsuarioService;

@RestController
@RequestMapping(path="/pergunta")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5500"}, maxAge = 3600)
public class PerguntaController {
    @Autowired
    private PerguntaService perguntaService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private DtoParaEntity dtoParaEntity;

    @GetMapping
    public List<Pergunta> buscarTodos() {
        return perguntaService.buscarTodos();
    }
    
    @GetMapping("/{id}")
    public Pergunta buscarPorId(@PathVariable Long id) {
        return perguntaService.buscarPorId(id);
    }
    
    // TODO perguntar pro professor se seria melhor usar um DTO
    @PostMapping
    public ResponseEntity<Pergunta> salvar(@RequestBody PerguntaDTO perguntadto) {
        try {
        	Pergunta pergunta = this.dtoParaEntity.pergunta(perguntadto);
        	return new ResponseEntity<Pergunta>(perguntaService.salvar(pergunta), HttpStatus.CREATED);
        }
        catch(CampoInvalidoException e) {
        	return new ResponseEntity<Pergunta>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Pergunta> atualizar(@RequestBody PerguntaDTO perguntadto) {
        try {
        	Pergunta pergunta = this.dtoParaEntity.pergunta(perguntadto);
        	return new ResponseEntity<Pergunta>(perguntaService.atualizar(pergunta), HttpStatus.OK);
        }
        catch(CampoInvalidoException e) {
        	return new ResponseEntity<Pergunta>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<Pergunta> deletar(@RequestBody PerguntaDTO dto) {
        Pergunta pergunta = this.dtoParaEntity.pergunta(dto);
        perguntaService.deletar(pergunta);
        return new ResponseEntity<Pergunta>(HttpStatus.OK);
    }
}
