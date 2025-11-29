package com.example.student_task_manager.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sections")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String section;


}
