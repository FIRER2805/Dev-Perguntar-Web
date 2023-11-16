package desenvolviomento.web.dev.perguntar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desenvolviomento.web.dev.perguntar.exceptions.CampoInvalidoException;
import desenvolviomento.web.dev.perguntar.model.entity.Categoria;
import desenvolviomento.web.dev.perguntar.model.entity.Usuario;
import desenvolviomento.web.dev.perguntar.model.repository.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> buscarTodos() {
        return (List<Categoria>) repository.findAll();
    }

    public Categoria buscarPorId(Long id) {
    	return repository.findById(id).get();
    }

    public Categoria salvar(Categoria categoria) throws CampoInvalidoException {
    	this.ValidaCampos(categoria);
        return repository.save(categoria);
    }

    public Categoria atualizar(Categoria categoria) throws CampoInvalidoException {
    	this.ValidaCampos(categoria);
        return repository.save(categoria);
    }

    public void deletar(Categoria categoria) {
        repository.delete(categoria);
    }
    
	private void ValidaCampos(Categoria categoria) throws CampoInvalidoException{
        String mensagem = "";
        
		if (categoria.getNome() == null || categoria.getNome().isBlank() || categoria.getNome().length() > 50) {
            mensagem += "Nome inválido\n";
        }
        
        if(!mensagem.isBlank()) {
        	throw new CampoInvalidoException(mensagem);
        }
	}
}