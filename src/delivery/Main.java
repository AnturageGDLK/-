package delivery;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Map<Address, Integer> costPerAddress = new HashMap<>();

        Address russiaMoscow = new Address("россия", "москва");
        Address russiaKazan = new Address("россия", "казань");
        Address usaNewYork = new Address("сша", "нью-йорк");
        Address germanyBerlin = new Address("германия", "берлин");

        costPerAddress.put(russiaMoscow, 200);
        costPerAddress.put(russiaKazan, 200);
        costPerAddress.put(usaNewYork, 800);
        costPerAddress.put(germanyBerlin, 500);

        Scanner scanner = new Scanner(System.in);

        int totalCost = 0;
        Set<String> deliveredCountries = new HashSet<>();

        while (true) {
            System.out.println();
            System.out.println("Заполнение нового заказа.");
            System.out.print("Введите страну (или end для выхода): ");
            String country = scanner.nextLine().trim().toLowerCase();

            if (country.equalsIgnoreCase("end")) {
                break;
            }

            System.out.print("Введите город: ");
            String city = scanner.nextLine().trim().toLowerCase().replace(" ", "-");

            System.out.print("Введите вес (кг): ");
            String weightInput = scanner.nextLine().trim();

            int weight;
            try {
                weight = Integer.parseInt(weightInput);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный вес.");
                continue;
            }

            if (weight <= 0) {
                System.out.println("Вес должен быть положительным.");
                continue;
            }

            Address address = new Address(country, city);
            Integer pricePerKg = costPerAddress.get(address);

            if (pricePerKg == null) {
                System.out.println("Доставки по этому адресу нет");
            } else {
                int orderCost = pricePerKg * weight;
                totalCost += orderCost;
                deliveredCountries.add(country);

                System.out.println("Стоимость доставки составит: " + orderCost + " руб.");
                System.out.println("Общая стоимость всех доставок: " + totalCost + " руб.");
                System.out.println("Количество уникальных стран с доставками: "
                        + deliveredCountries.size());
            }
        }

        System.out.println("\nПрограмма завершена");
        scanner.close();
    }
}
