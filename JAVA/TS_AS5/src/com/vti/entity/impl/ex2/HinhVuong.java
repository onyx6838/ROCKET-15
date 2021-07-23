package com.vti.entity.impl.ex2;

public class HinhVuong extends HinhChuNhat {
    public HinhVuong(float a) {
        super(a, a);
    }

    @Override
    public float chuVi() {
        System.out.println("CV HV");
        return super.chuVi();
    }

    @Override
    public float dienTich() {
        System.out.println("DT HV");
        return super.dienTich();
    }
}
