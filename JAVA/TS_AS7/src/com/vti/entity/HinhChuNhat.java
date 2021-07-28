package com.vti.entity;

import com.vti.config.exception.HinhHocException;

public class HinhChuNhat extends HinhHoc {
    public HinhChuNhat() {
    }

    public HinhChuNhat(float a, float b) throws HinhHocException {
        super(a, b);
    }

    @Override
    public float dienTich(float a, float b) {
        return a * b;
    }

    @Override
    public float chuVi(float a, float b) {
        return (a + b) * 2;
    }
}
