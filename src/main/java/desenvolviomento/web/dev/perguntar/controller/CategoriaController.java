package desenvolviomento.web.dev.perguntar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import desenvolviomento.web.dev.perguntar.model.entity.Categoria;
import desenvolviomento.web.dev.perguntar.service.CategoriaService;

@RestController
@RequestMapping(path="/categoria")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5500"}, maxAge = 3600)
public class CategoriaController {
    @Autowired
    private CategoriaService service;

    @GetMapping
    public List<Categoria> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public Categoria buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Categoria> salvar(@RequestBody Categoria categoria) throws CampoInvalidoException {
    	ResponseEntity<Categoria> retorno = null;
    	try {
    		retorno = new ResponseEntity<Categoria>(service.salvar(categoria),HttpStatus.OK);
    	}
    	catch(CampoInvalidoException e) {
    		retorno = new ResponseEntity<Categoria>(HttpStatus.BAD_REQUEST);
    	}
    	return retorno;
    }

    @PutMapping
    public ResponseEntity<Categoria> atualizar(@RequestBody Categoria categoria){
    	ResponseEntity<Categoria> retorno = null;
    	try {
    		retorno = new ResponseEntity<Categoria>(service.atualizar(categoria),HttpStatus.OK);
    	}
    	catch(CampoInvalidoException e) {
    		retorno = new ResponseEntity<Categoria>(HttpStatus.BAD_REQUEST);
    	}
    	return retorno;
    }

    @DeleteMapping
    public ResponseEntity<Categoria> deletar(@RequestBody Categoria categoria) {
        service.deletar(categoria);
        return new ResponseEntity<Categoria>(HttpStatus.OK);
    }
}