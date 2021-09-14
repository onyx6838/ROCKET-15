package com.vti.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "question", schema = "hb_ts_as5", catalog = "")
public class Question {
    private Object questionId;
    private String content;
    private Object categoryId;
    private Object typeId;
    private Object creatorId;
    private Timestamp createDate;

    @Id
    @Column(name = "QuestionID")
    public Object getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Object questionId) {
        this.questionId = questionId;
    }

    @Basic
    @Column(name = "Content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "CategoryID")
    public Object getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Object categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "TypeID")
    public Object getTypeId() {
        return typeId;
    }

    public void setTypeId(Object typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "CreatorID")
    public Object getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Object creatorId) {
        this.creatorId = creatorId;
    }

    @Basic
    @Column(name = "CreateDate")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question that = (Question) o;
        return Objects.equals(questionId, that.questionId) && Objects.equals(content, that.content) && Objects.equals(categoryId, that.categoryId) && Objects.equals(typeId, that.typeId) && Objects.equals(creatorId, that.creatorId) && Objects.equals(createDate, that.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, content, categoryId, typeId, creatorId, createDate);
    }
}
