package desenvolviomento.web.dev.perguntar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desenvolviomento.web.dev.perguntar.exceptions.CampoInvalidoException;
import desenvolviomento.web.dev.perguntar.model.entity.Resposta;
import desenvolviomento.web.dev.perguntar.service.RespostaService;

@RestController
@RequestMapping(path="/resposta")
public class RespostaController {
    @Autowired
    private RespostaService service;

    @GetMapping()
    public List<Resposta> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public Resposta buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Resposta> salvar(@RequestBody Resposta resposta) {
        try {
        	return new ResponseEntity<Resposta>(service.salvar(resposta),HttpStatus.CREATED);
        }
        catch(CampoInvalidoException e) {
        	return new ResponseEntity<Resposta>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Resposta> atualizar(@RequestBody Resposta resposta) throws CampoInvalidoException {
        try {
        	return new ResponseEntity<Resposta>(service.atualizar(resposta),HttpStatus.CREATED);
        }
        catch(CampoInvalidoException e) {
        	return new ResponseEntity<Resposta>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<Resposta> deletar(@RequestBody Resposta resposta) {
        service.deletar(resposta);
        return new ResponseEntity<Resposta>(HttpStatus.OK);
    }
}
