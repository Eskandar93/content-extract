package com.content.contentextract.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "course_generation_logs")
public class CourseGenerationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String parentPageUrl;

    @Column(nullable = false)
    private String courseTitle;

    @Column(nullable = false)
    private String targetLevel;

    @Column(nullable = false)
    private boolean includeQuizzes;

    @Column(nullable = false)
    private String status; // ANALYZED, SUCCESS, FAILED

    private String createdCourseUrl;

    @Column(columnDefinition = "TEXT")
    private String errorMessage;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
