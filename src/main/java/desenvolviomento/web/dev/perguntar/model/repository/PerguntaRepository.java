package desenvolviomento.web.dev.perguntar.model.repository;

import org.springframework.data.repository.CrudRepository;

import desenvolviomento.web.dev.perguntar.model.entity.Pergunta;

public interface PerguntaRepository extends CrudRepository<Pergunta, Long> {

}
