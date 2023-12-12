package desenvolviomento.web.dev.perguntar.controller;

import java.util.List;

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
import desenvolviomento.web.dev.perguntar.model.entity.Usuario;
import desenvolviomento.web.dev.perguntar.service.UsuarioService;

@RestController
@RequestMapping(path="/usuario")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5500"}, maxAge = 3600)
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public List<Usuario> buscaTodos() {
		return usuarioService.buscaTodos();
	}
	
	@GetMapping("/{id}")
	public Usuario buscaTodosPorId(@PathVariable Long id){
		return this.usuarioService.buscaTodosPorId(id);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> cadastraUsuario(@RequestBody Usuario usuario){
		try {
			return new ResponseEntity<Usuario>(this.usuarioService.cadastraUsuario(usuario), HttpStatus.CREATED);
		}
		catch(CampoInvalidoException e) {
			return new ResponseEntity<Usuario>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping
	public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario){
		try {
			return new ResponseEntity<Usuario>(this.usuarioService.atualizar(usuario), HttpStatus.CREATED);
		}
		catch(CampoInvalidoException e) {
			return new ResponseEntity<Usuario>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping
	public ResponseEntity<Usuario> deletar(@RequestBody Usuario usuario) {
		this.usuarioService.deletar(usuario);
		return new ResponseEntity<Usuario>(HttpStatus.OK);
	}
}
