package com.vti.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "exams")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "exam_id")
    private short id;

    @Column(name = "exam_code", length = 10, nullable = false)
    private String examCode;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "duration", nullable = false)
    private short duration;

    @Column(name = "create_date")
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private Account creator;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private QuestionCategory questionCategory;
}
