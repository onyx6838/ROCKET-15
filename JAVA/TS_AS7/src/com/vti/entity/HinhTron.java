package com.vti.entity;

import com.vti.config.exception.HinhHocException;
import com.vti.config.variable.FinalVariable;

public class HinhTron extends HinhHoc {
    public HinhTron() {
    }

    public HinhTron(float a, float b) throws HinhHocException {
        super(a, b);
    }

    @Override
    public float dienTich(float a, float b) {
        return FinalVariable.PI * a * b; // a * a
    }

    @Override
    public float chuVi(float a, float b) {
        return 2 * FinalVariable.PI * a;
    }
}
