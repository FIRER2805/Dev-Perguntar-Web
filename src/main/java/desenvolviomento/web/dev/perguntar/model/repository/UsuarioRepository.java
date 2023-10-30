package desenvolviomento.web.dev.perguntar.model.repository;

import org.springframework.data.repository.CrudRepository;

import desenvolviomento.web.dev.perguntar.model.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario,Long> {
	
}
