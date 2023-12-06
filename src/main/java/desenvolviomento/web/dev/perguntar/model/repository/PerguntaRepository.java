package desenvolviomento.web.dev.perguntar.model.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import desenvolviomento.web.dev.perguntar.model.entity.Pergunta;

import java.util.List;

@Repository
public interface PerguntaRepository extends CrudRepository<Pergunta, Long>, JpaSpecificationExecutor<Pergunta> {
    @Modifying
    @Query(value = "update pergunta set data_resolucao = now() where id = ?1 ;", nativeQuery = true)
    void marcarPerguntaComoResolvida(Long id);

    List<Pergunta> findAll(Specification<Pergunta> spec);
}
