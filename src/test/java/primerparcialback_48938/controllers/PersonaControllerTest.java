package primerparcialback_48938.controllers;
import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import primerparcialback_48938.entities.Persona;
import primerparcialback_48938.services.PersonaServiceImpl;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PersonaController.class) // Se accede desde la web
public class PersonaControllerTest {

    @MockBean
    private PersonaServiceImpl personaService;

    // Lo usamos para ejecutar peticiones desde adentro de nuestra prueba
    @Autowired
    private MockMvc mockMvc;


    @Test
    void testSearchString() throws Exception {
        Persona persona = new Persona();
        persona.setNombre("Edison");
        persona.setApellido("Cavani");

        List<Persona> listaEnviada = new ArrayList();
        listaEnviada.add(persona);

        when(personaService.search("Edison")).thenReturn(listaEnviada);

        //Hacer una peticion
        mockMvc.perform(get("/api/v1/persona/search")
                .param("filtro","Edison")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre",is("Pablo")))
                .andExpect(jsonPath("$[0].apellido",is("Cavani")));
    }
}
