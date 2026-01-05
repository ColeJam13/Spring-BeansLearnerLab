package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Alumni {
    
    @Autowired
    @Qualifier("previousStudents")
    private Students students;
    
    @Autowired
    private Instructors instructors;
    
    @PostConstruct
    public void executeBootcamp() {
        double totalNumberOfHours = 1200.0;
        
        for (Student student : students) {
            double hoursPerStudent = totalNumberOfHours;

            for (Instructor instructor : instructors) {
                instructor.teach(student, hoursPerStudent / instructors.size());
            }
        }
    }
    
    public Students getStudents() {
        return this.students;
    }
    
    public Instructors getInstructors() {
        return this.instructors;
    }
}