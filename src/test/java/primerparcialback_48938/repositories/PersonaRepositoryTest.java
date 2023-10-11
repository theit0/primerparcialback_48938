package primerparcialback_48938.repositories;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import primerparcialback_48938.entities.Persona;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;




@DataJpaTest //setea una bd de h2 en memoria
public class PersonaRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private PersonaRepository personaRepository;

    @Test
    void testSearchString() {
        Persona persona = new Persona();
        persona.setNombre("Lionel");
        persona.setApellido("Messi");

        List<Persona> listaEnviada = new ArrayList();
        listaEnviada.add(persona);

        entityManager.persist(persona);
        entityManager.flush();

        assertEquals(listaEnviada, personaRepository.searchNativo("Lionel"));
        assertEquals(listaEnviada, personaRepository.searchNativo("Messi"));


    }
}
