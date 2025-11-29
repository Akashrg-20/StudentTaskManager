package com.example.student_task_manager.repo;

import com.example.student_task_manager.model.Year;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YearRepository extends JpaRepository<Year,Integer> {
}
