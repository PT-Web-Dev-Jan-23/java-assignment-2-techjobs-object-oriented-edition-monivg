package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job1 instanceof Job);
        assertEquals("Product tester", job1.getName());
        assertEquals(new Employer("ACME"), job1.getEmployer());
        assertEquals(new Location("Desert"), job1.getLocation());
        assertEquals(new PositionType("Quality control"), job1.getPositionType());
        assertEquals(new CoreCompetency("Persistence"),job1.getCoreCompetency());
    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotEquals(job1.getId(), job2.getId());

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String stringJob1 = job1.toString();
        assertTrue(stringJob1.startsWith("\n"));
        assertTrue(stringJob1.endsWith("\n"));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String job1String = job1.toString();
        assertTrue(job1String.contains("\n ID: "+ job1.getId()));
        assertTrue(job1String.contains("\n Name: Product tester"));
        assertTrue(job1String.contains("\n Employer: ACME"));
        assertTrue(job1String.contains("\n Location: Desert"));
        assertTrue(job1String.contains("\n Position Type: Quality control"));
        assertTrue(job1String.contains("\n Core Competency: Persistence"));
    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String jobString = job.toString();
        assertEquals("\n ID: " + job.getId() +
                "\n Name: Data not available" +
                "\n Employer: Data not available" +
                "\n Location: Data not available" +
                "\n Position Type: Data not available"+
                "\n Core Competency: Data not available" +
                "\n", jobString);
    }
}
