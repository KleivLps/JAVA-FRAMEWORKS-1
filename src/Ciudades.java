import java.util.ArrayList;
import java.util.Scanner;

public class Ciudades {
    public static void main(String[] args) {
        ArrayList<String> ciudades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String opciones;

        do {
            System.out.println("Hola, ingresa el nombre de la ciudad que quieres añadir: ");
            String ciudad = scanner.nextLine();
            ciudades.add(ciudad);

            System.out.println("¿Deseas agregar otra ciudad? (SI/NO): ");
            opciones = scanner.nextLine();
    } while (opciones.equalsIgnoreCase("Si"));

        System.out.println("\nLista completa de ciudades añadidas: ");
        for (String ciudad: ciudades) {
            System.out.println(ciudad);
        }
        scanner.close();

}
    }