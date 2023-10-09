package primerparcialback_48938;

import primerparcialback_48938.entities.*;
import primerparcialback_48938.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class primerparcialback48938Application {
	@Autowired
	AutorRepository autorRepository;
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	LibroRepository libroRepository;
	@Autowired
	LocalidadRepository localidadRepository;
	@Autowired
	PersonaRepository personaRepository;


	public static void main(String[] args) {
		SpringApplication.run(primerparcialback48938Application.class, args);
	}

	@Bean
	CommandLineRunner init(PersonaRepository personaRepository, AutorRepository autorRepository, DomicilioRepository domicilioRepository, LibroRepository libroRepository, LocalidadRepository localidadRepository) {
		return args -> {

			for(int i = 0; i<=20; i++){
				Localidad localidad  = Localidad.builder()
						.denominacion("LocalidadDePrueba")
						.build();
				localidadRepository.save(localidad);
				Domicilio domicilio = Domicilio.builder()
						.calle("CalleDePrueba")
						.numero(31312)
						.localidad(localidad)
						.build();
				domicilioRepository.save(domicilio);
				Persona persona = Persona.builder()
						.nombre("Theo")
						.apellido("Pelegrina")
						.domicilio(domicilio)
						.dni(342432)
						.build();
				personaRepository.save(persona);
				Libro libro = Libro.builder()
						.fecha(23)
						.genero("Genero: "+ 1)
						.titulo("TituloLibro")
						.paginas(2)
						.build();
				libroRepository.save(libro);
				Autor autor = Autor.builder()
						.nombre("NombreAutor")
						.apellido("ApellidoAutor")
						.biografia("DescripcionAutor")
						.build();
				autorRepository.save(autor);
			}

		};
	}
}