import java.util.ArrayList;
import java.util.Scanner;

class Tarea {
    private static int contador = 1;  // Para generar IDs de tareas de forma incremental
    private int idTarea;
    private String descripcion;
    private String estado;  // "pendiente" o "completada"

    // Constructor
    public Tarea(String descripcion) {
        this.idTarea = contador++;
        this.descripcion = descripcion;
        this.estado = "pendiente";
    }

    // Getters
    public int getIdTarea() {
        return idTarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    // Setter para cambiar el estado de la tarea
    public void marcarComoCompletada() {
        this.estado = "completada";
    }

    // Método para imprimir los detalles de la tarea
    public void mostrarDetalles() {
        System.out.println("ID: " + idTarea + ", Descripción: " + descripcion + ", Estado: " + estado);
    }
}

public class Gestor {

    private static ArrayList<Tarea> listaTareas = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nGestor de Tareas");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Marcar tarea como completada");
            System.out.println("3. Eliminar tarea");
            System.out.println("4. Mostrar lista de tareas pendientes");
            System.out.println("5. Mostrar lista de tareas completadas");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    agregarTarea(scanner);
                    break;
                case 2:
                    marcarTareaComoCompletada(scanner);
                    break;
                case 3:
                    eliminarTarea(scanner);
                    break;
                case 4:
                    mostrarTareasPendientes();
                    break;
                case 5:
                    mostrarTareasCompletadas();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    // Método para agregar una tarea
    public static void agregarTarea(Scanner scanner) {
        System.out.print("Ingresa la descripción de la tarea: ");
        String descripcion = scanner.nextLine();
        Tarea nuevaTarea = new Tarea(descripcion);
        listaTareas.add(nuevaTarea);
        System.out.println("Tarea agregada con éxito.");
    }

    // Método para marcar una tarea como completada
    public static void marcarTareaComoCompletada(Scanner scanner) {
        System.out.print("Ingresa el ID de la tarea a completar: ");
        int id = scanner.nextInt();

        boolean tareaEncontrada = false;
        for (Tarea tarea : listaTareas) {
            if (tarea.getIdTarea() == id && tarea.getEstado().equals("pendiente")) {
                tarea.marcarComoCompletada();
                tareaEncontrada = true;
                System.out.println("Tarea marcada como completada.");
                break;
            }
        }
        if (!tareaEncontrada) {
            System.out.println("No se encontró una tarea pendiente con ese ID.");
        }
    }

    // Método para eliminar una tarea
    public static void eliminarTarea(Scanner scanner) {
        System.out.print("Ingresa el ID de la tarea a eliminar: ");
        int id = scanner.nextInt();

        boolean tareaEliminada = false;
        for (Tarea tarea : listaTareas) {
            if (tarea.getIdTarea() == id) {
                listaTareas.remove(tarea);
                System.out.println("Tarea eliminada con éxito.");
                tareaEliminada = true;
                break;
            }
        }
        if (!tareaEliminada) {
            System.out.println("No se encontró una tarea con ese ID.");
        }
    }

    // Método para mostrar la lista de tareas pendientes
    public static void mostrarTareasPendientes() {
        System.out.println("\nTareas Pendientes:");
        boolean hayTareasPendientes = false;
        for (Tarea tarea : listaTareas) {
            if (tarea.getEstado().equals("pendiente")) {
                tarea.mostrarDetalles();
                hayTareasPendientes = true;
            }
        }
        if (!hayTareasPendientes) {
            System.out.println("No hay tareas pendientes.");
        }
    }

    // Método para mostrar la lista de tareas completadas
    public static void mostrarTareasCompletadas() {
        System.out.println("\nTareas Completadas:");
        boolean hayTareasCompletadas = false;
        for (Tarea tarea : listaTareas) {
            if (tarea.getEstado().equals("completada")) {
                tarea.mostrarDetalles();
                hayTareasCompletadas = true;
            }
        }
        if (!hayTareasCompletadas) {
            System.out.println("No hay tareas completadas.");
        }
    }
}
