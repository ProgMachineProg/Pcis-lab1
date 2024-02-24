package org.homework;
import java.util.Scanner;
public class Task1 {
    private static final double PI = Math.PI;
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            System.out.print("Введіть крок n: ");
            int n = scanner.nextInt();

            System.out.print("Введіть k: ");
            int k = scanner.nextInt();

            System.out.print("Введіть точність e: ");
            double e = scanner.nextDouble();

            double a = 0.1;
            double b = 0.8;

            System.out.println("\nОбчислення функції f(x) = (x * sin(Pi / 4)) / (1 - 2x * cos(Pi / 4) + x^2)");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("| X | Y (точне) | Y1 (k = " + k + ") | Y2 (e = " + e + ") | Погр.1 | Погр.2 |");
            System.out.println("----------------------------------------------------------------------");

            for (double x = a; x <= b; x += n) {
                double yExact = exactValue(x);
                double y1 = approximateValueK(x, k);
                double y2 = approximateValueE(x, e);

                double error1 = Math.abs((yExact - y1) / yExact);
                double error2 = Math.abs((yExact - y2) / yExact);

                System.out.printf("| %.2f | %.4f | %.4f | %.4f | %.4f | %.4f |\n", x, yExact, y1, y2, error1, error2);
            }
        }

        private static double exactValue(double x) {
            return (x * Math.sin(PI / 4)) / (1 - 2 * x * Math.cos(PI / 4) + x * x);
        }

        private static double approximateValueK(double x, int k) {
            double sum = x * Math.sin(PI / 4);
            for (int i = 1; i <= k; i++) {
                sum += Math.pow(x, i) * Math.sin(i * PI / 4);
            }
            return sum;
        }

        private static double approximateValueE(double x, double e) {
            double sum = x * Math.sin(PI / 4);
            double prevSum = 0;
            int i = 1;
            while (Math.abs(sum - prevSum) > e) {
                prevSum = sum;
                sum += Math.pow(x, i) * Math.sin(i * PI / 4);
                i++;
            }
            return sum;
        }
    }

