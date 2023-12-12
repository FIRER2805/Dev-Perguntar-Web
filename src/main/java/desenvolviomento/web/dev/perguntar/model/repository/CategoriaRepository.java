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

	//@Query(nativeQuery = true)

	// String categoria, Integer totalPerguntas, Integer total_perguntas_resolvidas, Long totalPerguntasSemResposta
	@Query(value="SELECT new desenvolviomento.web.dev.perguntar.model.dto.RelatorioDTO(\n" +
			"    c.nome,\n" +
			"    size(c.perguntas),\n" +
			"    size(perguntaResolvida),\n" +
			"    count(perguntaSemResposta.id))\n" +  // Use count() instead of total_sem_resposta
			"FROM\n" +
			"    Categoria c\n" +
			"LEFT JOIN\n" +
			"    c.perguntas perguntaResolvida on perguntaResolvida.dataResolucao is not null\n" +  // Removed the subquery
			"LEFT JOIN\n" +
			"    Pergunta perguntaSemResposta\n" +
			"    ON c = perguntaSemResposta.categoria\n" +  // Assuming there's a relationship between Categoria and Pergunta
			"    AND size(perguntaSemResposta.respostas) = 0\n" +
			"GROUP BY c.nome")
	List<RelatorioDTO> gerarRelatorio();
}
