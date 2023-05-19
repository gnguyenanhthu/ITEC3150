import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<>();
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
                accounts.add(new Account(number, name, balance, type));
                System.out.println("line = " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the accounts file");
            throw new RuntimeException(e);
        }
        scan.close();
        while(accounts.hasNext()){
            System.out.println(accounts.next());
        }
    }
}