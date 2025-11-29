package com.example.student_task_manager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.text.DateFormat;
import java.util.Date;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "name required")
    private String name;

    @NotNull(message = "date of birth is required")
    @NotBlank(message = "date of birth is required")
    private String dob;

    @NotNull(message = "Course is required")
    @ManyToOne
    private Course course;

    @NotNull(message = "Year is required")
    @ManyToOne
    private Year year;

    @NotNull(message = "Section is required")
    @ManyToOne
    private Section section;

    @NotNull(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    @Column(unique = true)
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
