package primerparcialback_48938.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import primerparcialback_48938.entities.Persona;

import java.util.List;

public interface PersonaService extends BaseService<Persona,Long>{
    List<Persona> search(String filtro) throws Exception;
    Page<Persona> searchPaged(String filtro, Pageable pageable) throws Exception;
}
