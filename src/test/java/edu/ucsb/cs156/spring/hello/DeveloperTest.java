package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
       
        assertEquals("Aryan C.", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId(){
        assertEquals("aryanchopra1802", Developer.getGithubId());
    }

     @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("s25-06", t.getName());
    }

    // @Test
    // public void getTeam_returns_team_with_Aryan() {
    //     Team  t = Developer.getTeam();
    //     assertTrue(t.getMembers().contains("Aryan C."),"Team should contain Amey");
    // }

    // @Test
    // public void getTeam_returns_team_with_Rachit() {
    //     Team  t = Developer.getTeam();
    //     assertTrue(t.getMembers().contains("Rachit G."),"Team should contain Amey");
    // }

    // @Test
    // public void getTeam_returns_team_with_Riya() {
    //     Team  t = Developer.getTeam();
    //     assertTrue(t.getMembers().contains("Riya G."),"Team should contain Amey");
    // }

    // @Test
    // public void getTeam_returns_team_with_Saeed() {
    //     Team  t = Developer.getTeam();
    //     assertTrue(t.getMembers().contains("Saeed A."),"Team should contain Amey");
    // }

    // @Test
    // public void getTeam_returns_team_with_Yarwin() {
    //     Team  t = Developer.getTeam();
    //     assertTrue(t.getMembers().contains("Yarwin L."),"Team should contain Amey");
    // }

    // @Test
    // public void getTeam_returns_team_with_Sanjana() {
    //     Team  t = Developer.getTeam();
    //     assertTrue(t.getMembers().contains("Sanjana J."),"Team should contain Amey");
    // }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Aryan"),"Team should contain Aryan");
        assertTrue(t.getMembers().contains("Rachit"),"Team should contain Rachit");
        assertTrue(t.getMembers().contains("Riya"),"Team should contain Riya");
        assertTrue(t.getMembers().contains("Saeed"),"Team should contain Saeed");
        assertTrue(t.getMembers().contains("Sanjana"),"Team should contain Sanjana");
        assertTrue(t.getMembers().contains("Yarwin"),"Team should contain Yarwin");
        // ... etc
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
