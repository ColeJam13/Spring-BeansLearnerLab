package com.example.demo.config;

import com.example.demo.Student;
import com.example.demo.Students;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    
    @Bean(name = "students")
    public Students currentStudents() {
        Student student1 = new Student(1L, "Cole");
        Student student2 = new Student(2L, "Marc");
        Student student3 = new Student(3L, "Ben");
        return new Students(student1, student2, student3);
    }

    @Bean
    public Students previousStudents() {
        Student student1 = new Student(4L, "Jenn");
        Student student2 = new Student(5L, "Jon");
        return new Students(student1, student2);
    }
}
