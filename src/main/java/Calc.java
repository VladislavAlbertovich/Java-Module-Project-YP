import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.swing.Spring;

public class Calc {
    private Scanner scanner;
    private List<Product> products = new ArrayList<>();

    private double commonPrice;

    Calc (Scanner scanner){
        this.scanner = scanner;
    }

    public void addProductToCalc(){

        while (true){

            print("Пожалуйста добавьте товар");
            print("введите название товара");
            String productName = scanner.next();
            print("введите стоимость товара");
            double productPrice = scanner.nextDouble();
            if (productPrice >= 0) {
                Product product = new Product(productName, productPrice);
                products.add(product);
                print("Товар успешно добавлен");
                commonPrice = commonPrice + productPrice;
            }
            print("текущая общая сумма " + commonPrice);
            print("добавить еще один товар?");
            String addAnotherProduct = scanner.next();
            String complete = "Завершить";
            if (addAnotherProduct.equalsIgnoreCase(complete)){
                break;
            }

        }
    }
    public void printProducts(){
        print("Добавленные товары:");
        for (int i = 0; i < products.size(); i++){
            Product product = products.get(i);
            String name = product.name;
            double price = product.price;
            print(name + " стоимостью " + price + '\n' + "Общая сумма: " + commonPrice + " " + caseRuble(commonPrice));

        }
    }

    public void printAmountPerPerson(int quantityPerson){
        double amount = commonPrice/quantityPerson;
        print("Cумма на человека " + amount + " " + caseRuble(amount));
    }
    private void print (String message){
        System.out.println(message);
    }

    private String caseRuble (double commonPrice) {

        String ruble;

        if (commonPrice >= 0 && commonPrice < 2) {
           ruble = "рубль";
       } else if (commonPrice >= 2 && commonPrice < 5) {
           ruble = "рубля";
       } else if (commonPrice >= 5){
           ruble = "рублей";
       } else {
            ruble = "неверная сумма";
        }
       return ruble;
    }
}
