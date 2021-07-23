package com.vti.entity.impl.ex2;

import com.vti.entity.ex2.IShape;

public class HinhChuNhat implements IShape {
    private float a;
    private float b;

    public HinhChuNhat(float a, float b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public float chuVi() {
        System.out.println("CV HCN");
        return (a + b) * 2;
    }

    @Override
    public float dienTich() {
        System.out.println("DT HCN");
        return a * b;
    }
}
