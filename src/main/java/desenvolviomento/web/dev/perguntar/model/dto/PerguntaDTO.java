package desenvolviomento.web.dev.perguntar.model.dto;

import java.sql.Date;

public class PerguntaDTO {
    private Long id;
    private String titulo;
    private String conteudo;
    private Date dataPergunta;
    private Date dataResolucao;
    private Long idCategoria;
    private Long idUsuario;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public Date getDataPergunta() {
		return dataPergunta;
	}
	public void setDataPergunta(Date dataPergunta) {
		this.dataPergunta = dataPergunta;
	}
	public Date getDataResolucao() {
		return dataResolucao;
	}
	public void setDataResolucao(Date dataResolucao) {
		this.dataResolucao = dataResolucao;
	}
	public Long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
}
