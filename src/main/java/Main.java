import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        print("На сколько человек необходимо разделить счёт?");
        Scanner scanner = new Scanner(System.in);
        Calc calc = new Calc(scanner);
        int quantityUser = scanner.nextInt();
        enterQuantityUser(quantityUser);
        calc.addProductToCalc();
        calc.printProducts();
        calc.printAmountPerPerson(quantityUser);


    }
    private static void enterQuantityUser(int quantityUser){
        while (true){
            if (quantityUser == 1) {
                print("Нет смысла делить счет на одного :)");
            }
            if (quantityUser <= 0) {
                print("Некорректное значение :(");
            }
            if (quantityUser > 1) {
                break;
            }
        }
    }
    private static void print (String message){
        System.out.println(message);
    }
}