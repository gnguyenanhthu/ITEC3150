import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
// need to establish array for accounts
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();
// open the input file for reading
        File accountsFile = new File("accounts.txt");
        Scanner scan;
        try {
            scan = new Scanner(accountsFile);
            while (scan.hasNext()) {
                String line = scan.nextLine();
                int number = scan.nextInt();
                String name = scan.nextLine();
                String type = scan.nextLine();
                double balance = scan.nextInt();
                if (type.equals("credit card")) {
                    double creditLimit = scan.nextDouble();
                    bankAccounts.add(new CreditCard(number,name,type,balance,creditLimit));
                }
                bankAccounts.add(new CheckingAccount(number,name,type,balance));
// capture all of the account attributes
// number
// name
// account type
// if checking read in the balance
// if CC, read in the balance and then the limit
// construct new account object
// add new account to the ArrayList of accounts
                System.out.println("line = " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the accounts file");
            throw new RuntimeException(e);
        }
        scan.close();
// open scanner for kb
// loop to ask the end user for their data
// while hasNext() ...
// prompt for acct number
// report an error if ot a valid acct
// prompt for the amount to withdraw
// look up account type in the arraylist
// if checking
//   proce (read bal)
// if credit card
//   accordingly (read in balance, then the limit)
// process another?
// if yes it continues
// if N (break;!)
//write out the current arraylist to the file
    }
}