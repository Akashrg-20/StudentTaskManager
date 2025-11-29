package com.example.student_task_manager.repo;

import com.example.student_task_manager.model.Course;
import com.example.student_task_manager.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {


    // FILTER STUDENT By name,course,section,year
    List<Student> findByNameIgnoreCaseOrDobIgnoreCaseOrCourse_CourseIgnoreCaseOrYear_YearIgnoreCaseOrSection_SectionIgnoreCase(String name,String dob,String course,String year,String section);

}
