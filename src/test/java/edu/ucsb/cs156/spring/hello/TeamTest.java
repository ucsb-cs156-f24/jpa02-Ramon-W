package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
    public void equals_itself() {
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_different_class() {
        String not_a_team = new String("test");
        assertFalse(team.equals(not_a_team));
    }

    @Test
    public void equals_same_team_name_returns_true() {
        Team same_team = new Team("test-team");
        assertTrue(team.equals(same_team));
    }

    @Test
    public void equals_different_team_name_returns_false() {
        Team different_team = new Team("different-team");
        assertFalse(team.equals(different_team));
    }

    @Test
    public void equals_same_team_members_returns_true() {
        team.addMember("test-member");
        Team same_team = new Team("test-team");
        same_team.addMember("test-member");
        assertTrue(team.equals(same_team));
    }

    @Test
    public void equals_different_team_members_returns_false() {
        team.addMember("test-member");
        Team different_team = new Team("test-team");
        different_team.addMember("different-member");
        assertFalse(team.equals(different_team));
    }

    @Test
    public void hashCode_success() {
        assertEquals(team.name.hashCode() | team.members.hashCode(), team.hashCode());
    }

    @Test
    public void hashCode_same_team() {
        team.addMember("bar");
        Team same_team = new Team();
        same_team.setName("test-team");
        same_team.addMember("bar");
        assertEquals(team.hashCode(), same_team.hashCode());
    }

}
