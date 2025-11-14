package налоги;

public class Main {
    public static void main(String[] args) {

        Company company1 = new Company("Ромашка", new UsnIncome());

        company1.shiftMoney(100_000);
        company1.shiftMoney(-20_000);
        company1.payTaxes();

        company1.shiftMoney(100_000);
        company1.shiftMoney(-20_000);

        company1.setTaxSystem(new UsnIncomeMinusOutcome());
        company1.payTaxes();

        Company company2 = new Company("Василёк", new UsnIncomeMinusOutcome());

        company2.shiftMoney(50_000);
        company2.shiftMoney(-40_000);
        company2.payTaxes();
    }
}
