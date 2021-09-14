package com.vti.entity.primarykey;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class ExamQuestionPK implements Serializable {
    @Column(name = "ExamID")
    private int examId;

    @Column(name = "QuestionID")
    private int questionId;

}
