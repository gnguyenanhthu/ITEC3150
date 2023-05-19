package edu.ggc.itec;

import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class TimeCapsuleMain {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // TODO implement according to the specification

        LinkedList<TimeCapsule> timeCapsules = new LinkedList<TimeCapsule>();
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("timecapsuleinfo.bin"));

        //I borrow code from TimeCapsuleTest.java
        TimeCapsule result = null;
        while (true) {
            try {
                result = (TimeCapsule) input.readObject();
                timeCapsules.add(result);
            } catch (EOFException e) {
                break;
            }
        }

        System.out.println("There are " + timeCapsules.size() + " entries in timecapsuleinfo.bin\n");
        for (TimeCapsule t :timeCapsules){
            System.out.println(t);
        }
        input.close();
    }
}
