package com.vti.backend;

import com.vti.entity.CPU;
import com.vti.entity.Car;
import com.vti.entity.NgayThangNam;
import com.vti.entity.OuterClass;

public class Exercise3 {
    public void Ques1() {
        CPU cpu = new CPU(150000.50f);
        CPU.Processor processor = cpu.new Processor();  // instance inner constructor
        processor.getCache();
    }

    public void Ques2() {
        Car car = new Car("Mazda", "8WD");
        Car.Engine engine = car.new Engine("Crysler");
        System.out.println(engine.getEngineType());
    }

    public void Ques3() {
        OuterClass outerClass = new OuterClass();
        outerClass.show();

        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.show();
    }

    public void Ques4() {
        NgayThangNam date = new NgayThangNam();
        date.ngay = 31;
        date.thang = 10;
        date.nam = 2017;

        NgayThangNam.GioPhutGiay time = date.new GioPhutGiay();
        time.gio = 10;
        time.phut = 15;
        time.giay = 30;
        time.xuatThongTin();
    }
}
