package com.cmpt276.staff_rating;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.cmpt276.staff_rating.entity.RoleType;
import com.cmpt276.staff_rating.entity.StaffRating;

public class StaffRatingTest {
    @Test
    void displayTitleUsesTAProfile() {
        StaffRating rating = new StaffRating();
        rating.setName("Alex");
        rating.setRoleType(RoleType.TA);

        assertEquals("Teaching Assistant Alex", rating.getDisplayTitle());
    }

    @Test
    void displayTitleUsesProfessorProfile() {
        StaffRating rating = new StaffRating();
        rating.setName("Smith");
        rating.setRoleType(RoleType.PROF);

        assertEquals("Professor Smith", rating.getDisplayTitle());
    }
}