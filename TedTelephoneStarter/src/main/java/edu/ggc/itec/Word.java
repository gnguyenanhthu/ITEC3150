package edu.ggc.itec;

// created to solve Homework 5 R Lutz 4 /2022

class Word implements Comparable<Word> {

    private int occurrences = 0;
    private final String content;

    public Word(String s) {
        this.content = s;
        occurrences = 1;
    }

    @Override
    public int compareTo(Word other) {
        return content.compareTo(other.content);
    }

    public void incrementOccurrences() {
        occurrences++;
    }

    @Override
    public String toString() {
        return content + ", count=" + occurrences;
    }
}
