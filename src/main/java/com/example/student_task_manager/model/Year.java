package com.example.student_task_manager.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "year")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Year {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String year;

    public Year(String year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
