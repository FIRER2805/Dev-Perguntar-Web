package desenvolviomento.web.dev.perguntar.model.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="pergunta")
public class Pergunta {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String conteudo;
    @Column(name = "data_pergunta")
    private Date dataPergunta;
    @Column(name = "data_resolucao")
    private Date dataResolucao;
    
    @OneToOne
    @JoinColumn(name="id_categoria")
    private Categoria categoria;
    
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
}
