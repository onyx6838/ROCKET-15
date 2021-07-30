package com.vti.utils;

public class MyMath<N extends Number> {

    public N sum(N... numbers) {
        Double sum = 0d;
        for (N t : numbers) {
            sum += t.doubleValue();
        }
        return (N) sum;
    }

    public <N extends Comparable<N>> N maximum(N x, N y, N z) {
        N max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }

    public N subtract(N x, N y) {
        Double subtract = x.doubleValue() - y.doubleValue();
        return (N) subtract;
    }
}
