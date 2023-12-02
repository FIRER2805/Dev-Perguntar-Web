package desenvolviomento.web.dev.perguntar.model.dto;

import java.util.List;

public class RespostaArvoreDTO {
    private Long key;
    private String label;
    private List<RespostaArvoreDTO> children;
    private Boolean solucao;
    private Long idUsuario;

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<RespostaArvoreDTO> getChildren() {
        return children;
    }

    public void setChildren(List<RespostaArvoreDTO> children) {
        this.children = children;
    }

    public Boolean getSolucao() {
        return solucao;
    }

    public void setSolucao(Boolean solucao) {
        this.solucao = solucao;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
