import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        print("На сколько человек необходимо разделить счёт?");
        Scanner scanner = new Scanner(System.in);
        Scanner scannerForCalc = new Scanner(System.in);
        int quantityUser = quantityUserChecker(enterQuantityUser(scanner), scanner);
        Calc calc = new Calc(scannerForCalc);
        calc.addProductToCalc();
        calc.printProducts();
        calc.printAmountPerPerson(quantityUser);
    }

    private static int enterQuantityUser(Scanner scanner) {
        try {
            return scanner.nextInt();

        } catch (Exception e) {
            print("некорректное значение! пожалуйста, введите целое число больше 1");
            return enterQuantityUser(new Scanner(System.in));
        }
    }

    private static int quantityUserChecker(int quantityUser, Scanner scanner) {
        while (true) {
            if (quantityUser == 1) {
                print("Нет смысла делить счет на одного :)");
                quantityUser = enterQuantityUser(scanner);
            }
            if (quantityUser <= 0) {
                print("Некорректное значение :(");
                quantityUser = enterQuantityUser(scanner);

            }
            if (quantityUser > 1) {
                break;
            }
        }
        return quantityUser;

    }

    private static void print(String message) {
        System.out.println(message);
    }
}