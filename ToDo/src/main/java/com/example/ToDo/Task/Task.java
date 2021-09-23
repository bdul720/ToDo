package com.example.ToDo.Task;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String details;
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createDate;
    @UpdateTimestamp
    private Timestamp updateDate;
    private String mode;
    private Long userid;

    public Task() {
    }

    public Task(Long id, String title, String details, Timestamp updateDate, Timestamp createDate,String mode,Long userid) {
        this.id = id;
        this.title = title;
        this.details = details;
        this.updateDate = updateDate;
        this.createDate = createDate;
        this.mode = mode;
        this.userid= userid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }


    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }


    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Long getUserId() {
        return userid;
    }

    public void setUserId(Long userId) {
        this.userid = userId;
    }
}
