package desenvolviomento.web.dev.perguntar.service;

import java.util.List;

import desenvolviomento.web.dev.perguntar.model.seletores.PerguntaSeletor;
import desenvolviomento.web.dev.perguntar.model.specification.PerguntaSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import desenvolviomento.web.dev.perguntar.exceptions.CampoInvalidoException;
import desenvolviomento.web.dev.perguntar.model.entity.Pergunta;
import desenvolviomento.web.dev.perguntar.model.repository.PerguntaRepository;
import org.springframework.transaction.annotation.Transactional;

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

	public Page<Pergunta> buscarComSeletor(PerguntaSeletor seletor, Pageable page){
		Specification<Pergunta> specification = Specification.where(null);
		if(seletor.getNome() != null && !seletor.getNome().isBlank()) {
			specification = specification.and(PerguntaSpecification.temTitulo(seletor.getNome()));
		}
		if(seletor.getDataFinal() != null && seletor.getDataFinal() != null){
			specification = specification.and(PerguntaSpecification
					.temDataInicialEDataFinal(seletor.getDataInicial(), seletor.getDataFinal()));
		} else if(seletor.getDataInicial() != null){
			specification = specification.and(PerguntaSpecification.temDataInicial(seletor.getDataInicial()));
		}
		if(seletor.getIdCategoria() != null){
			specification = specification.and(PerguntaSpecification.temCategoria(seletor.getIdCategoria()));
		}
		if(seletor.getResolvida() != null && seletor.getResolvida()){
			specification = specification.and(PerguntaSpecification.foiResolvida());
		}

		return repository.findAll(specification, page);
	}

	public Pergunta salvar(Pergunta pergunta) throws CampoInvalidoException {
		this.ValidaCampos(pergunta);
		return this.repository.save(pergunta);
	}

	public Pergunta atualizar(Pergunta pergunta) throws CampoInvalidoException {
		this.ValidaCampos(pergunta);
		return this.repository.save(pergunta);
	}

	@Transactional
	public void marcarPerguntaComoResolvida(Long id){
		this.repository.marcarPerguntaComoResolvida(id);
	}

	public void deletar(Pergunta pergunta) {
		this.repository.delete(pergunta);
	}
	
    private void ValidaCampos(Pergunta pergunta) throws CampoInvalidoException {
        String mensagem = "";

        if (pergunta.getTitulo() == null || pergunta.getTitulo().isBlank() || pergunta.getTitulo().length() > 100) {
            mensagem += "Título inválido\n";
        }
        if (pergunta.getConteudo() == null || pergunta.getConteudo().isBlank()) {
            mensagem += "Conteúdo inválido\n";
        }
        if (pergunta.getDataPergunta() == null) {
            mensagem += "Data da pergunta inválida\n";
        }

        if (!mensagem.isBlank()) {
            throw new CampoInvalidoException(mensagem);
        }
    }

}
