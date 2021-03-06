package com.vti.backend;

import com.vti.config.exception.MyException;
import com.vti.entity.ex5.Student;
import com.vti.utils.FileUtils;
import com.vti.utils.IOManager;
import com.vti.utils.LogUtils;

import java.io.File;
import java.util.Scanner;


public class Exercise5 {
    public void Ques1() throws Exception {
        Student student1 = new Student(1, "Nguyễn Văn A");   // use scanner => no param constructor
        Student student2 = new Student(2, "Nguyễn Văn B");
        Student student3 = new Student(3, "Nguyễn Văn C");
        Student[] students = new Student[]{student1, student2, student3};
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < students.length; i++) {
            content.append("Student: " + (i + 1) + "\n");
            content.append("\t\tId: " + students[i].getId());
            content.append("\n\t\tHọ và tên :" + students[i].getName() + "\n");
        }

        IOManager.writeFile("D:\\1. VTI\\RK15 - GIT\\JAVA\\TS_AS7\\resources\\Student.txt", true, content.toString());
        System.out.println("\nRead file put in console");
        System.out.println(IOManager.readFile("D:\\1. VTI\\RK15 - GIT\\JAVA\\TS_AS7\\resources\\Student.txt"));
    }

    public String Ques2(String fileName) throws Exception {
        try (Scanner file = new Scanner(new File(fileName))) {
            if (file.hasNextLine()) {
                return file.nextLine();
            }
            if(!fileName.contains("wrongName.txt")) {
                throw new MyException(
                        "Incorrect filename : " + fileName, new Throwable("Not Contain fileName"));
            }
        } catch (MyException err) {
            LogUtils.writeLog(err);
        }
        return null;
    }
}
