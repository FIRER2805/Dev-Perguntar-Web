package desenvolviomento.web.dev.perguntar.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="resposta")
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String conteudo;
    private boolean solucao;
    
    @ManyToOne()
    @JoinColumn(name="id_pergunta")
    @JsonBackReference
    private Pergunta pergunta;
    
    @ManyToOne()
    @JoinColumn(name="id_usuario")
    @JsonManagedReference
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "id_resposta")
    @JsonBackReference
    private Resposta respostaPai;
    
    @OneToMany(mappedBy = "respostaPai")
    @JsonManagedReference
    private List<Resposta> respostaFilhas;
    
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Pergunta getPergunta() {
		return pergunta;
	}
	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public boolean isSolucao() {
		return solucao;
	}
	public void setSolucao(boolean solucao) {
		this.solucao = solucao;
	}
}
