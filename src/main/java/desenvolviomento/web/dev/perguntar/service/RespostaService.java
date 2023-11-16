package desenvolviomento.web.dev.perguntar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desenvolviomento.web.dev.perguntar.model.entity.Resposta;
import desenvolviomento.web.dev.perguntar.model.repository.RespostaRepository;

@Service
public class RespostaService {
    @Autowired
    private RespostaRepository repository;

    public List<Resposta> buscarTodos() {
        return (List<Resposta>) repository.findAll();
    }

    public Resposta buscarPorId(Long id) {
    	return this.repository.findById(id).get();
    }

    public Resposta salvar(Resposta resposta) {
        return repository.save(resposta);
    }

    public Resposta atualizar(Resposta resposta) {
        return repository.save(resposta);
    }

    public void deletar(Resposta resposta) {
        repository.delete(resposta);
    }
    
    private void validaCampos(Resposta resposta) {
        if (resposta == null) {
        	
        }

        if (resposta.getConteudo() == null || resposta.getConteudo().isBlank()) {
        	
        }
    }
}
