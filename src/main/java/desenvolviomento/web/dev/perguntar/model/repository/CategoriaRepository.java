package desenvolviomento.web.dev.perguntar.model.repository;

import java.util.List;

import desenvolviomento.web.dev.perguntar.model.dto.RelatorioDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import desenvolviomento.web.dev.perguntar.model.entity.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
	Categoria findByNome(String name);

	@Query(nativeQuery = true)
	List<RelatorioDTO> gerarRelatorio();
}
