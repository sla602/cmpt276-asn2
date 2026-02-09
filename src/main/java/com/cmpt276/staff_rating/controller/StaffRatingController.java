package com.cmpt276.staff_rating.controller;

import com.cmpt276.staff_rating.repository.StaffRatingRepository;
import com.cmpt276.staff_rating.entity.StaffRating;
import com.cmpt276.staff_rating.entity.RoleType;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;





@Controller
public class StaffRatingController {

    private final StaffRatingRepository staffRatingRepository;

    public StaffRatingController(StaffRatingRepository staffRatingRepository) {
        this.staffRatingRepository = staffRatingRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("ratings", staffRatingRepository.findAll());
        return "index";
    }

    @GetMapping("/ratings/new")
    public String showCreateForm(Model model) {
        model.addAttribute("staffRating", new StaffRating());
        model.addAttribute("roleTypes", RoleType.values());
        return "create";
    }

    @PostMapping("/ratings")
    public String createRating(
            @Valid @ModelAttribute("staffRating") StaffRating staffRating,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("roleTypes", RoleType.values());
            return "create";
        }

        staffRatingRepository.save(staffRating);
        return "redirect:/";
    }

    @GetMapping("/ratings/{id}")
    public String ShowDetail(@PathVariable Long id, Model model) {
        StaffRating rating = staffRatingRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid rating id"));
        model.addAttribute("rating", rating);
        return "detail";
    }

    @GetMapping("/ratings/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        StaffRating rating = staffRatingRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid rating id"));

        model.addAttribute("staffRating", rating);
        model.addAttribute("roleTypes", RoleType.values());
        return "edit";
    }

    @PostMapping("/ratings/{id}/edit")
    public String updateRating(
        @PathVariable Long id,
        @Valid @ModelAttribute("staffRating") StaffRating staffRating,
        BindingResult bindingResult,
        Model model) {
            if (bindingResult.hasErrors()) {
                model.addAttribute("roleTypes", RoleType.values());
                return "edit";
            }
            staffRating.setId(id);
            staffRatingRepository.save(staffRating);
            return "redirect:/ratings/" + id;
    }

    @PostMapping("/ratings/{id}/delete")
    public String deleteRating(@PathVariable Long id) {
        staffRatingRepository.deleteById(id);
        return "redirect:/";
    }
    
    
}
