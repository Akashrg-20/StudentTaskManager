package com.example.student_task_manager.service;

import com.example.student_task_manager.exception.NoDataFoundException;
import com.example.student_task_manager.model.Student;
import com.example.student_task_manager.repo.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;

    // SAVE STUDENT
    public void createStudent(Student student) {
        studentRepo.save(student);
    }


    //  GET ALL STUDENTS
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }


    // GET STUDENT BY ID
    public Student getStudentById(int id) throws NoDataFoundException {
        return studentRepo.findById(id).orElseThrow(() ->
                new NoDataFoundException("No student found by id:"+id));
    }


    // SEARCH STUDENT BY name, course, year, section
    public List<Student> findStudentsByDetails(String keyword) throws Exception{
        List<Student> students = studentRepo
                .findByNameIgnoreCaseOrDobIgnoreCaseOrCourse_CourseIgnoreCaseOrYear_YearIgnoreCaseOrSection_SectionIgnoreCase(keyword, keyword, keyword, keyword, keyword);

        if (!students.isEmpty()){
            return students;
        }

        throw new NoDataFoundException("No data found");
    }


    // DELETE STUDENT BY ID
    public void deleteStudentById(int id) {
        studentRepo.deleteById(id);
    }


    // UPDATE EXIST STUDENT
    public void updateStudent(Student student){
            studentRepo.save(student);
    }

}
