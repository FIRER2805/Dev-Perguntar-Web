package desenvolviomento.web.dev.perguntar.model.entity;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    
    @OneToOne()
    @JoinColumn(name="id_categoria")
    private Categoria categoria;
    
    @ManyToOne()
    @JoinColumn(name = "id_usuario")
    @JsonManagedReference
    private Usuario usuario;
    
    @OneToMany(mappedBy="pergunta")
    @JsonManagedReference
    private List<Resposta> respostas;
    
    
	public List<Resposta> getRespostas() {
		return respostas;
	}
	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
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
