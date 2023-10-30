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

	public Usuario buscaTodosPorId(Long id) {
		return this.usuarioRepository.findById(id).get();
	}

	public Usuario cadastraUsuario(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	public boolean deletar(Usuario usuario) {
		//TODO mudar isso
		long quantidadeAtual = this.usuarioRepository.count();
		this.usuarioRepository.delete(usuario);
		return quantidadeAtual > this.usuarioRepository.count() ? true
				: false;
	}

	public Usuario atualizar(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}
}
