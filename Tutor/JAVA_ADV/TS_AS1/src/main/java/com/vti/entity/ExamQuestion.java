package com.vti.entity;

import com.vti.entity.pk.ExamQuestionId;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "exam_questions")
public class ExamQuestion {
    @EmbeddedId
    private ExamQuestionId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("examId")
    private Exam exam;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("questionId")
    private Question question;

    @Override
    public String toString() {
        return "ExamQuestion{" +
                "id=" + id +
                ", exam=" + exam.getTitle() +
                ", question=" + question.getContent() +
                '}';
    }
}
