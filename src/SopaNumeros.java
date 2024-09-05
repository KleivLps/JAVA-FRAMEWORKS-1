import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class SopaNumeros {
    public static void main(String[] args) {
        ArrayList<Integer> valores = leervalores();
        int suma = calcularSuma(valores);
        double promedio = calcularPromedio(valores);
        mostrarResultados(valores, suma, promedio);
    }

    public static ArrayList<Integer> leervalores() {
        ArrayList<Integer> valores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int numeros;

        System.out.println("Ingresa valores numéricos enteros. Luego, ingresa -99: ");
        while (true) {
            System.out.println("Ingresa un número: ");
            numeros = scanner.nextInt();

            if (numeros == -99) {
                break;
            }

            valores.add(numeros);
        }
        return valores;
    }

    public static int calcularSuma(ArrayList<Integer> valores ) {
        int suma = 0;
        Iterator<Integer> iterador = valores.iterator();

        while (iterador.hasNext()) {
            suma += iterador.next();
        }
        return suma;
    }

    public static double calcularPromedio(ArrayList<Integer> valores) {
        if (valores.isEmpty()){
            return 0;
        }
        int suma = calcularSuma(valores);
        return (double) suma / valores.size();
    }

    public static void mostrarResultados(ArrayList<Integer> valores, int suma, double promedio) {
        System.out.println("\nvalores ingresados:");
        for (int valor : valores) {
            System.out.println(valor);
        }

        System.out.println("\nTotal de valores ingresados: " +valores.size());
        System.out.println("Suma de los valores: " +suma);
        System.out.println("Media (promedio) de los valores: " +promedio);

        int contadorMayorQuePromedio = 0;

        for (int valor : valores) {
            if (valor > promedio) {
                contadorMayorQuePromedio++;
            }
        }

        System.out.println("Cantidad de valores mayores que la media: " +contadorMayorQuePromedio);
    }
}
