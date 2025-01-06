package com.example.enrollment1;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Інтерфейс для роботи з базою даних через JPA
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    
    // Метод для отримання списку записів за userId
    List<Enrollment> findByUserId(Long userId);
}
