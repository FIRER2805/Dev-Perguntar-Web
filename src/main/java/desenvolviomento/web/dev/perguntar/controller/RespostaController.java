package desenvolviomento.web.dev.perguntar.controller;

import java.util.List;

import desenvolviomento.web.dev.perguntar.model.conversores.DtoParaEntity;
import desenvolviomento.web.dev.perguntar.model.dto.RespostaDTO;
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
import desenvolviomento.web.dev.perguntar.model.entity.Resposta;
import desenvolviomento.web.dev.perguntar.service.RespostaService;

@RestController
@RequestMapping(path="/resposta")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5500"}, maxAge = 3600)
public class RespostaController {
    @Autowired
    private RespostaService service;

    @Autowired
    DtoParaEntity dtoParaEntity;

    @GetMapping()
    public List<Resposta> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public Resposta buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Resposta> salvar(@RequestBody RespostaDTO respostaDTO) {
        try {
            Resposta r = dtoParaEntity.resposta(respostaDTO);
        	return new ResponseEntity<Resposta>(service.salvar(r),HttpStatus.CREATED);
        }
        catch(CampoInvalidoException e) {
        	return new ResponseEntity<Resposta>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Resposta> atualizar(@RequestBody RespostaDTO respostaDto) throws CampoInvalidoException {
        try {
            Resposta r = dtoParaEntity.resposta(respostaDto);
        	return new ResponseEntity<Resposta>(service.atualizar(r),HttpStatus.CREATED);
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
