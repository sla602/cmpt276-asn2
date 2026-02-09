package com.cmpt276.staff_rating.profile;

public class TAProfile implements StaffMemberProfile {
    @Override
    public String displayTitle(String name) {
        return "Teaching Assistant " + name;
    }
}
