import model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        List<Person> listPerson = readCsv("people.csv");
        int opc = 0;
        do {
            System.out.println("Seleccione una opción: \n" +
                    "1.-Mostrar todas las personas \n" +
                    "2.-Mostrar las personas menores de 25 años \n" +
                    "3.-Eliminar personas que empiecen por A \n" +
                    "4.-Primera persona de Madrid \n" +
                    "5.-Primera persona de Barcelona \n" +
                    "6.-Salir");
            try{
                opc = Integer.parseInt(s.nextLine());
                switch (opc){
                    case 1:
                        mostrarPersonas(listPerson);
                        break;
                    case 2:
                        filtradoPersonasMenores25(listPerson, 1);
                        break;
                    case 3:
                        filtrarSinLetraA(listPerson);
                        break;
                    case 4:
                        filtradoPersonasMenores25(listPerson, 2);
                        break;
                    case 5:
                        filtradoPersonasMenores25(listPerson, 3);
                        break;
                    case 6:
                        System.out.println("Fin del programa");
                        break;
                    default:
                        System.out.println("Seleccione una de las opciones validas");
                }
            }catch (NumberFormatException e){
                System.out.println("Intorduzca un valor correcto");
            }
        }while (opc != 6);
    }


    /*

  _____
 |  __ \
 | |__) |___  ___ _   _ _ __   ___ _ __ __ _ _ __   _ __   ___ _ __ ___  ___  _ __   __ _ ___
 |  _  // _ \/ __| | | | '_ \ / _ \ '__/ _` | '__| | '_ \ / _ \ '__/ __|/ _ \| '_ \ / _` / __|
 | | \ \  __/ (__| |_| | |_) |  __/ | | (_| | |    | |_) |  __/ |  \__ \ (_) | | | | (_| \__ \
 |_|  \_\___|\___|\__,_| .__/ \___|_|  \__,_|_|    | .__/ \___|_|  |___/\___/|_| |_|\__,_|___/
                       | |                         | |
                       |_|                         |_|

     */

    public static List<Person> readCsv(String ruta) {

        List<Person> listPeople = new ArrayList();
        try {
            List<String> lines = Files.readAllLines(Path.of(ruta));
            //Definimos las variable cont para saber en que linea nos situamos
            int cont = 0;
            if (lines.size() == 0) {
                System.out.println("No hay ninguna persona guardada");
            } else {
                for (String line : lines) {
                    cont++;
                    String[] parts = line.split(":");
                    long contador = line.chars().filter(ch -> ch == ':').count();

                    String name = parts[0].trim();

                    if (contador >= 2) {//Si tiene todas las partes
                        if (name.isEmpty())
                            throw new InvalidLineFormatException("El nombre es obligatorio. Hay 3 espacios en el campo y esto se considera como blank, error en la linea: " + line);
                            String town = parts.length >= 2 && !parts[1].isEmpty() ? parts[1] : "unknown";
                            int age = parts.length >= 3 ? Integer.parseInt(parts[2]) : 0;
                            listPeople.add(new Person(name, town, age));
                        } else {
                            if (contador == 1) {//Si le falta un delimitador
                                throw new InvalidLineFormatException("Falta el último delimitador de campo (:) en la linea: " + cont + ". " + line);
                            } else {//Si faltan dos delimitadores
                                throw new InvalidLineFormatException("Faltan dos delimitadores de campo (:) en la linea: " + cont + ". " + line);
                            }
                        }

                }
            }
        }catch(IOException e){
            throw new RuntimeException(e);
            }
        return listPeople;
    }



    /*

   _____                 __
  / ____|               /_ |
 | |     __ _ ___  ___   | |
 | |    / _` / __|/ _ \  | |
 | |___| (_| \__ \  __/  | |
  \_____\__,_|___/\___|  |_|



     */
    private static void mostrarPersonas(List<Person> listPerson) {
        for (Person person:
                listPerson) {
            System.out.println(person);
        }
        continuar();
    }

/*

   _____                 ___
  / ____|               |__ \
 | |     __ _ ___  ___     ) |
 | |    / _` / __|/ _ \   / /
 | |___| (_| \__ \  __/  / /_
  \_____\__,_|___/\___| |____|



 */

    private static void filtradoPersonasMenores25(List<Person> listPerson, int opc) {
        List<Person> listPersonFilter = listPerson.stream()
                .filter(p -> p.getAge() < 25 && p.getAge() != 0)
                .collect(Collectors.toList());
        if (listPersonFilter.size() == 0){
            System.out.println("No hay ninguna persona menor de 25" );
        }else {
            switch (opc) {
                case 1:
                    mostrarPersonas(listPersonFilter);
                    break;
                case 2:
                    primeraPersonaPorCiudad(listPersonFilter, "madrid");
                    break;
                case 3:
                    primeraPersonaPorCiudad(listPersonFilter, "barcelona");
                    break;
            }
        }

    }

/*

   _____                 ____        _  _         _____
  / ____|               |___ \      | || |       | ____|
 | |     __ _ ___  ___    __) |     | || |_      | |__
 | |    / _` / __|/ _ \  |__ <      |__   _|     |___ \
 | |___| (_| \__ \  __/  ___) |  _     | |    _   ___) |
  \_____\__,_|___/\___| |____/  ( )    |_|   ( ) |____/
                                |/           |/


 */

    private static void filtrarSinLetraA(List<Person> listPerson) {
        List<Person> listPersonFilter = listPerson.stream().filter(p -> !p.getName().toUpperCase().startsWith("A") && !p.getName().toUpperCase().startsWith("Á")).collect(Collectors.toList());
        if (listPersonFilter.size() == 0) System.out.println("No hay ninguna persona sin la letra A");
        mostrarPersonas(listPersonFilter);
    }
    private static void primeraPersonaPorCiudad(List<Person> listPerson, String ciudad) {
        Optional<Person> personaCiudad = listPerson.stream().filter(p -> p.getTown().toUpperCase().equals(ciudad.toUpperCase())).findFirst();
        personaCiudad.ifPresentOrElse(
                person -> System.out.println(person),
                () -> System.out.println("No hay ninguna persona en " + ciudad)
        );
        continuar();
    }



    //Para hacer una pequeña pausa
    private static void continuar() {
        System.out.println("Pulse enter para continuar");
        s.nextLine();
        System.out.println("\n \n");
    }


    //Para lanzar las excepciones
    static class InvalidLineFormatException extends RuntimeException {
        public InvalidLineFormatException(String message) {
            super(message);
        }
    }
}