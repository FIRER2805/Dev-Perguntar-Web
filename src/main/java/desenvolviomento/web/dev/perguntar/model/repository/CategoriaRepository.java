package desenvolviomento.web.dev.perguntar.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import desenvolviomento.web.dev.perguntar.model.entity.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
	
}
