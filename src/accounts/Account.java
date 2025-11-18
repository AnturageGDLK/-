package accounts;

public abstract class Account {

    protected long balance;

    public Account(long initialBalance) {
        this.balance = initialBalance;
    }

    public long getBalance() {
        return balance;
    }

    public abstract boolean add(long amount);

    public abstract boolean pay(long amount);

    public boolean transfer(Account account, long amount) {
        if (account == null || amount <= 0) {
            return false;
        }

        if (!this.pay(amount)) {
            return false;
        }

        if (!account.add(amount)) {
            this.add(amount);
            return false;
        }

        return true;
    }
}
