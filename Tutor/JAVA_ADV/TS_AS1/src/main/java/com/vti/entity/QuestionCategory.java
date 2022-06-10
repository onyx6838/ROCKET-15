package com.vti.entity;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "question_categories")
public class QuestionCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private short id;

    @Column(name = "category_name", length = 20, nullable = false)
    private String categoryName;

    @OneToMany(mappedBy = "questionCategory")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Exam> exams;
}
