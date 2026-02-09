package com.cmpt276.staff_rating.repository;

import com.cmpt276.staff_rating.entity.StaffRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRatingRepository extends JpaRepository<StaffRating, Long> {
    boolean existsByEmail(String email);
    boolean existsByEmailAndIdNot(String email, Long id);

}
