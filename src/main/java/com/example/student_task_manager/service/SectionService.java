package com.example.student_task_manager.service;

import com.example.student_task_manager.model.Section;
import com.example.student_task_manager.repo.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService {

    @Autowired
    private SectionRepository sectionRepository;


    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }
}
