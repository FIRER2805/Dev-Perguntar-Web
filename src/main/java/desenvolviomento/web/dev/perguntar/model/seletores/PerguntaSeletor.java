package desenvolviomento.web.dev.perguntar.model.seletores;

import java.util.Date;

public class PerguntaSeletor {
    String nome;
    Date dataInicial;
    Date dataFinal;
    Long idCategoria;
    Boolean resolvida;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Boolean getResolvida() {
        return resolvida;
    }

    public void setResolvida(Boolean resolvida) {
        this.resolvida = resolvida;
    }
}
