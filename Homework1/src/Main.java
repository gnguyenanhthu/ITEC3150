/**COPYRIGHT (C) 2023 Anh Thu Nguyen. All Rights Reserved.
 Classes to manipulate widgets. Solves ITEC3150 Homework1
 @author Anh Thu Nguyen
 @version 1.8 02-06-2023
 I conformed to GGC’s academic integrity policies when creating this code – Anh Thu Nguyen 06-Feb-2023 */


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //need to establish array for accounts
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();
        //open the input file for reading (From previous assignment)
        File accountsFile = new File("accounts.txt");
        Scanner scan;
        try {
            scan = new Scanner(accountsFile);
            while (scan.hasNext()) {
                int number = scan.nextInt();
                String line = scan.nextLine();
                String name = scan.nextLine();
                String type = scan.nextLine();
                double balance = scan.nextInt();
                if (type.equals("credit card")) {
                    double creditLimit = scan.nextDouble();
                    bankAccounts.add(new CreditCard(number, name, type, balance, creditLimit));
                }
                bankAccounts.add(new CheckingAccount(number, name, type, balance));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the accounts file");
            throw new RuntimeException(e);
        }
        scan.close();

        Scanner input = new Scanner(System.in);
        String anotherTransaction = "Y";
        do {
            System.out.print("Please enter an account number: ");
            int accountNumber = input.nextInt();
            //check valid account number
            while (checkAccountNumber(accountNumber, bankAccounts) < 0) {
                System.out.println("I’m sorry I cannot find that account - please try again.");
                System.out.print("Please enter an account number: ");
                accountNumber = input.nextInt();
            }
            BankAccount currentAccount = bankAccounts.get(checkAccountNumber(accountNumber, bankAccounts)); //get the current account
            System.out.print("Please enter amount of desired cash: ");
            double desiredCash = input.nextDouble();
            if (currentAccount.checkLimit(desiredCash)) {
                if (currentAccount.getType().equalsIgnoreCase("credit card"))
                    System.out.println("This is a credit card account, pick up cash in cash slot, your new balance is $" + currentAccount.withdraw(desiredCash));
                else
                    System.out.println("This is a checking account, pick up cash in cash slot. Your new balance is $" + currentAccount.withdraw(desiredCash));
            } else if (currentAccount.getType().equalsIgnoreCase("credit card"))
                System.out.println("I’m sorry this will exceed your credit limit. Please try another account.");
            else
                System.out.println("I’m sorry this will exceed the balance you have. Please try another account.");
            System.out.print("Do you want another transaction (Yes/No)? ");
            String temp = input.nextLine();
            anotherTransaction = input.nextLine();
        } while (anotherTransaction.equalsIgnoreCase("Y"));

        //output to text file
        PrintWriter outputFile;
        File accountTestFile = new File("accountTest.txt");
        try {
            outputFile = new PrintWriter(accountTestFile);
            for (BankAccount a : bankAccounts) {
                outputFile.print(a);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error opening the accountsTest file");
            throw new RuntimeException(e);
        }
        outputFile.close();

        //output to console
        for (BankAccount a : bankAccounts){
            System.out.print(a);
        }
    }

    //Check account number and get its index inside the list
    public static int checkAccountNumber(int x, ArrayList<BankAccount> list) {
        for (int i = 0; i < list.size(); i++) {
            if (x == list.get(i).getAccountNumber()) {
                return i;
            }
        }
        return -1;
    }

}