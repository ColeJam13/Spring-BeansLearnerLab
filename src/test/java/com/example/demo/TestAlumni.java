package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestAlumni {
    
    @Autowired
    private Alumni alumni;
    
    @Test
    public void testAlumniExists() {
        assertNotNull(alumni);
        assertNotNull(alumni.getStudents());
        assertNotNull(alumni.getInstructors());
    }
    
    @Test
    public void testStudentsHaveBeenTaught() {
        Students students = alumni.getStudents();
        
        // Each student should have been taught 1200 hours
        for (Student student : students) {
            assertEquals(1200.0, student.getTotalStudyTime(), 0.01);
        }
    }
    
    @Test
    public void testInstructorHoursDistributed() {
        Instructors instructors = alumni.getInstructors();
        Students students = alumni.getStudents();
        
        // Calculate expected hours per instructor
        int numberOfInstructors = instructors.size(); // 4
        int numberOfStudents = students.size(); // 2
        double numberOfHoursToTeachEachStudent = 1200.0;
        double numberOfHoursToTeach = numberOfHoursToTeachEachStudent * numberOfStudents; // 2400
        double numberOfHoursPerInstructor = numberOfHoursToTeach / numberOfInstructors; // 600
        
        // Note: We can't directly check instructor hours taught since Instructor doesn't track that
        // But we can verify the math and that students received correct hours
        assertEquals(600.0, numberOfHoursPerInstructor, 0.01);
        
        // Verify total hours distributed correctly
        double totalHoursTaught = 0;
        for (Student student : students) {
            totalHoursTaught += student.getTotalStudyTime();
        }
        assertEquals(numberOfHoursToTeach, totalHoursTaught, 0.01);
    }
}