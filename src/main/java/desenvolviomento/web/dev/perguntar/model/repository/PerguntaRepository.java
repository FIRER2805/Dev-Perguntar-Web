package desenvolviomento.web.dev.perguntar.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import desenvolviomento.web.dev.perguntar.model.entity.Pergunta;

@Repository
public interface PerguntaRepository extends CrudRepository<Pergunta, Long> {

}
