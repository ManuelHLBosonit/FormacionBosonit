package block5properties;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Block5CommandLineRunnerApplication implements CommandLineRunner {

	@Value("${greeting}")
	private String text;

	@Value("${my.number}")
	private int num;

	@Value("${new.property:No tiene valor}")
	private String textProperty;

	@Value("${MYURL}")
	private String myurl;

	@Value("${MYURL2:No tiene valor}")
	private String myurl2;

	public static void main(String[] args) {
		SpringApplication.run(Block5CommandLineRunnerApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println(myurl);
		System.out.println("El valor de greeting es: " + text);
		System.out.println("El valor de my.number es: " + num);
		System.out.println("El valor de new.property es: " + textProperty);
		System.out.println(myurl2);
	}
}
