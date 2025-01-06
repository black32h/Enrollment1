package com.example.enrollment1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")  // Визначаємо шлях до контролера для роботи з записами
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    // Конструктор, який інжектить сервіс для роботи з записами
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    // Ендпоінт для запису студента на курс
    @PostMapping
    public ResponseEntity<Enrollment> enrollStudent(@RequestBody Enrollment enrollment) {
        // Відповідь із записом на курс
        return ResponseEntity.ok(enrollmentService.enrollStudent(enrollment));
    }

    // Ендпоінт для отримання запису за ID
    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> getEnrollment(@PathVariable Long id) {
        // Повертаємо запис по ID
        return ResponseEntity.ok(enrollmentService.getEnrollmentById(id));
    }

    // Ендпоінт для отримання всіх записів студента по userId
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Enrollment>> getEnrollmentsByUser(@PathVariable Long userId) {
        // Повертаємо список записів студента
        return ResponseEntity.ok(enrollmentService.getEnrollmentsByUserId(userId));
    }

    // Ендпоінт для видалення запису по ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
        // Видаляємо запис за ID
        enrollmentService.deleteEnrollment(id);
        // Повертаємо статус 204 (No Content) після успішного видалення
        return ResponseEntity.noContent().build();
    }
}
