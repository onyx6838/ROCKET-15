package com.vti.entity.ex4;

import java.util.Comparator;

/// ??? extend Number ??
public class MyNumber<N extends Comparable<N>> implements Comparator<N> {
    private N number;

    public MyNumber(N number) {
        this.number = number;
    }

    public N getNumber() {
        return number;
    }

    public void setNumber(N number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "MyNumber{" +
                "number=" + number +
                '}';
    }

    @Override
    public int compare(N o1, N o2) {
        return o1.compareTo(o2);
    }
}
