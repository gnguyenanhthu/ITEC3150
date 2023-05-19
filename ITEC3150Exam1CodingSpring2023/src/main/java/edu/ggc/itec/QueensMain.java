package edu.ggc.itec;

import java.io.*;
import java.util.*;

public class QueensMain {

    public static void main(String[] args) {

        // TODO implement according to the specification
        LinkedList<Queen> queens = new LinkedList<Queen>();
        queens.add(new Queen("Mary I", 1516, 1552, 1558));
        queens.add(new Queen("Elizabeth I", 1533, 1558, 1603));
        queens.add(new Queen("Mary II", 1662, 1689, 1694));
        queens.add(new Queen("Anne", 1665, 1701, 1714));
        queens.add(new Queen("Victoria", 1819, 1837, 1901));
        queens.add(new Queen("Elizabeth II", 1926, 1952, 2022));

        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("queens.dat"));
            for (Queen q : queens) {
                dos.writeUTF(q.getName());
                dos.writeInt(q.getBirthYear());
                dos.writeInt(q.getBeginReignYear());
                dos.writeInt(q.getEndReignYear());
            }
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Check writing binary
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream("queens.dat"));
            while (dis.available() > 0) {
                String name = dis.readUTF();
                int birth = dis.readInt();
                int begin = dis.readInt();
                int end = dis.readInt();
                Queen q = new Queen(name, birth, begin, end);
                System.out.println("Read and construct: " + q);
            }
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //bonus question
        Collections.sort(queens);
        System.out.println("\nAfter sorted: ");
        for (Queen q : queens){
            System.out.println(q.getName() + " reigned for " + q.getReign() + " years");
        }
    }

}
