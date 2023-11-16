package desenvolviomento.web.dev.perguntar.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import desenvolviomento.web.dev.perguntar.model.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Long> {
//	@Query(value = "select e_mail from usuario where e_mail = ?1",nativeQuery = true)
//	String emailDisponivel(String email);
	
	Usuario findByEmail(String email);
}
