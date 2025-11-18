package accounts;

public class AccountsMain {

    public static void main(String[] args) {

        SimpleAccount simple = new SimpleAccount(1_000);

        CreditAccount credit = new CreditAccount(5_000);

        System.out.println("=== Стартовые балансы ===");
        System.out.println("Обычный счёт: " + simple.getBalance());
        System.out.println("Кредитный счёт: " + credit.getBalance());
        System.out.println();

        System.out.println("Покупка с обычного счёта на 300");
        System.out.println("Успех? " + simple.pay(300));
        System.out.println("Баланс обычного счёта: " + simple.getBalance());
        System.out.println();

        System.out.println("Покупка с кредитного счёта на 1000");
        System.out.println("Успех? " + credit.pay(1_000));
        System.out.println("Баланс кредитного счёта: " + credit.getBalance());
        System.out.println();

        System.out.println("Перевод 500 с обычного счёта на кредитный");
        System.out.println("Успех? " + simple.transfer(credit, 500));
        System.out.println("Баланс обычного счёта: " + simple.getBalance());
        System.out.println("Баланс кредитного счёта: " + credit.getBalance());
        System.out.println();

        System.out.println("Попробуем перевести 1000 с обычного счёта");
        System.out.println("Успех? " + simple.transfer(credit, 1_000));
        System.out.println("Баланс обычного счёта: " + simple.getBalance());
        System.out.println("Баланс кредитного счёта: " + credit.getBalance());
        System.out.println();

        System.out.println("Попробуем погасить долг по кредитному счёту на 10_000");
        System.out.println("Успех? " + credit.add(10_000));
        System.out.println("Баланс кредитного счёта: " + credit.getBalance());
    }
}
