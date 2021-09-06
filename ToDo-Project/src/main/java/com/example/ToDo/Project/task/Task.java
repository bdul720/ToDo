package com.example.ToDo.Project.task;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Task {

    @Id
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"
    )
    private Long id;
    private String title;
    private String details;
    private LocalDate updateDate;
    private LocalDate createDate;
    private Long mode;

    public Task() {
    }

    public Task(Long id,
                String title,
                String details,
                LocalDate updateDate,
                LocalDate createDate,
                Long mode) {
        this.id = id;
        this.title = title;
        this.details = details;
        this.updateDate = updateDate;
        this.createDate = createDate;
        this.mode = mode;
    }

    public Task(String title,
                String details,
                LocalDate updateDate,
                LocalDate createDate,
                Long mode) {
        this.title = title;
        this.details = details;
        this.updateDate = updateDate;
        this.createDate = createDate;
        this.mode = mode;
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

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Long getMode() {
        return mode;
    }

    public void setMode(Long mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", updateDate=" + updateDate +
                ", createDate=" + createDate +
                ", mode=" + mode +
                '}';
    }
}
