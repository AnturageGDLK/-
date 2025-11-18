package logger;

public class LoggerMain {

    public static void main(String[] args) {
        Logger simple = new SimpleLogger();
        Logger smart = new SmartLogger();

        System.out.println("=== SimpleLogger ===");
        simple.log("Приложение запущено");
        simple.log("Пользователь залогинился");
        simple.log("Произошла какая-то error, но мы продолжаем"); // тут просто текст

        System.out.println();
        System.out.println("=== SmartLogger ===");
        smart.log("Приложение запущено");
        smart.log("User login error");
        smart.log("Critical ERROR: system failure");
        smart.log("Всё ок, без ошибок");
    }
}
