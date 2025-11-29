package com.example.student_task_manager.repo;

import com.example.student_task_manager.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section,Integer> {
}
