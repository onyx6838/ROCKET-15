package com.vti.entity;

import com.vti.entity.enumerate.QuestionTypeName;
import com.vti.entity.enumerate.QuestionTypeNameConverter;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "question_types")
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private short id;

    @Column(name = "type_name", nullable = false)
    @Convert(converter = QuestionTypeNameConverter.class)
    private QuestionTypeName typeName;
}
