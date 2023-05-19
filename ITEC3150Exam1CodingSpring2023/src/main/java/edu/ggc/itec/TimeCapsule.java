package edu.ggc.itec;

import java.io.Serializable;

public class TimeCapsule implements Comparable<TimeCapsule>, Serializable {

    private static final long serialVersionUID = 1L;

    private int year;
    private String message;

    public TimeCapsule(String message, int year) {
        this.message = message;
        this.year = year;
    }

    @Override
    public boolean equals(Object obj) {
        TimeCapsule other = (TimeCapsule) obj;
        return (this.message.equals(other.message) && this.year == other.year);
    }

    @Override
    public String toString() {
        String format = "TimeCapsule{year=%d, message='%s'}";
        return String.format(format, year, message);
    }

    @Override
    public int compareTo(TimeCapsule other) {
        if (this.year < other.year)
            return this.year - other.year;
        else if (this.year > other.year)
            return this.year - other.year;
        else
            return 0;
    }
}
