package com.cmpt276.staff_rating;

import org.junit.jupiter.api.Test;

import com.cmpt276.staff_rating.profile.ProfessorProfile;
import com.cmpt276.staff_rating.profile.StaffMemberProfile;
import com.cmpt276.staff_rating.profile.TAProfile;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;


public class StaffMemberProfileTest {

    @Test
    void taProfileFormatsNameCorrectly() {
        StaffMemberProfile profile = new TAProfile();
        assertEquals("Teaching Assistant Alex", profile.displayTitle("Alex"));
    }

    @Test
    void profProfileFormatsNameCorrectly() {
        StaffMemberProfile profile = new ProfessorProfile();
        assertEquals("Professor Smith", profile.displayTitle("Smith"));
    }
}
