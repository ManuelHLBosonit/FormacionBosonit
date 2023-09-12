package block5.command.line.runner;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Block5CommandLineRunnerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		System.out.println("Iniciando");
		SpringApplication.run(Block5CommandLineRunnerApplication.class, args);
		System.out.println("Fin");
	}

	@Override
	public void run(String... args) throws Exception {
		funcion3("Probando");
	}

	@PostConstruct //Se ejecuta después de que Spring haya inicializado el bean pero antes de que se ejecute el metodo run
	public void funcion1() {
		System.out.println("Hola desde la clase principal");
	}



	@Bean
	CommandLineRunner funcion2()
	{
		return m ->
		{
			System.out.println("Hola desde clase secundaria");
		};
	}

	public void funcion3(String frase) { //Se llama en el metodo run
		System.out.println(frase);
	}

}
