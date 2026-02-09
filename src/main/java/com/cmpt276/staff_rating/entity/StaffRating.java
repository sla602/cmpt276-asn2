package com.cmpt276.staff_rating.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

import com.cmpt276.staff_rating.profile.ProfessorProfile;
import com.cmpt276.staff_rating.profile.StaffMemberProfile;
import com.cmpt276.staff_rating.profile.TAProfile;

@Entity
public class StaffRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name is required")
    @Size(min = 2, max = 50, message = "name must be between 2 and 50 characters")
    private String name;

    @NotBlank
    @Email(message = "Invalid email format")
    @Column(unique = true)
    private String email;

    @NotNull(message = "Role type is required")
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Min(value = 1, message = "Clarity must be between 1 and 10")
    @Max(value = 10, message = "Clarity must be between 1 and 10")
    private int clarity;

    @Min(value = 1, message = "Niceness must be between 1 and 10")
    @Max(value = 10, message = "Niceness must be between 1 and 10")
    private int niceness;

    @Min(value = 1, message = "Knowledgeable Score must be between 1 and 10")
    @Max(value = 10, message = "Knowledgeable Score must be between 1 and 10")
    private int knowledgeableScore;

    @Size(max = 300, message = "Comment must be at most 300 characters")
    private String comment;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public int getClarity() {
        return clarity;
    }

    public void setClarity(int clarity) {
        this.clarity = clarity;
    }

    public int getNiceness() {
        return niceness;
    }

    public void setNiceness(int niceness) {
        this.niceness = niceness;
    }

    public int getKnowledgeableScore() {
        return knowledgeableScore;
    }

    public void setKnowledgeableScore(int knowledgeableScore) {
        this.knowledgeableScore = knowledgeableScore;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Transient
    public String getDisplayTitle() {
        StaffMemberProfile profile;
        switch (this.roleType) {
            case TA -> profile = new TAProfile();
            case PROF -> profile = new ProfessorProfile();
            default -> profile = name -> name;           
        }
        return profile.displayTitle(this.name);
    }

    public double getOverallScore() {
    return (clarity + niceness + knowledgeableScore) / 3.0;
}


}

