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

import desenvolviomento.web.dev.perguntar.model.entity.Usuario;
import desenvolviomento.web.dev.perguntar.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
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
	public Usuario cadastraUsuario(@RequestBody Usuario usuario){
		return this.usuarioService.cadastraUsuario(usuario);
	}
	
	@PutMapping
	public Usuario atualizar(@RequestBody Usuario usuario) {
		return this.usuarioService.atualizar(usuario);
	}
	
	@DeleteMapping
	public void deletar(@RequestBody Usuario usuario) {
		this.usuarioService.deletar(usuario);
	}
}
