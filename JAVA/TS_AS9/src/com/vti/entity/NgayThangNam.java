package com.vti.entity;

public class NgayThangNam {
    public int ngay, thang, nam;

    public class GioPhutGiay {
        public int gio, phut, giay;

        public void xuatThongTin() {
            System.out.println("Ngay " + ngay + "/" + thang + "/" + nam);
            System.out.println("Gio " + gio + ":" + phut + ":" + giay);
        }
    }
}
