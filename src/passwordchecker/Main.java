package passwordchecker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordChecker checker = new PasswordChecker();

        try {
            System.out.print("Введите мин. длину пароля: ");
            int minLength = scanner.nextInt();

            System.out.print("Введите макс. допустимое количество повторений символа подряд: ");
            int maxRepeats = scanner.nextInt();
            scanner.nextLine();


            checker.setMinLength(minLength);
            checker.setMaxRepeats(maxRepeats);

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
            System.out.println("Программа завершена");
            return;
        }


        while (true) {
            System.out.print("\nВведите пароль или end: ");
            String password = scanner.nextLine();

            if (password.equals("end")) {
                System.out.println("\nПрограмма завершена");
                break;
            }

            try {
                boolean ok = checker.verify(password);
                if (ok) {
                    System.out.println("Подходит!");
                } else {
                    System.out.println("Не подходит!");
                }
            } catch (IllegalStateException e) {
                System.out.println("Ошибка: " + e.getMessage());
                System.out.println("Программа завершена");
                break;
            }
        }
    }
}
