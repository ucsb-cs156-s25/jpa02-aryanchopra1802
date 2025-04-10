package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }
   
   @Test
   public void equals_testing_same_object()
   {
        Team team3 = new Team("test-team");
        // assertEquals(true, team.equals(team));
        assertEquals(team3, team3, "same team equal");       // TT

   }

   @Test
   public void equals_testing_different_object()
   {
        String s = "";
        assertEquals(false, team.equals(s));

   }

   @Test
   public void equals_testing_different_team()
   {
        team.addMember("test-member1");
        Team team2 = new Team("test-team2");
        team2.addMember("test-member2");
        assertEquals(false, team.equals(team2));       // FF  

        Team team_copy = new Team("test-team");
        team_copy.addMember("test-member1");
        assertEquals(true, team.equals(team_copy));    // TT

        Team team_false_copy = new Team("test-team");
        team_false_copy.addMember("test-member2");
        assertEquals(false, team.equals(team_false_copy)); // TF
       
   }

   @Test
   public void testing_hashCode(){
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        Team t3 = new Team();
        t3.setName("foo");
        t3.addMember("ikd");
        Team t4 = new Team();
        t4.setName("fol");
        t4.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
        assertEquals(false, t3.hashCode() == t4.hashCode());
        assertEquals(t1.hashCode()==t3.hashCode(), false);

        // instantiate t as a Team object
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
   }



    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
