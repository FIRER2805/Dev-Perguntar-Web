package desenvolviomento.web.dev.perguntar.model.dto;

import lombok.Getter;
import lombok.Setter;

public class RespostaDTO {
    @Getter
    @Setter
    private Long id;
    private String conteudo;
    private Boolean solucao;
    private Long idPergunta;
    private Long idUsuario;
    private Long idRespostaPai;
}
