import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Notas {
    public static void main(String[] args) {
        ArrayList<Integer> notas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String opciones;

        do {
            System.out.println("Ingresa una nota (entre 1 y 20): ");
            int nota= scanner.nextInt();

            if (nota >= 1 && nota <= 20) {
                notas.add(nota);
            } else {
                System.out.println("Nota no valida, debe estar entre el 1 y el 20");
            }
            System.out.println("¿Deseas agregar otra nota? (SI/NO): ");
            scanner.nextLine();

            opciones = scanner.nextLine();
        } while (opciones.equalsIgnoreCase("si"));

        Collections.sort(notas, Collections.reverseOrder());

        System.out.println("\nNotas en orden descendente: ");

        for (int nota : notas) {
            System.out.println(nota);
        }

        Collections.sort(notas);

        System.out.println("\nnotas en orden ascendente: ");
        for (int nota : notas) {
            System.out.println(nota);
        }
        scanner.close();
    }
}
