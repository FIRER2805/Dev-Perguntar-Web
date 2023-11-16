package desenvolviomento.web.dev.perguntar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desenvolviomento.web.dev.perguntar.model.entity.Usuario;
import desenvolviomento.web.dev.perguntar.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> buscaTodos() {
		return (List<Usuario>) this.repository.findAll();
	}

	public Usuario buscaTodosPorId(Long id) {
		return this.repository.findById(id).get();
	}

	public Usuario cadastraUsuario(Usuario usuario) {
		return this.repository.save(usuario);
	}

	public void deletar(Usuario usuario) {
		this.repository.delete(usuario);
	}

	public Usuario atualizar(Usuario usuario) {
		return this.repository.save(usuario);
	}
	
	
	// TODO fazer as exception e a verificação se o e-mail existe
	private void ValidaCampos(Usuario usuario){
        if (usuario == null) {
            
        }

        if (usuario.getNome() == null || usuario.getNome().isBlank() || usuario.getNome().length() > 50) {
            
        }

        if (usuario.getEmail() == null || usuario.getEmail().isBlank() || usuario.getEmail().length() > 255) {
            
        }

        if (usuario.getSenha() == null || usuario.getSenha().isBlank() || usuario.getSenha().length() > 50) {
            
        }
	}
}
