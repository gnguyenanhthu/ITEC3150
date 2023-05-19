public class CreditCard extends BankAccount{
    private int accountNumber;
    private String name, type;
    private double balance, creditLimit;

    public CreditCard(int accountNumber, String name, String type, double balance, double creditLimit) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.type = type;
        this.balance = balance;
        this.creditLimit = creditLimit;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "accountNumber=" + accountNumber +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                ", creditLimit=" + creditLimit +
                '}';
    }
}
