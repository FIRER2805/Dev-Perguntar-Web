package desenvolviomento.web.dev.perguntar;

import desenvolviomento.web.dev.perguntar.model.conversores.DtoParaEntity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public DtoParaEntity dtoParaEntity() { return new DtoParaEntity(); }
}
