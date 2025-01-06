package com.example.enrollment1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
public class Enrollment {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId; // ID студента
    private Long courseId; // ID курсу

    // Геттер для id
    public Long getId() {
        return id;
    }

    // Сеттер для id
    public void setId(Long id) {
        this.id = id;
    }

    // Геттер для userId
    public Long getUserId() {
        return userId;
    }

    // Сеттер для userId
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // Геттер для courseId
    public Long getCourseId() {
        return courseId;
    }

    // Сеттер для courseId
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
