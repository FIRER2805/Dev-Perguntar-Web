package desenvolviomento.web.dev.perguntar.model.repository;

import desenvolviomento.web.dev.perguntar.model.entity.Pergunta;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import desenvolviomento.web.dev.perguntar.model.entity.Resposta;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RespostaRepository extends CrudRepository<Resposta, Long> {

    @Query(value = "select * from resposta where id_pergunta = ?1 and id_resposta is null;", nativeQuery = true)
    List<Resposta> buscaPorIdPergunta(Long idPergunta);

    @Modifying
    @Query(value = "update resposta set solucao = true where id = ?1 ;", nativeQuery = true)
    void marcaRespostaComoSolucao(Long id);
}
