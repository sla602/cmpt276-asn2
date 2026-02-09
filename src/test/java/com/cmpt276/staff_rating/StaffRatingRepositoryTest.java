package com.cmpt276.staff_rating;

import com.cmpt276.staff_rating.entity.StaffRating;
import com.cmpt276.staff_rating.repository.StaffRatingRepository;
import com.cmpt276.staff_rating.entity.RoleType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class StaffRatingRepositoryTest {

    @Autowired
    private StaffRatingRepository repository;

    @Test
    void saveAndFindRating() {
        StaffRating rating = new StaffRating();
        rating.setName("Test Prof");
        rating.setEmail("test@uni.ca");
        rating.setRoleType(RoleType.PROF);
        rating.setClarity(8);
        rating.setNiceness(7);
        rating.setKnowledgeableScore(9);

        StaffRating saved = repository.save(rating);

        assertThat(saved.getId()).isNotNull();

        StaffRating found = repository.findById(saved.getId()).orElse(null);
        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo("Test Prof");
    }

    @Test
    void deleteRating_removesEntry() {
        StaffRating rating = new StaffRating();
        rating.setName("Delete Me");
        rating.setEmail("delete@uni.ca");
        rating.setRoleType(RoleType.TA);
        rating.setClarity(5);
        rating.setNiceness(6);
        rating.setKnowledgeableScore(7);

        StaffRating saved = repository.save(rating);
        Long id = saved.getId();

        repository.deleteById(id);

        assertThat(repository.findById(id)).isEmpty();
    }
}
