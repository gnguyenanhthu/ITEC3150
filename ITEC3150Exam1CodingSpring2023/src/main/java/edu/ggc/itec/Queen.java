package edu.ggc.itec;

public class Queen implements Comparable<Queen>{

    private String name;
    private int birthYear, beginReignYear, endReignYear;

    public Queen(String name, int birthYear, int beginReignYear, int endReignYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.beginReignYear = beginReignYear;
        this.endReignYear = endReignYear;
    }

    @Override
    public boolean equals(Object obj) {
        Queen other = (Queen)obj;
        return this.name.equals(other.name) && this.birthYear == other.birthYear;
    }

    @Override
    public String toString() {
        return "Queen{" +
                "name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", beginReignYear=" + beginReignYear +
                ", endReignYear=" + endReignYear +
                '}';
    }

    public int getBirthYear() {return birthYear;}
    public int getBeginReignYear() {return beginReignYear;}
    public int getEndReignYear() {return endReignYear;}
    public String getName() {return  name;}

    public int getReign() { return endReignYear - beginReignYear;}

    @Override
    public int compareTo(Queen other) {
        if (getReign() < other.getReign())
            return getReign() - other.getReign();
        else if (getReign() > other.getReign())
            return getReign() + other.getReign();
        else
            return 0;
    }
}
