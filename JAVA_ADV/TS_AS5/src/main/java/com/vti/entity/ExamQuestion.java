package com.vti.entity;

import com.vti.entity.primarykey.ExamQuestionPK;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@SuppressWarnings("JpaModelReferenceInspection")
@Data
@NoArgsConstructor
@Entity
@Table(name = "examquestion", schema = "hb_ts_as5", catalog = "")
public class ExamQuestion {
    @EmbeddedId
    private ExamQuestionPK id;

    @ManyToOne
    @MapsId("ExamID")
    @JoinColumn(name = "ExamID")
    private Exam exam;

    @ManyToOne
    @MapsId("QuestionID")
    @JoinColumn(name = "QuestionID")
    private Question question;


}
