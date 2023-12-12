package desenvolviomento.web.dev.perguntar.model.dto;

import lombok.Getter;
import lombok.Setter;

public class RespostaDTO {

    private Long id;
    private String conteudo;
    private Boolean solucao;
    private Long idPergunta;
    private Long idUsuario;
    private Long idRespostaPai;

    public String getConteudo() {
        return conteudo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public void setSolucao(Boolean solucao) {
        this.solucao = solucao;
    }

    public void setIdPergunta(Long idPergunta) {
        this.idPergunta = idPergunta;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setIdRespostaPai(Long idRespostaPai) {
        this.idRespostaPai = idRespostaPai;
    }

    public Boolean getSolucao() {
        return solucao;
    }

    public Long getIdPergunta() {
        return idPergunta;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public Long getIdRespostaPai() {
        return idRespostaPai;
    }

    public Long getId() {
        return id;
    }
}
