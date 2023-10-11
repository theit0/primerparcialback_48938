package primerparcialback_48938.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import primerparcialback_48938.entities.Persona;
import primerparcialback_48938.repositories.PersonaRepository;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class PersonaServiceImplTest {

    // Simulamos un comportamiento
    /*Cuando llamemos al metodo de persona service, y este llame
     al repositorio, no lo llame directamente, si no que simulemos
     una llamada que no dependa del funcionamiento de persona repository */
    @MockBean
    private PersonaRepository personaRepository;

    @Autowired
    private PersonaServiceImpl personaService;

    @Test
    void testSearchString() throws Exception {
        Persona persona = new Persona();
        persona.setNombre("Lionel");
        persona.setApellido("Messi");

        List<Persona> listaEnviada = new ArrayList<>();

        // Si no tuvieramos esto no seria test unitario
        // seria un test de integracion. Ya que al hacer esto
        // simulamos la busqueda en el repositorio, no se esta
        // testeando realmente en conjunto el service con el repository
        when(personaRepository.searchNativo("Lionel")).thenReturn(listaEnviada);

        assertEquals(listaEnviada, personaService.search("Lionel"));
    }
}
