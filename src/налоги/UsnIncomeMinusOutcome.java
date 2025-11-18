package налоги;

public class UsnIncomeMinusOutcome extends TaxSystem {

    @Override
    public int calcTax(int debit, int credit) {
        int profit = debit - credit;

        if (profit <= 0) {
            return 0;
        }
        return profit * 15 / 100;
    }
}
