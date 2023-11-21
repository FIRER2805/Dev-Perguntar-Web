package desenvolviomento.web.dev.perguntar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desenvolviomento.web.dev.perguntar.exceptions.CampoInvalidoException;
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

	public Usuario cadastraUsuario(Usuario usuario) throws CampoInvalidoException {
		this.validarCampos(usuario);
		return this.repository.save(usuario);
	}

	public void deletar(Usuario usuario) {
		this.repository.delete(usuario);
	}

	public Usuario atualizar(Usuario usuario) throws CampoInvalidoException {
		this.validarCampos(usuario);
		
		return this.repository.save(usuario);
	}
	
	private Boolean emailDisponivel(String email) {
		return repository.findByEmail(email) == null;
	}
	
	// TODO fazer as exception e a verificação se o e-mail existe
	private void validarCampos(Usuario usuario) throws CampoInvalidoException{
        String mensagem = "";
        
		if (usuario.getNome() == null || usuario.getNome().isBlank() || usuario.getNome().length() > 50) {
            mensagem += "Nome inválido\n";
        }
        if (usuario.getEmail() == null || usuario.getEmail().isBlank() || usuario.getEmail().length() > 255) {
        	mensagem += "E-mail inválido\n";
        }
        if (usuario.getSenha() == null || usuario.getSenha().isBlank() || usuario.getSenha().length() > 50) {
        	mensagem += "senha inválida\n";
        }
        
		if(!emailDisponivel(usuario.getEmail())) {
			mensagem += "Email já utilizado";
		}
        
        if(!mensagem.isBlank()) {
        	throw new CampoInvalidoException(mensagem);
        }
	}
}
