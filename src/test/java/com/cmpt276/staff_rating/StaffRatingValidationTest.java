package com.cmpt276.staff_rating;

import com.cmpt276.staff_rating.entity.StaffRating;
import com.cmpt276.staff_rating.entity.RoleType;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class StaffRatingValidationTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void invalidEmail_isRejected() {
        StaffRating rating = new StaffRating();
        rating.setName("Test");
        rating.setEmail("not-an-email");
        rating.setRoleType(RoleType.PROF);
        rating.setClarity(5);
        rating.setNiceness(5);
        rating.setKnowledgeableScore(5);

        Set<ConstraintViolation<StaffRating>> violations = validator.validate(rating);

        assertThat(violations).isNotEmpty();
    }

    @Test
    void scoreOutOfRange_isRejected() {
        StaffRating rating = new StaffRating();
        rating.setName("Test");
        rating.setEmail("test@uni.ca");
        rating.setRoleType(RoleType.TA);
        rating.setClarity(20); // ❌
        rating.setNiceness(5);
        rating.setKnowledgeableScore(5);

        Set<ConstraintViolation<StaffRating>> violations = validator.validate(rating);

        assertThat(violations).isNotEmpty();
    }
}
