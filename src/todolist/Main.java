package todolist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tasks = new ArrayList<>();

        while (true) {
            printMenu();
            System.out.print("Ваш выбор: ");

            String input = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод, попробуйте снова.");
                System.out.println();
                continue;
            }

            if (choice == 0) {
                System.out.println("\nПрограмма завершена");
                break;
            } else if (choice == 1) {
                System.out.print("\nВведите название задачи: ");
                String task = scanner.nextLine();

                if (tasks.contains(task)) {
                    System.out.println("Такое дело уже есть!");
                } else {
                    tasks.add(task);
                    System.out.println("Добавлено!");
                }

                printTasks(tasks);
            } else if (choice == 2) {
                printTasks(tasks);
            } else if (choice == 3) {
                System.out.print("\nВведите номер для удаления: ");
                String numberInput = scanner.nextLine();
                int index;

                try {
                    index = Integer.parseInt(numberInput);
                } catch (NumberFormatException e) {
                    System.out.println("Некорректный номер.");
                    printTasks(tasks);
                    continue;
                }

                if (index < 1 || index > tasks.size()) {
                    System.out.println("Дела с таким номером нет.");
                } else {
                    tasks.remove(index - 1);
                    System.out.println("Удалено!");
                }

                printTasks(tasks);
            } else if (choice == 4) {
                System.out.print("\nВведите задачу для удаления: ");
                String textToRemove = scanner.nextLine();

                boolean removed = tasks.remove(textToRemove);
                if (removed) {
                    System.out.println("Удалено!");
                } else {
                    System.out.println("Дело с таким названием не найдено.");
                }

                printTasks(tasks);
            } else {
                System.out.println("Неизвестная команда, попробуйте снова.");
                System.out.println();
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("Выберите операцию:");
        System.out.println();
        System.out.println("0. Выход из программы");
        System.out.println("1. Добавить дело");
        System.out.println("2. Показать дела");
        System.out.println("3. Удалить дело по номеру");
        System.out.println("4. Удалить дело по названию");
    }

    private static void printTasks(List<String> tasks) {
        System.out.println("Ваш список дел:");
        if (tasks.isEmpty()) {
            System.out.println("(пока нет дел)");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
        System.out.println();
    }
}
