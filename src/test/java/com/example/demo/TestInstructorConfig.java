package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestInstructorConfig {
    
    @Autowired
    @Qualifier("tcUsaInstructors")
    private Instructors usaInstructors;
    
    @Autowired
    @Qualifier("tcUkInstructors")
    private Instructors ukInstructors;
    
    @Autowired
    private Instructors instructors; // Should get @Primary bean (all instructors)
    
    @Test
    public void testTcUsaInstructors() {
        assertNotNull(usaInstructors);
        assertEquals(2, usaInstructors.size());
    }
    
    @Test
    public void testTcUkInstructors() {
        assertNotNull(ukInstructors);
        assertEquals(2, ukInstructors.size());
    }
    
    @Test
    public void testInstructors() {
        // The @Primary bean should contain all instructors
        assertNotNull(instructors);
        assertEquals(4, instructors.size()); // 2 USA + 2 UK = 4 total
    }
    
    @Test
    public void testInstructorsContainsAll() {
        // Verify the primary bean actually contains instructors from both regions
        Instructor kris = instructors.findById(1L);
        Instructor tariq = instructors.findById(3L);
        
        assertNotNull(kris);
        assertNotNull(tariq);
        assertEquals("Kris", kris.getName());
        assertEquals("Tariq", tariq.getName());
    }
}