package com.vti.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @Column(name = "ExamID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int examId;

    @Column(name = "Code", length = 10, nullable = false)
    private String code;

    @Column(name = "Title", length = 50, nullable = false)
    private String title;
    private Object categoryId;

    @Column(name = "Duration", nullable = false, columnDefinition = "int default 100")
    private int duration;

    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;


}
