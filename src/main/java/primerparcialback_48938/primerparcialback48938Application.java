package primerparcialback_48938;

import primerparcialback_48938.entities.*;
import primerparcialback_48938.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

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

				Autor autor = Autor.builder()
						.nombre("AutorPrueba")
						.apellido("ApellidoPrueba")
						.biografia("BiografiaDePrueba")
						.build();
				autorRepository.save(autor);

				List<Autor> autores = new ArrayList<Autor>();
				autores.add(autor);

				Libro libro = Libro.builder()
						.fecha(23)
						.genero("GeneroDePrueba")
						.titulo("TituloLibro")
						.paginas(2)
						.autores(autores)
						.build();
				libroRepository.save(libro);
				Libro libro2 = Libro.builder()
						.fecha(23)
						.genero("GeneroDePrueba")
						.titulo("TituloLibro2")
						.paginas(5)
						.build();
				libroRepository.save(libro2);

				List<Libro> libros = new ArrayList<Libro>();
				libros.add(libro);
				libros.add(libro2);

				Persona persona = Persona.builder()
						.nombre("Theo")
						.apellido("Pelegrina")
						.domicilio(domicilio)
						.dni(342432)
						.libros(libros)
						.build();
				personaRepository.save(persona);
				Autor autor1 = Autor.builder()
						.nombre("NombreAutor")
						.apellido("ApellidoAutor")
						.biografia("DescripcionAutor")
						.build();
				autorRepository.save(autor1);

		};
	}
}