package com.cmpt276.staff_rating.profile;

public class ProfessorProfile implements StaffMemberProfile {
    @Override
    public String displayTitle(String name) {
        return "Professor " + name;
    }
}
