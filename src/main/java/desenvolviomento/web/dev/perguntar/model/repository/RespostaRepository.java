package desenvolviomento.web.dev.perguntar.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import desenvolviomento.web.dev.perguntar.model.entity.Resposta;

@Repository
public interface RespostaRepository extends CrudRepository<Resposta, Long> {
	
}
