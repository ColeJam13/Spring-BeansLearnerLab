package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestClassroomConfig {
    
    @Autowired
    @Qualifier("currentCohort")
    private Classroom currentClassroom;
    
    @Autowired
    @Qualifier("previousCohort")
    private Classroom previousClassroom;
    
    @Test
    public void testCurrentCohort() {
        assertNotNull(currentClassroom);
        
        // Verify it has the correct instructors and students
        assertNotNull(currentClassroom.getInstructors());
        assertNotNull(currentClassroom.getStudents());
        
        assertEquals(4, currentClassroom.getInstructors().size()); // All instructors
        assertEquals(3, currentClassroom.getStudents().size()); // Current students
    }
    
    @Test
    public void testPreviousCohort() {
        assertNotNull(previousClassroom);
        
        // Verify it has the correct instructors and students
        assertNotNull(previousClassroom.getInstructors());
        assertNotNull(previousClassroom.getStudents());
        
        assertEquals(4, previousClassroom.getInstructors().size()); // All instructors
        assertEquals(2, previousClassroom.getStudents().size()); // Previous students (2)
    }
    
    @Test
    public void testCurrentCohortHasCorrectStudents() {
        Students students = currentClassroom.getStudents();
        
        // Verify we have the current cohort students, not previous
        Student cole = students.findById(1L);
        assertNotNull(cole);
        assertEquals("Cole", cole.getName());
    }
    
    @Test
    public void testPreviousCohortHasCorrectStudents() {
        Students students = previousClassroom.getStudents();
        
        // Verify we have the previous cohort students
        Student jenn = students.findById(4L);
        assertNotNull(jenn);
        assertEquals("Jenn", jenn.getName());
    }
}