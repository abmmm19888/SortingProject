package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final int ASCENDING = 1;
    private static final int DESCENDING = 2;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Integer> numbers = new ArrayList<>();
            System.out.println("Enter numbers separated by spaces (the number 4 is not allowed):");

            readNumbers(scanner, numbers);

            System.out.println("Select the type of sorting: 1 for ascending, 2 for descending:");
            sortAndDisplay(scanner, numbers);
        }
    }

    private static void readNumbers(Scanner scanner, ArrayList<Integer> numbers) {
        String[] input = scanner.nextLine().split(" ");
        for (String str : input) {
            try {
                int number = Integer.parseInt(str);
                if (number == 4) {
                    System.out.println("The number 4 is not allowed. Program terminated.");
                    return;
                }
                numbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Program terminated.");
                return;
            }
        }
    }

    private static void sortAndDisplay(Scanner scanner, ArrayList<Integer> numbers) {
        try {
            int sortType = scanner.nextInt();
            String message = switch (sortType) {
                case ASCENDING -> {
                    sortListUsingBubbleSort(numbers, true);
                    yield "Sorted list in ascending order: " + numbers;
                }
                case DESCENDING -> {
                    sortListUsingBubbleSort(numbers, false);
                    yield "Sorted list in descending order: " + numbers;
                }
                default -> "Invalid option. Program terminated.";
            };
            System.out.println(message);
        } catch (Exception e) {
            System.out.println("Invalid input. Program terminated.");
        }
    }

    public static void sortListUsingBubbleSort(ArrayList<Integer> list, boolean ascending) {
        int listSize = list.size();
        for (int i = 0; i < listSize - 1; i++) {
            for (int j = 0; j < listSize - 1 - i; j++) {
                boolean shouldSwap = (ascending && list.get(j) > list.get(j + 1)) || (!ascending && list.get(j) < list.get(j + 1));
                if (shouldSwap) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}
