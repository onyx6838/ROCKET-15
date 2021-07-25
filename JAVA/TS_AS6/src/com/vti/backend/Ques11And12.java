package com.vti.backend;

import com.vti.config.exception.InvalidAgeInputingException;
import com.vti.utils.ScannerUtils;

public class Ques11And12 {
    private int age;

    public void inputAge() throws InvalidAgeInputingException {
        while (true){
            age = ScannerUtils.inputInt("Sai form");
            if (age < 0) {
                throw new InvalidAgeInputingException("The age must be greater than 0");
            } else if (age < 18) {
                System.out.println("Your age must be greater than 18");
            } else return;
        }
    }

}
