package study;

import java.util.Scanner;

public class StringCalcaulator {

    private String[] values;

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        values = value.split(" ");

        int[] numbers = new int[values.length / 2 + 1];
        String[] operator = new String[values.length / 2];
        for (int i = 0; i < values.length; i++) {
            addNumber(i, numbers);
            addOperator(i, operator);
        }

        System.out.print(calculate(numbers, operator));
    }
    public void addNumber(int index, int[] numbers) {
        if (index % 2 == 0) {
            numbers[index / 2] = Integer.parseInt(values[index]);
        }
    }

    public void addOperator(int index, String[] operator) {
        if (index % 2 != 0) {
            operator[index / 2] = values[index];
        }
    }

    private int calculate(int[] numbers, String[] operator) {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (operator[i - 1].equals("+")) result += numbers[i];
            if (operator[i - 1].equals("-")) result -= numbers[i];
            if (operator[i - 1].equals("*")) result *= numbers[i];
            if (operator[i - 1].equals("/")) result /= numbers[i];
        }
        return result;
    }


}
