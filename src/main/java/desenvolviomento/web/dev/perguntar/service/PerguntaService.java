package desenvolviomento.web.dev.perguntar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desenvolviomento.web.dev.perguntar.model.entity.Pergunta;
import desenvolviomento.web.dev.perguntar.model.repository.PerguntaRepository;

@Service
public class PerguntaService {

	@Autowired
	private PerguntaRepository repository;
	
	public List<Pergunta> buscarTodos() {
		return (List<Pergunta>) repository.findAll();
	}

	public Pergunta buscarPorId(Long id) {
		return this.repository.findById(id).get();
	}

	public Pergunta salvar(Pergunta pergunta) {
		return this.repository.save(pergunta);
	}

	public Pergunta atualizar(Pergunta pergunta) {
		return this.repository.save(pergunta);
	}

	public void deletar(Pergunta pergunta) {
		this.repository.delete(pergunta);
	}

}
