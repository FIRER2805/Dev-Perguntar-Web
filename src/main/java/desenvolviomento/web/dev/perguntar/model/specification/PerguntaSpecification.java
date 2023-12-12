package desenvolviomento.web.dev.perguntar.model.specification;

import desenvolviomento.web.dev.perguntar.model.entity.Pergunta;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class PerguntaSpecification {
    public static Specification<Pergunta> temTitulo(String titulo){
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("titulo"), "%" + titulo + "%");
        };
    }

    public static Specification<Pergunta> temCategoria(long idCategoria){
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("categoria").get("id"), idCategoria);
        };
    }

    public static Specification<Pergunta> temDataInicial(Date dataInicial){
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.greaterThanOrEqualTo(root.get("dataPergunta"), dataInicial);
        };
    }

    public static Specification<Pergunta> temDataInicialEDataFinal(Date dataInicial, Date dataFinal){
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.between(root.get("dataPergunta"), dataInicial, dataFinal);
        };
    }

    public static Specification<Pergunta> foiResolvida(){
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.isNotNull(root.get("dataResolucao"));
        };
    }
}
