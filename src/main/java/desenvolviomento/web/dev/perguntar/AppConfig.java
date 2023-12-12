package desenvolviomento.web.dev.perguntar;

import desenvolviomento.web.dev.perguntar.model.conversores.DtoParaEntity;
import desenvolviomento.web.dev.perguntar.model.conversores.EntityParaDto;
import desenvolviomento.web.dev.perguntar.model.dto.RespostaArvoreDTO;
import desenvolviomento.web.dev.perguntar.model.dto.RespostaDTO;
import desenvolviomento.web.dev.perguntar.model.entity.Resposta;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.text.html.parser.Entity;

@Configuration
public class AppConfig {
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		// configuração de Entity de resposta para DTO de arvore de resposta
		modelMapper.typeMap(Resposta.class, RespostaArvoreDTO.class).addMappings(mapper -> {
			mapper.map(Resposta::getConteudo, RespostaArvoreDTO::setLabel);
			mapper.map(Resposta::getId, RespostaArvoreDTO::setKey);
			mapper.map(Resposta::getRespostasFilhas, RespostaArvoreDTO::setChildren);
			mapper.map(src -> src.getUsuario().getId(), RespostaArvoreDTO::setIdUsuario);
		});

		// configuração de DTO de arvore de resposta para Entity de resposta
//		modelMapper.typeMap(RespostaDTO.class, Resposta.class).addMappings(mapper -> {
//			mapper.map(RespostaDTO::getIdRespostaPai, (dest, value) -> {
//				Resposta respostaPai = new Resposta();
//				respostaPai.setId((Long)value);
//				dest.setRespostaPai(respostaPai);
//			});
//		});
		return modelMapper;
	}

	@Bean
	public DtoParaEntity dtoParaEntity() { return new DtoParaEntity(); }

	@Bean
	public EntityParaDto entityParaDto(){
		return new EntityParaDto();
	}
}
