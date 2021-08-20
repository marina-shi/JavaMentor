package SecondSolution;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    static int number1, number2;
    static char operation;
    static int result = 0;


    private static int romeToArab (String rome) {
        try {
            if (rome.equals("I")) {
                return 1;
            } else if (rome.equals("II")) {
                return 2;
            } else if (rome.equals("III")) {
                return 3;
            } else if (rome.equals("IV")) {
                return 4;
            } else if (rome.equals("V")) {
                return 5;
            } else if (rome.equals("VI")) {
                return 6;
            } else if (rome.equals("VII")) {
                return 7;
            } else if (rome.equals("VIII")) {
                return 8;
            } else if (rome.equals("IX")) {
                return 9;
            } else if (rome.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return -1;
    }

    private static String arabToRome (int numArabian) {
        String [] rome = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        final String s = rome[numArabian];
        return s;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите выражение арабских чисел: 1 + 2 или выражение двух римских чисел: I - X. Цифры принимаются от 1 до 10");
            String line = scanner.nextLine();

            try {
                String[] symbols = line.split(" ");
                if (symbols.length != 3) {
                    throw new Exception("Количество цифр больше 2-х или нет пробелов");
                }
                for (int i = 0; i < symbols.length; i++) {
                    number1 = Integer.parseInt(symbols[0]);
                    number2 = Integer.parseInt(symbols[2]);


                    if (symbols[1].equals("+")) {
                        operation = '+';
                    } else if (symbols[1].equals("-")) {
                        operation = '-';
                    } else if (symbols[1].equals("*")) {
                        operation = '*';
                    } else if (symbols[1].equals("/")) {
                        operation = '/';
                    }
                    else {
                        throw new IllegalArgumentException("Неверный знак операции");
                    }
                }

                result = calculate(number1, number2, operation);
            } catch (Exception e) {
                System.out.println("Exception : " + e);
                break;
            }
//            for (int i = 0; i < line.length(); i++) {
//                numbers[i] = line.charAt(i);
//                if (numbers[i] == '+') {
//                    operation = '+';
//                }
//                if (numbers[i] == '-') {
//                    operation = '-';
//                }
//                if (numbers[i] == '*') {
//                    operation = '*';
//                }
//                if (numbers[i] == '/') {
//                    operation = '/';
//                }
//                System.out.print(operation);
//            }
        }
        }

    public static int calculate(int num1, int num2, char oper){

            switch (oper) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    try {
                        result = num1 / num2;
                    } catch (ArithmeticException | InputMismatchException e) {
                        System.out.println("Exception : " + e);
                        System.out.println("Only integer non-zero parameters allowed");
                        break;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Неверный знак операции");
            }
        System.out.println(result);
            return result;
    }

}
