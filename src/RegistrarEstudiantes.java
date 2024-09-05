import java.util.ArrayList;
import java.util.Scanner;

class Estudiantes {
    private String documento;
    private String nombre;
    private int edad;

    public Estudiantes(String documento, String nombre, int edad) {

        this.documento = documento;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void mostrarDetalles() {
        System.out.println("Documento: " + documento + ", Nombre: " + nombre + ", Edad: " + edad );
    }
}

public class RegistrarEstudiantes {
    private static ArrayList<Estudiantes> estudiantes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nRegistro de Estudiante");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Eliminar estudiante");
            System.out.println("3. Mostrar lista de estudiantes");
            System.out.println("4. Buscar estudiante por documento");
            System.out.println("5. Salir");
            System.out.println("Elige una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarEstudiante(scanner);
                    break;
                case 2:
                    eliminarEstudiante(scanner);
                    break;
                case 3:
                    mostrarListaEstudiantes();
                    break;
                case 4:
                    buscarEstudiante(scanner);
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    }
            } while (opcion !=5);
        }

        public static void agregarEstudiante(Scanner scanner) {
            System.out.println("Ingresa el documento del estudiante: ");
            String documento = scanner.nextLine();
            System.out.println("Ingresa el nombre del estudiante: ");
            String nombre = scanner.nextLine();
            System.out.println("Ingresa la edad del estudiante: ");
            int edad = scanner.nextInt();
            scanner.nextLine();

            Estudiantes estudiante = new Estudiantes(documento, nombre, edad);
            estudiantes.add(estudiante);
            System.out.println("Estudiante agregado con exito.");
    }

    public static void eliminarEstudiante(Scanner scanner) {
        System.out.println("Ingresa el documento del estudiante a eliminar: ");
        String docuemnto = scanner.nextLine();

        Estudiantes estudianteAEliminar = null;
        for (Estudiantes estudiante : estudiantes) {
            if (estudiante.getDocumento().equals(docuemnto)) {
                estudianteAEliminar = estudiante;
                break;
            }
        }

        if (estudianteAEliminar != null) {
            estudiantes.remove(estudianteAEliminar);
            System.out.println("Estudiante eliminado con exito.");
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

    public static void mostrarListaEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            System.out.println("Lista de estudiantes registrados: ");
            for (Estudiantes estudiante : estudiantes) {
                estudiante.mostrarDetalles();
            }
        }
    }

    public static void buscarEstudiante(Scanner scanner) {
        System.out.println("Ingresa el documento del estudiante a buscar: ");
        String documento = scanner.nextLine();

        for (Estudiantes estudiante : estudiantes) {
            if (estudiante.getDocumento().equals(documento)) {
                System.out.println("Estudiante encontrado:");
                estudiante.mostrarDetalles();
        return;
    }
}

        System.out.println("Estudiante no encontrado.");
          }
         }