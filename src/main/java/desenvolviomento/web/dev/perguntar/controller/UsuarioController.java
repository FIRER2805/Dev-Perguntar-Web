package desenvolviomento.web.dev.perguntar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
