package com.example.student_task_manager.repo;

import com.example.student_task_manager.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
}
