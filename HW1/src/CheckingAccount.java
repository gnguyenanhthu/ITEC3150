public class CheckingAccount extends BankAccount{
    private int accountNumber;
    private String name, type;
    private double balance;

    public CheckingAccount(int accountNumber, String name, String type, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.type = type;
        this.balance = balance;
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

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "accountNumber=" + accountNumber +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                '}';
    }
}
