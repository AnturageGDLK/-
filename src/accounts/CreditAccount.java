package accounts;

public class CreditAccount extends Account {

    private final long creditLimit;

    public CreditAccount(long creditLimit) {
        super(0);
        if (creditLimit < 0) {
            throw new IllegalArgumentException("Кредитный лимит не может быть отрицательным");
        }
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean add(long amount) {
        if (amount <= 0) {
            return false;
        }

        long newBalance = balance + amount;

        if (newBalance > 0) {
            return false;
        }

        balance = newBalance;
        return true;
    }

    @Override
    public boolean pay(long amount) {
        if (amount <= 0) {
            return false;
        }

        long newBalance = balance - amount;

        if (newBalance < -creditLimit) {
            return false;
        }

        balance = newBalance;
        return true;
    }
}
