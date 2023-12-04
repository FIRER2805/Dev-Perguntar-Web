package desenvolviomento.web.dev.perguntar.model.conversores;

import desenvolviomento.web.dev.perguntar.model.dto.PerguntaDTO;
import desenvolviomento.web.dev.perguntar.model.dto.RespostaArvoreDTO;
import desenvolviomento.web.dev.perguntar.model.dto.UsuarioDTO;
import desenvolviomento.web.dev.perguntar.model.entity.Usuario;
import org.modelmapper.ModelMapper;
import desenvolviomento.web.dev.perguntar.model.dto.RespostaDTO;
import desenvolviomento.web.dev.perguntar.model.entity.Pergunta;
import desenvolviomento.web.dev.perguntar.model.entity.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class DtoParaEntity {
    @Autowired
    private ModelMapper modelMapper;
    public Resposta resposta(RespostaDTO dto){
        Resposta resposta = modelMapper.map(dto, Resposta.class);
        // solução provisória para o bug do respostaPai
        // TODO melhorar isso
        if(dto.getIdRespostaPai() != null){
            Resposta respostaPai = new Resposta();
            respostaPai.setId(dto.getIdRespostaPai());
            resposta.setRespostaPai(respostaPai);
        }
        return resposta;
    }

    public Pergunta pergunta(PerguntaDTO dto){
        return modelMapper.map(dto, Pergunta.class);
    }

    public Usuario usuario(UsuarioDTO dto){
        return modelMapper.map(dto, Usuario.class);
    }
}
