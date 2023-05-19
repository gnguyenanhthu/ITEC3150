public class CreditCard extends BankAccount{
    private double creditLimit;
    public CreditCard(int accountNumber, String name, String type, double balance, double creditLimit) {
        super(accountNumber, name, type, balance);
        this.creditLimit = creditLimit;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public String toString() {
        return creditLimit + "\n";
    }

    @Override
    public boolean checkLimit(double cash){
        return (this.getCreditLimit() >= (this.getBalance()+ cash));
    }

    @Override
    public double withdraw(double cash){
        this.setBalance(this.getBalance() + cash);
        return this.getBalance();
    }
}
