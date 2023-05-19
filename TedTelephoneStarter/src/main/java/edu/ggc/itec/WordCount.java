package edu.ggc.itec;

import java.io.*;
import java.util.*;

public class WordCount {

    public static void main(String[] args) {

        BST<Word> tree = new BST<>();

        File textFile = new File("TedAndtheTelephone.txt");
        Scanner scan;

        ArrayList<String> wordList = new ArrayList<>();
        try {
            scan = new Scanner(textFile);
            scan.useDelimiter("[^a-zA-Z]+"); // from SpellCheck.java
            while (scan.hasNext()) {
                    wordList.add(scan.next().toLowerCase());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the accounts file");
            throw new RuntimeException(e);
        }
        scan.close();
;
        // Visit each word in the data
        // create a word object, with a count of 1
        // search for the word in the BST
        for (String s : wordList) {
            Word word = new Word(s);

            // if exists we need to update count
            BST.TreeNode<Word> current = tree.extract(word);
            if (current != null)
                current.element.incrementOccurrences();
            else
                tree.add(word);
        }

        tree.printReverse(); // print reverse results
        //tree.backPrint(); the same but using iterator
    }
}
