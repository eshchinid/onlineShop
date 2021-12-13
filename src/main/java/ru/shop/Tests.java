package ru.shop;

import org.w3c.dom.ls.LSOutput;
import ru.shop.model.Product;
import ru.shop.model.ProductCategory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Tests {
    public static void main(String[] args) throws IOException {
        List<Product> products = new LinkedList<>();
        products.add(new Product("Коровье молоко", "жирность 3,2%", 70, ProductCategory.Food));
        products.add(new Product("Гитара Gibson", "Gibson Les Poul 1987", 120000, ProductCategory.musicalInstruments));
        products.add(new Product("Гитара ESP", "ESP LTD Hatfield", 80000, ProductCategory.musicalInstruments));
        products.add(new Product("Purina Pro Plan", "Корм для собак с тунцом", 7000, ProductCategory.animalFood));
        products.add(new Product("Acana", "Корм для кошек с курицей", 8000, ProductCategory.animalFood));
        products.add(new Product("Тунец", "Тунец атлантичский", 4000, ProductCategory.Food));
        products.add(new Product("XBOX", "Xbox series X", 60000, ProductCategory.technics));
        products.add(new Product("PS", "PlayStation 4", 50000, ProductCategory.technics));

        List<Product> foodList = products.stream().filter(pr -> pr.getProductCategory() == ProductCategory.Food).sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
        List<Product> techList = products.stream().filter(pr -> pr.getProductCategory() == ProductCategory.technics).sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
        List<Product> musList = products.stream().filter(pr -> pr.getProductCategory() == ProductCategory.musicalInstruments).sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
        List<Product> animalList = products.stream().filter(pr -> pr.getProductCategory() == ProductCategory.animalFood).sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());

        System.out.println("-----Магазин-----" + "\n" +
                "-----------------" + "\n" +
                "1. Продукты" + "\n" +
                "2. Музыкальные инструменты" + "\n" +
                "3. Техника" + "\n" +
                "4. Товары для животных" + "\n" +
                "5. Поиск товара" + "\n" +
                "-----------------"
        );

        System.out.println("Выберете пункт меню: ");
        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();
        if (choice == 1) {
            foodList.forEach(System.out::println);
        } else if (choice == 2) {
            musList.forEach(System.out::println);
        } else if (choice == 3) {
            techList.forEach(System.out::println);
        } else if (choice == 4) {
            animalList.forEach(System.out::println);
        } else if (choice == 5) {
            System.out.println("Что искать?");
//            Scanner scanner1 = new Scanner(System.in);
//            String request = scanner1.nextLine();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String request = br.readLine();
            System.out.println("Вы ввели:" + request);

//      Не работает
//            for (Product product : products) {
//                if (product.getName() == request) {
//                    System.out.println("По наименованиям найдено: " + product);
//                } else if (product.getDescription() == request) {
//                    System.out.println("Может подойдет это?: " + product);
//                }
//                System.out.println("Такого товара нет");
//            }
//      хер знает почему, но нижнее условие не работает до конца
            String s = products.stream().filter(p-> p.getName().equalsIgnoreCase(request))
                            .findAny().toString();
            String b = products.stream().filter(p-> p.getDescription().toLowerCase().contains(request.toLowerCase()))
                    .findAny().toString();



            if (s != null){
                System.out.println("Товаров найдено : " + "\n" + s);
            } else if (b != null) {
                System.out.println("Возможно вы искали это? : " + "\n" + b);
            } else System.out.println("Товаров не найдено");



        }



    }

}
