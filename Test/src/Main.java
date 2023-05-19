/**COPYRIGHT (C) 2023 Anh Thu Nguyen. All Rights Reserved.
Classes to manipulate widgets. Solves ITEC3150 Binary File Writing Assignment
@author Anh Thu Nguyen
@version 1.8 02-01-2023
I conformed to GGC’s academic integrity policies when creating this code – Anh Thu Nguyen 01-Feb-2023 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Account> accounts = new ArrayList<>();
        File accountsFile = new File("accounts.txt");
        Scanner scan;
        try {
            scan = new Scanner(accountsFile);
            while (scan.hasNext()) {
                int number = scan.nextInt();
                String temp = scan.nextLine();
                String name = scan.nextLine();
                String type = scan.nextLine();
                double balance = scan.nextDouble();
                accounts.add(new Account(number, name, balance, type));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the accounts text file");
            throw new RuntimeException(e);
        }
        scan.close();

        for (Account a : accounts)
        {
            System.out.println(a);
        }

        DataOutputStream dos;
        try {
            dos = new DataOutputStream(new FileOutputStream("accounts.bin"));
            for (Account a : accounts){
                dos.writeByte(a.getAccountNumber());
                dos.writeUTF(a.getAccountHolderName());
                dos.writeUTF(a.getAccountType());
                dos.writeDouble(a.getBalance());
            }
            System.out.println("Total bytes written: " + dos.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        dos.close();
    }
}