package com.example.student_task_manager.service;

import com.example.student_task_manager.model.Year;
import com.example.student_task_manager.repo.YearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YearService {

    @Autowired
    private YearRepository yearRepository;

    public List<Year> getAllYears() {
        return yearRepository.findAll();
    }
}
