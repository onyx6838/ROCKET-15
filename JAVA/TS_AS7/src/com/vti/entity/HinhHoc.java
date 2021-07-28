package com.vti.entity;

import com.vti.config.exception.HinhHocException;

public abstract class HinhHoc {
    private float a;
    private float b;

    public static int COUNT = 0;

    public abstract float dienTich(float a, float b);

    public abstract float chuVi(float a, float b);

    public HinhHoc() {
    }

    public HinhHoc(float a, float b) throws HinhHocException {
        COUNT++;
        if (COUNT > 5) {
            throw new HinhHocException("Max 5 hinh");
        } else {
            this.a = a;
            this.b = b;
        }
    }

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }
}
