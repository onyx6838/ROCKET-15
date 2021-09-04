package com.vti.test;

import java.util.List;

import com.vti.entity.Exam;
import com.vti.repository.ExamRepository;

public class ExamTest {
	public static void main(String[] args) {
		ExamRepository repository = new ExamRepository();

		System.out.println("***********GET ALL EXAMS***********");

		List<Exam> Exams = repository.getAllExams();
		Exams.forEach(System.out::println);

		System.out.println(repository.getCountOfExamCode((short) 80));
//		System.out.println("\n\n***********CREATE EXAMS***********");
//
//		Exam examCreate = new Exam();
//		examCreate.setTitle("Bài thi đầu vào 2");
//		examCreate.setDuration((short) 185);
//
//		repository.createExam(examCreate);

	}
}
