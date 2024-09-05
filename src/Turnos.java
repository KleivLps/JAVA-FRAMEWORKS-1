import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Turnos {
    private static ArrayList<Integer> turnos = new ArrayList<>();
    private static int ultimoTurno = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nSistema de asignacion de turnos");
            System.out.println("1. Asignar nuevo turno.");
            System.out.println("2. Atender cliente por orden de llegada.");
            System.out.println("3. Realizar sorteo y atender clientes.");
            System.out.println("4. Mostrar turnos actuales.");
            System.out.println("5. Salir.");
            System.out.println("Elige una opcion:");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    asignarTurno();
                    break;
                case 2:
                    atenderCliente();
                    break;
                case 3:
                    sortearCliente();
                    break;
                case 4:
                    mostrarTurnos();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion !=5);
    }

    public static void asignarTurno() {
        ultimoTurno++;
        turnos.add(ultimoTurno);
        System.out.println("Se ha asignado el turno numero: " +ultimoTurno);
    }

    public static void sortearCliente() {
        if (!turnos.isEmpty()) {
            Random random = new Random();
            int indiceSorteado = random.nextInt(turnos.size());
            int turnoSorteado = turnos.remove(indiceSorteado);
            System.out.println("Sorteo realizado. Atendiendo al cliente con el turno numero: " +turnoSorteado);
        } else {
            System.out.println("No hay turnos en espera.");
        }
    }

    public static void atenderCliente() {
        if (!turnos.isEmpty()) {
            int turnoAtendido = turnos.remove(0);
            System.out.println("Atendiendo al cliente con el turno numero: " +turnoAtendido);
        } else {
            System.out.println("No hay turnos en espera. ");
        }
    }


    public static void mostrarTurnos() {
        if (!turnos.isEmpty()) {
            System.out.println("Turnos actuales en espera: ");
            for (int turno : turnos) {
                System.out.println("Turno: " +turno);
            }
        } else {
            System.out.println("No hay turnos en espera.");
        }
    }
}
