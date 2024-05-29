import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Integer> numbers = new ArrayList<>();
            System.out.println("Enter numbers separated by spaces (the number 4 is not allowed):");

            String[] input = scanner.nextLine().split(" ");
            for (String str : input) {
                try {
                    int num = Integer.parseInt(str);
                    if (num == 4) {
                        System.out.println("The number 4 is not allowed. Program terminated.");
                        return;
                    }
                    numbers.add(num);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Program terminated.");
                    return;
                }
            }

            System.out.println("Select the type of sorting: 1 for ascending, 2 for descending:");
            int sortType = scanner.nextInt();

            switch (sortType) {
                case 1 -> {
                    bubbleSort(numbers, true);
                    System.out.println("Sorted list in ascending order: " + numbers);
                }
                case 2 -> {
                    bubbleSort(numbers, false);
                    System.out.println("Sorted list in descending order: " + numbers);
                }
                default -> System.out.println("Invalid option. Program terminated.");
            }
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
