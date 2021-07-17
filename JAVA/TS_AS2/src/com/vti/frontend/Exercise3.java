package com.vti.frontend;

import com.vti.entity.Exam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Exercise3 {
    public static void main(String[] args) {
        Exam exam1 = new Exam();
        exam1.id = 1;
        exam1.code = "JAVA";
        exam1.title = "Bai Ktra JAVA";
        exam1.createDate = LocalDate.now();

        Exam exam2 = new Exam();
        exam2.id = 1;
        exam2.code = "JAVA";
        exam2.title = "Bai Ktra JAVA";
        exam2.createDate = LocalDate.of(2021, 3, 20);
        //exam2.createDate = LocalDate.now();
        Ques1(exam1);
        Exam[] examForQues2 = new Exam[]{exam1, exam2};
        Ques2(examForQues2);
        Ques3(examForQues2);
        Ques4(examForQues2);
        Ques5(examForQues2);
    }

    private static void Ques1(Exam exam) {
        /*In ra thông tin Exam thứ 1 và property create date sẽ được format theo định
        dạng vietnamese*/
        Locale locale = new Locale("vi", "VN");
        // cach 1 dung k can convert
        DateTimeFormatter formatterx = DateTimeFormatter.ofPattern("MMM", locale);
        System.out.println("CreateDate: " + exam.createDate.format(formatterx));

        // cach 2 phai convert
        // DEFAULT - mid
        // LONG - full time
        DateFormat formatter = DateFormat.getDateInstance(DateFormat.LONG,
                locale);
        Date date = Date.from(exam.createDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        String dateCreate = formatter.format(date);
        System.out.println("CreateDate with " + locale + " and Date : " + dateCreate);
    }

    private static void Ques2(Exam[] exams) {
        /*In ra thông tin: Exam đã tạo ngày nào theo định dạng
        Năm – tháng – ngày – giờ – phút – giây*/
        Locale locale = new Locale("vi", "VN");
        String pattern = "yyyy-MM-dd HH:mm:ss a";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        for (Exam ex :
                exams) {
            Date date = Date.from(ex.createDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            System.out.println("CreateDate: " + simpleDateFormat.format(date));
        }
    }

    private static void Ques3(Exam[] exams) {
        //Chỉ in ra năm của create date property trong Question 2
        // cach 1 dung k can convert
        DateTimeFormatter formatterx = DateTimeFormatter.ofPattern("yyyy");
        for (Exam ex :
                exams) {
            System.out.println("CreateDate: " + formatterx.format(ex.createDate));
        }
    }

    private static void Ques4(Exam[] exams) {
        //Chỉ in ra tháng và năm của create date property trong Question 2
        DateTimeFormatter formatterx = DateTimeFormatter.ofPattern("yyyy-MM");
        for (Exam ex :
                exams) {
            System.out.println("CreateDate: " + formatterx.format(ex.createDate));
        }
    }

    private static void Ques5(Exam[] exams) {
        String pattern = "MM-DD";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        for (Exam ex :
                exams) {
            Date date = Date.from(ex.createDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            System.out.println("CreateDate: " + simpleDateFormat.format(date));
        }
    }
}
