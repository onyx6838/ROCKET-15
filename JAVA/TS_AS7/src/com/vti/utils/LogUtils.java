package com.vti.utils;

import com.vti.config.exception.MyException;

import java.time.LocalDate;
import java.util.Date;

public class LogUtils {
    public static void writeLog(String message, String reason, StackTraceElement[] stackTraceElement, Date time) throws Exception {
        StringBuilder content = new StringBuilder();
        content.append("Log date " + time);
        content.append("\nMessage: " + message);
        content.append("\nReason: " + reason);
        for (int i = 0; i < stackTraceElement.length; i++) {
            content.append("\nStackTrace File " + stackTraceElement[i].getFileName());
            content.append("\nStackTrace Method " + stackTraceElement[i].getMethodName());
            content.append("\nStackTrace Class " + stackTraceElement[i].getClassName());
        }

        IOManager.writeFile("D:\\1. VTI\\RK15 - GIT\\JAVA\\TS_AS7\\resources\\Log.txt", true, content.toString());
    }

    public static void writeLog(MyException exception) throws Exception {
        StringBuilder content = new StringBuilder();
        content.append("Log date " + LocalDate.now());
        content.append("Message: " + exception.getMessage());
        content.append("\nReason: " + exception.getCause().getMessage());
        for (int i = 0; i < exception.getStackTrace().length; i++) {
            content.append("StackTrace File " + exception.getStackTrace()[i].getFileName());
            content.append("StackTrace Method " + exception.getStackTrace()[i].getMethodName());
            content.append("StackTrace Class " + exception.getStackTrace()[i].getClassName());
        }

        IOManager.writeFile("D:\\Self\\Learn\\ROCKET-15\\JAVA\\TS_AS7\\resources\\Log.txt", true, content.toString());
    }

    public static void readLog() throws Exception {
        System.out.println(IOManager.readFile("D:\\1. VTI\\RK15 - GIT\\JAVA\\TS_AS7\\resources\\Log.txt"));
    }
}
