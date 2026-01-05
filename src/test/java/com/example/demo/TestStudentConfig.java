package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestStudentConfig {
    
    @Autowired
    @Qualifier("students")
    private Students currentStudents;
    
    @Autowired
    private Students previousStudents;
    
    @Test
    public void testCurrentStudents() {
        // Verify current students bean is not null
        assertNotNull(currentStudents);
        
        // Verify it has the correct number of students
        assertEquals(3, currentStudents.size());
        
        // Optional: verify specific students exist
        Student cole = currentStudents.findById(1L);
        assertNotNull(cole);
        assertEquals("Cole", cole.getName());
    }
    
    @Test
    public void testPreviousStudents() {
        // Verify previous students bean is not null
        assertNotNull(previousStudents);
        
        // Verify it has the correct number of students
        assertEquals(2, previousStudents.size());
    }
}