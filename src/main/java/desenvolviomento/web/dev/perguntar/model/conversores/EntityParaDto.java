package desenvolviomento.web.dev.perguntar.model.conversores;

import desenvolviomento.web.dev.perguntar.model.dto.RespostaArvoreDTO;
import desenvolviomento.web.dev.perguntar.model.entity.Resposta;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EntityParaDto {
    @Autowired
    private ModelMapper modelMapper;

    public RespostaArvoreDTO arvoreDto(Resposta r){
        return modelMapper.map(r, RespostaArvoreDTO.class);
    }

}
