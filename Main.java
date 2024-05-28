import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println("Ingrese números separados por espacios (el número 4 no está permitido):");

        String[] input = scanner.nextLine().split(" ");
        for (String str : input) {
            try {
                int num = Integer.parseInt(str);
                if (num == 4) {
                    System.out.println("El número 4 no está permitido. Programa terminado.");
                    return;
                }
                numbers.add(num);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Programa terminado.");
                return;
            }
        }

        System.out.println("Seleccione el tipo de ordenación: 1 para ascendente, 2 para descendente:");
        int sortType = scanner.nextInt();

        if (sortType == 1) {
            bubbleSort(numbers, true);
            System.out.println("Lista ordenada en orden ascendente: " + numbers);
        } else if (sortType == 2) {
            bubbleSort(numbers, false);
            System.out.println("Lista ordenada en orden descendente: " + numbers);
        } else {
            System.out.println("Opción inválida. Programa terminado.");
        }
    }

    public static void bubbleSort(ArrayList<Integer> list, boolean ascending) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if ((ascending && list.get(j) > list.get(j + 1)) || (!ascending && list.get(j) < list.get(j + 1))) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}
