package primerparcialback_48938.controllers;
import primerparcialback_48938.entities.Persona;
import primerparcialback_48938.services.PersonaServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/persona")
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl>{
}
