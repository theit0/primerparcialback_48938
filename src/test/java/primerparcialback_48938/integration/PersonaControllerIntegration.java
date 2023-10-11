package primerparcialback_48938.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import primerparcialback_48938.entities.Persona;
import primerparcialback_48938.primerparcialback48938Application;
import primerparcialback_48938.repositories.PersonaRepository;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = primerparcialback48938Application.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties"
)
public class PersonaControllerIntegration {
    //evaluan los test en conjunto
    //con los componentes interactuando entre si

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PersonaRepository personaRepository;

    @Test
    void testSearchString() throws Exception {
        Persona persona = new Persona();
        persona.setNombre("Theo");
        persona.setApellido("Pelegrina");

        personaRepository.save(persona);

        mockMvc.perform(get("/api/v1/persona/search")
                .param("filtro","Theo")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre",is("Theo")))
                .andExpect(jsonPath("$[0].apellido",is("Pelegrina")));

    }
}
