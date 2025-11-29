package com.example.student_task_manager.controller;

import com.example.student_task_manager.model.Student;
import com.example.student_task_manager.service.CourseService;
import com.example.student_task_manager.service.SectionService;
import com.example.student_task_manager.service.StudentService;
import com.example.student_task_manager.service.YearService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@NoArgsConstructor
public class HomeController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private YearService yearService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private SectionService sectionService;


    // HOME PAGE

    @GetMapping({"","/","/home"})
    public String showIndexPage(Model model) {
        model.addAttribute("students",studentService.getAllStudents());
        return "index";
    }

    // ADD STUDENTS

    @GetMapping("/add-student")
    public String showAddStudentPage(Model model){
        model.addAttribute("student",new Student());
        model.addAttribute("courses",courseService.getAllCourses());
        model.addAttribute("years",yearService.getAllYears());
        model.addAttribute("sections",sectionService.getAllSections());
        return "add_student";
    }


    // SAVE STUDENT

    @PostMapping("/save-student")
    public String createStudent(@Valid @ModelAttribute Student student, BindingResult result,Model model){

        if (result.hasErrors()){
            model.addAttribute("courses",courseService.getAllCourses());
            model.addAttribute("years",yearService.getAllYears());
            model.addAttribute("sections",sectionService.getAllSections());
            return "add_student";
        }
        studentService.updateStudent(student);
        return "redirect:/home";
    }


    // EDIT STUDENT

    @GetMapping("/edit-student/{id}")
    public String editStudentById(@PathVariable int id,Model model) throws Exception {
        model.addAttribute("student",studentService.getStudentById(id));
        model.addAttribute("courses",courseService.getAllCourses());
        model.addAttribute("years",yearService.getAllYears());
        model.addAttribute("sections",sectionService.getAllSections());
        return "add_student";
    }


    // DELETE STUDENT

    @GetMapping("/delete-student/{id}")
    public String deleteStudentById(@PathVariable int id){
        studentService.deleteStudentById(id);
        return "redirect:/home";
    }


    // SEARCH STUDENT BY DETAILS

    @GetMapping("/search")
    public String searchByDetails(@RequestParam(required = false) String keyword,Model model) throws Exception{
        model.addAttribute("students",studentService.findStudentsByDetails(keyword));
        return "index";
    }

}
