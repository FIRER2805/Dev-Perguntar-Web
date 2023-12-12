package desenvolviomento.web.dev.perguntar.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import desenvolviomento.web.dev.perguntar.model.dto.RelatorioDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@NamedNativeQuery(name="Categoria.gerarRelatorio", query="SELECT\n" +
		"    c.nome AS categoria,\n" +
		"    COUNT(p.id) AS total_perguntas,\n" +
		"    COUNT(p_resolvidas.id) AS total_perguntas_resolvidas,\n" +
		"    COUNT(p_sem_resposta.id) AS total_perguntas_sem_resposta\n" +
		"FROM\n" +
		"    categoria c\n" +
		"LEFT JOIN\n" +
		"    pergunta p ON c.id = p.id_categoria\n" +
		"LEFT JOIN\n" +
		"    (SELECT id\n" +
		"     FROM pergunta\n" +
		"     WHERE data_resolucao IS NOT NULL) p_resolvidas ON p.id = p_resolvidas.id\n" +
		"LEFT JOIN\n" +
		"    (SELECT pergunta.id\n" +
		"     FROM pergunta\n" +
		"     LEFT JOIN resposta r ON pergunta.id = r.id_pergunta\n" +
		"     WHERE r.id IS NULL) p_sem_resposta ON p.id = p_sem_resposta.id\n" +
		"GROUP BY c.nome;",
		resultClass = RelatorioDTO.class)
@Table(name="categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

	@OneToMany(mappedBy="categoria")
	@JsonBackReference
	private List<Pergunta> perguntas;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}
}
