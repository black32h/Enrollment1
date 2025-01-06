package com.example.enrollment1;

import org.springframework.stereotype.Service;

import java.util.List;

// Сервіс для обробки логіки роботи з записами
@Service
public class EnrollmentService {
    
    private final EnrollmentRepository enrollmentRepository;

    // Конструктор для ін'єкції залежності
    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    // Метод для запису студента на курс
    public Enrollment enrollStudent(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);  // Збереження запису в базі даних
    }

    // Метод для отримання запису за ID
    public Enrollment getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Enrollment not found"));
        // Якщо запис не знайдений, кидається виняток
    }

    // Метод для отримання всіх записів для конкретного користувача
    public List<Enrollment> getEnrollmentsByUserId(Long userId) {
        return enrollmentRepository.findByUserId(userId);  // Пошук записів по userId
    }

    // Метод для видалення запису за ID
    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);  // Видалення запису з бази даних
    }
}
