package desenvolviomento.web.dev.perguntar.model.dto;

import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
        name = "RelatorioDTOMapping",
        entities = {
                @EntityResult(
                        entityClass = RelatorioDTO.class,
                        fields = {
                                @FieldResult(name = "categoria", column = "categoria"),
                                @FieldResult(name = "total_perguntas", column = "total_perguntas"),
                                @FieldResult(name = "total_perguntas_resolvidas", column = "total_perguntas_resolvidas"),
                                @FieldResult(name = "total_perguntas_sem_resposta", column = "total_perguntas_sem_resposta")
                        }
                )
        }
)
public class RelatorioDTO {
    private String categoria;
    private Long total_perguntas;
    private Long total_perguntas_resolvidas;
    private Long total_perguntas_sem_resposta;

    public RelatorioDTO(String categoria, Long totalPerguntas, Long totalPerguntasResolvidas, Long totalPerguntasSemResposta) {
        this.categoria = categoria;
        this.total_perguntas = totalPerguntas;
        this.total_perguntas_resolvidas = totalPerguntasResolvidas;
        this.total_perguntas_sem_resposta = totalPerguntasSemResposta;
    }
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Long getTotal_perguntas() {
        return total_perguntas;
    }

    public void setTotal_perguntas(Long total_perguntas) {
        this.total_perguntas = total_perguntas;
    }

    public Long getTotal_perguntas_resolvidas() {
        return total_perguntas_resolvidas;
    }

    public void setTotal_perguntas_resolvidas(Long total_perguntas_resolvidas) {
        this.total_perguntas_resolvidas = total_perguntas_resolvidas;
    }

    public Long getTotal_perguntas_sem_resposta() {
        return total_perguntas_sem_resposta;
    }

    public void setTotal_perguntas_sem_resposta(Long total_perguntas_sem_resposta) {
        this.total_perguntas_sem_resposta = total_perguntas_sem_resposta;
    }
}
