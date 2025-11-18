package налоги;

public class UsnIncome extends TaxSystem {

    @Override
    public int calcTax(int debit, int credit) {
        return debit * 6 / 100;
    }
}
