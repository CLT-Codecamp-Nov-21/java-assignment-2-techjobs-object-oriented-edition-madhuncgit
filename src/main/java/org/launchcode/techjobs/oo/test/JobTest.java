package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
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
    Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertTrue(newJob instanceof Job);
    assertEquals("Product tester", newJob.getName());
    assertTrue(newJob.getEmployer() instanceof Employer);
    assertEquals("ACME", newJob.getEmployer().getValue());
    assertTrue(newJob.getLocation() instanceof Location);
    assertEquals("Desert", newJob.getLocation().getValue());
    assertTrue(newJob.getPositionType() instanceof PositionType);
    assertEquals("Quality control", newJob.getPositionType().getValue());
    assertTrue(newJob.getCoreCompetency() instanceof CoreCompetency);
    assertEquals("Persistence", newJob.getCoreCompetency().getValue());
}
@Test
    public void testJobsForEquality(){
       Job newJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
       Job newJob2 = new Job ("Product tester", new Employer("ACME"), new Location("Charlotte"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
       assertFalse(newJob1.equals( newJob2));

}
@Test
    public void testToStringStartsAndEndsWithNewLine(){
    Job newJob3 = new Job(" Developer", new Employer("ACME"), new Location("Charlotte"), new PositionType("Development"), new CoreCompetency("Java"));
    assertEquals('\n', newJob3.toString().charAt(0));
    assertEquals('\n', newJob3.toString().charAt(newJob3.toString().length()-1));
}


    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job newJob3 = new Job("Web Developer", new Employer("LaunchCode"), new Location("Charlotte"), new PositionType("Front End Development"), new CoreCompetency("JavaScript"));
        assertEquals("\nID: "+ newJob3.getId() + "\n" +
                "Name: "+ newJob3.getName() + "\n" +
                "Employer: "+ newJob3.getEmployer().getValue() + "\n" +
                "Location: "+ newJob3.getLocation().getValue() + "\n" +
                "Position Type: " + newJob3.getPositionType().getValue() + "\n" +
                "Core Competency: " + newJob3.getCoreCompetency().getValue() + "\n", newJob3.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job newJob4 = new Job("Test ", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals("\nID: " + newJob4.getId() + "\n" +
                "Name: " + newJob4.getName() +"\n" +
                "Employer: Data not available\n" +
                "Location: Data not available\n" +
                "Position Type: Data not available\n" +
                "Core Competency: Data not available\n", newJob4.toString());

    }
}





