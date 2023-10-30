package desenvolviomento.web.dev.perguntar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desenvolviomento.web.dev.perguntar.model.entity.Usuario;
import desenvolviomento.web.dev.perguntar.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> buscaTodos() {
		return (List<Usuario>) this.usuarioRepository.findAll();
	}
}
