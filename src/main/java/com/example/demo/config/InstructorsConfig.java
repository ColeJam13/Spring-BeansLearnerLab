package com.example.demo.config;

import com.example.demo.Instructor;
import com.example.demo.Instructors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class InstructorsConfig {
    
    @Bean
    public Instructors tcUsaInstructors() {
        Instructor kris = new Instructor(1L, "Kris");
        Instructor dolio = new Instructor(2L, "Dolio");
        return new Instructors(kris, dolio);
    }

    @Bean
    public Instructors tcUkInstructors() {
        Instructor tariq = new Instructor(3L, "Tariq");
        Instructor frye = new Instructor(4L, "Frye");
        return new Instructors(tariq, frye);
    }

    @Primary
    @Bean
    public Instructors instructors() {
        Instructors allInstructors = new Instructors();
        allInstructors.addAll(tcUsaInstructors());
        allInstructors.addAll(tcUkInstructors());
        return allInstructors;
    }
}
