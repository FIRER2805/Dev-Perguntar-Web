package desenvolviomento.web.dev.perguntar.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import desenvolviomento.web.dev.perguntar.model.entity.Pergunta;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

public class UsuarioDTO {
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private boolean ativo;
	private Long idPerguntas;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public Long getIdPerguntas() {
		return idPerguntas;
	}
	public void setIdPerguntas(Long idPerguntas) {
		this.idPerguntas = idPerguntas;
	}
}
