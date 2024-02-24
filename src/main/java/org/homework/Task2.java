package org.homework;

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть рядок: ");
        String str = scanner.nextLine();

        // Виймаємо цифри з рядка
        StringBuilder numbersBuilder = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                numbersBuilder.append(ch);
            }
        }

        // Перетворимо StringBuilder на String
        String numbers = numbersBuilder.toString();

        // Сортуємо цифри у масиві
        char[] chars = numbers.toCharArray();
        Arrays.sort(chars);

        // Реверсуємо масив char
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }

        // Перетворимо масив char на String
        String sortedNumbers = new String(chars);

        // Замінюємо всі цифри у вихідному рядку відсортованими
        String result = str.replaceAll("[0-9]", "");
        result = result.concat(sortedNumbers);

        System.out.println("Вихідний рядок: " + str);
        System.out.println("Перетворений рядок: " + result);
    }
}